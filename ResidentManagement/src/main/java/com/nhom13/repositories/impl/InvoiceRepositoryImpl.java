package com.nhom13.repositories.impl;

import com.nhom13.DTOs.InvoiceDTO;
import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;
import com.nhom13.pojo.User;
import com.nhom13.repositories.InvoiceRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Resident> getDetailInvoiceForResident(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery query = b.createQuery(Resident.class);
        Root<Resident> root = query.from(Resident.class);
        root.fetch("invoiceSet", JoinType.LEFT);
        query.select(root).distinct(true);

        Query q = s.createQuery(query);

        List<Resident> residents = q.getResultList();
        Set<String> statuses = Set.of("unpaid", "waiting", "paid");

//        residents.stream().forEach(r -> r.setInvoiceSet(r.getInvoiceSet().stream()
//                .filter(i -> i.getStatus().equals("unpaid"))
//                .collect(Collectors.toSet())));

        residents.forEach(r -> {
            Set<Invoice> invoices = r.getInvoiceSet().stream()
                    .filter(i -> statuses.contains(i.getStatus()))
                    .collect(Collectors.toSet());
            r.setInvoiceSet(invoices);
            r.setUnpaidInvoiceCount(invoices.stream().filter(i -> i.getStatus().equals("unpaid")).count());
            r.setWaitingInvoiceCount(invoices.stream().filter(i -> i.getStatus().equals("waiting")).count());
            r.setPaidInvoiceCount(invoices.stream().filter(i -> i.getStatus().equals("paid")).count());
        });

        return residents;
    }

    @Override
    public Invoice getInvoiceById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Invoice.class, id);
    }


    //Unpaid vừa tạo chưa thanh toán
    //Waiting chờ xác nhận từ admin
    //Paid admin đã xác nhận
    @Override
    public void createOrUpdateInvoice(Invoice invoice) {
        Date currentDate = new Date();
        Session s = this.factory.getObject().getCurrentSession();
        if(invoice.getId() == null) {
            invoice.setStatus("unpaid");
            invoice.setCreatedDate(currentDate);
            s.save(invoice);
        } else
            s.update(invoice);
    }

    @Override
    public void deleteInvoice(int id) {
        Invoice i = this.getInvoiceById(id);
        i.setActive(Short.parseShort("0"));
    }

    public List<Invoice> getByResidentId(int residentId) {
        Session s = factory.getObject().getCurrentSession();
        return s.createQuery("SELECT i FROM Invoice i WHERE i.residentId.id = :residentId", Invoice.class)
                .setParameter("residentId", residentId).getResultList();
    }

    @Override
    public void createInvoices(List<Resident> residents) {
        Session s = factory.getObject().getCurrentSession();

        for (Resident r : residents) {
            Invoice invoice = new Invoice();
            invoice.setResidentId(r);
            invoice.setStatus("unpaid");
            s.save(invoice);

        }
    }

    @Override
    public void createMultiple(List<Invoice> invoices) {
        Session s = factory.getObject().getCurrentSession();
        invoices.forEach(i -> s.save(i));
    }

    @Override
    public List<Object[]> getInvoice(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = b.createQuery(Object[].class);

        Root<Invoice> rI = query.from(Invoice.class);
        Root<Resident> rR = query.from(Resident.class);
        Root<User> rU = query.from(User.class);

        query.multiselect(
                rI.get("id"),
                rI.get("name"),
                rI.get("amount"),
                rI.get("dueDate"),
                rI.get("status"),
                rI.get("paymentProve"),
                rU.get("lastName"),  // Fetch last name from Resident
                rU.get("firstName"), // Fetch first name from Resident
                rI.get("createdDate")  // Updated to match Java camelCase convention
        );

        List<Predicate> predicates = new ArrayList<>();
        // Lấy và xử lý các tham số từ params
        String kw = params.getOrDefault("kw", "");
        String status = params.get("status");
        String isActive = params.get("active");

        // Thêm điều kiện cho từ khóa tìm kiếm (kw)
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(rI.get("name"), String.format("%%%s%%", kw)));
        }

        // Thêm điều kiện cho status
        if (status != null && !status.isEmpty()) {
            predicates.add(b.equal(rI.get("status"), Integer.parseInt(status)));
        }

        // Thêm điều kiện cho active
        if (isActive != null && !isActive.isEmpty()) {
            predicates.add(b.equal(rI.get("active"), Boolean.parseBoolean(isActive)));
        }

        // Thêm điều kiện join với bảng Resident
        predicates.add(b.equal(rI.get("residentId"), rR.get("id")));

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(b.desc(rI.get("createdDate")));


        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
