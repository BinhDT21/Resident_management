package com.nhom13.repositories.impl;

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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
        Session s = this.factory.getObject().getCurrentSession();
        LocalDate dueDate = invoice.getDueDate();
        LocalDate atNow = LocalDate.now();

//        long dayisDifference = ChronoUnit.DAYS.between(atNow, dueDate);

        String status = "";
        String paymentProve = invoice.getPaymentProve();

        if(invoice.getId() > 0) {
            if(paymentProve != null && !paymentProve.isEmpty() && (atNow.isBefore(dueDate) || atNow.isEqual(dueDate))) {
                status = "paid";
            } else if (paymentProve != null && !paymentProve.isEmpty()) {
                status = "waiting";
            } else
                status = "late";
            invoice.setStatus(status);
            s.update(invoice);
        } else
            invoice.setStatus("unpaid");
        s.save(invoice);

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
}
