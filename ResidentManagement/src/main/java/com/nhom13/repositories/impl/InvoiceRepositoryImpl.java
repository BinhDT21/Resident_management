package com.nhom13.repositories.impl;

import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.Resident;
import com.nhom13.pojo.User;
import com.nhom13.repositories.InvoiceRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    @Autowired
    private Environment env;

    public long countResidents(Map<String, String> params){
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Long> query = b.createQuery(Long.class);

        Root<Resident> rR = query.from(Resident.class);
        Root<User> rU = query.from(User.class);

        query.select(b.count(rR));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rU.get("id"), rR.get("userId")));

        query.where(predicates.toArray(Predicate[]::new));
        return s.createQuery(query).getSingleResult();
    }

    public long countInvoices(Map<String, String> params){
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);

        Root<Invoice> rI = q.from(Invoice.class);
        Root<Resident> rR = q.from(Resident.class);

        q.select(b.count(rI));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rR.get("id"), rI.get("residentId")));

        q.where(predicates.toArray(Predicate[]::new));
        return s.createQuery(q).getSingleResult();
    }


    @Override
    public Invoice getInvoiceById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Invoice.class, id);
    }


    @Override
    public void createOrUpdateInvoice(Invoice invoice) {
        Session s = this.factory.getObject().getCurrentSession();
        if(invoice.getId() == null) {
            invoice.setStatus("unpaid");
            s.save(invoice);
        } else
            s.update(invoice);
    }

    @Override
    public void deleteInvoice(int id) {
        Invoice i = this.getInvoiceById(id);
        i.setActive(Short.parseShort("0"));
    }

    @Override
    public List<Invoice> getByResidentId(int residentId) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Invoice> query = b.createQuery(Invoice.class);
        Root<Invoice> root = query.from(Invoice.class);

        Predicate condition = b.equal(root.get("residentId").get("id"), residentId);
        query.where(condition);

        query.orderBy(b.asc(root.get("id")));

        Query q = s.createQuery(query);
        return q.getResultList();
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
                rU.get("lastName"),
                rU.get("firstName"),
                rI.get("createdDate")
        );

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rU.get("id"), rR.get("userId")));

        // Thêm điều kiện join với bảng Resident
        predicates.add(b.equal(rI.get("residentId"), rR.get("id")));

        String active = params.get("active");
        if(active != null && !active.isEmpty()) {
            predicates.add(b.equal(rI.get("active"), active));
        }

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(b.desc(rI.get("createdDate")));

        Query q = session.createQuery(query);
        String p = params.get("page");

        int page = p != null && !p.isEmpty() ? Integer.parseInt(p) : 1;
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE").toString());

        long totalRecords = countInvoices(params);
        long totalPages = (totalRecords + pageSize - 1) / pageSize;

        if(page > totalPages){
            page = (int) totalPages;
        }

        int start = (page - 1) * pageSize;
        q.setFirstResult(start);
        q.setMaxResults(pageSize);

        params.put("totalPages", String.valueOf(totalPages));
        params.put("currentPage", String.valueOf(page));

        return q.getResultList();
    }
}
