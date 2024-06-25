/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.repositories.impl;

import com.nhom13.pojo.ElectronicLocker;
import com.nhom13.pojo.Resident;
import com.nhom13.pojo.User;
import com.nhom13.repositories.ResidentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class ResidentRepositoryImpl implements ResidentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    private EntityManager em;

    public long countResidents(Map<String, String> params){
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Long> query = b.createQuery(Long.class);

        Root<Resident> rR = query.from(Resident.class);
        query.select(b.count(rR));


        List<Predicate> predicates = new ArrayList<>();
        String block = params.get("block");
        if (block != null && !block.isEmpty()) {
            predicates.add(b.equal(rR.get("userId").get("active"), 0));
        } else {
            predicates.add(b.equal(rR.get("userId").get("active"), 1));
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return s.createQuery(query).getSingleResult();
    }

    @Override
    public List<Resident> getResidentWithInvoices(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery query = b.createQuery(Resident.class);
        Root<Resident> root = query.from(Resident.class);
        root.fetch("invoiceSet", JoinType.LEFT);
        query.select(root).distinct(true);

        List<Predicate> predicates = new ArrayList<>();
        String block = params.get("block");
        if (block != null && !block.isEmpty()) {
            predicates.add(b.equal(root.get("userId").get("active"), 0));
        } else {
            predicates.add(b.equal(root.get("userId").get("active"), 1));
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));

        Query q = s.createQuery(query);


        String p = params.get("page");

        int page = p != null && !p.isEmpty() ? Integer.parseInt(p) : 1;
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE").toString());

        long totalRecords = countResidents(params);
        long totalPages = Math.round((float)totalRecords / pageSize);

        if(page > totalPages){
            page = (int) totalPages;
        }

        q.setMaxResults(pageSize);
        q.setFirstResult((page - 1) * pageSize);
        List<Resident> residents = q.getResultList();

        params.put("totalPages", String.valueOf(totalPages));
        params.put("currentPage", String.valueOf(page));

        return residents;
    }

    @Override
    public List<Resident> loadResident(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = b.createQuery(Object[].class);

        Root<Resident> rR = query.from(Resident.class);
        Root<User> rU = query.from(User.class);

        query.multiselect(rR.get("id"), rU.get("firstName"), rU.get("lastName"),
                rU.get("dob"), rU.get("address"), rU.get("phone"), rU.get("active"), rU.get("id"));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rU.get("id"), rR.get("userId")));

        String block = params.get("block");
        if (block != null && !block.isEmpty()) {
            predicates.add(b.equal(rU.get("active"), 0));
        } else {
            predicates.add(b.equal(rU.get("active"), 1));
        }

        String name = params.get("name");
        if (name != null && !name.isEmpty()) {
            predicates.add(b.like(rU.get("lastName"), String.format("%%%s%%", name)));
        }

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(b.asc(rR.get("id")));

        Query q = s.createQuery(query);

        String p = params.get("page");
        int page = p != null && !p.isEmpty() ? Integer.parseInt(p) : 1;
        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE").toString());

        long totalRecords = countResidents(params);
        long totalPages = (totalRecords + pageSize - 1) / pageSize;

        if (page > totalPages) {
            page = (int) totalPages;
        }

        int start = (page - 1) * pageSize;
        q.setFirstResult(start);
        q.setMaxResults(pageSize);

        params.put("totalPages", String.valueOf(totalPages));
        params.put("currentPage", String.valueOf(page));

        return q.getResultList();
    }

    @Override
    public List<Resident> getByIds(List<Integer> ids) {
        String query = "select r from Resident r where r.id in (:ids)";
        return em.createQuery(query, Resident.class).setParameter("ids", ids).getResultList();
    }


    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        User u = s.get(User.class, id);
        return u;
    }

    @Override
    public void deleteUser(int id) {
        User u = this.getUserById(id);
        u.setActive(Short.parseShort("0"));
    }

    @Override
    public List<Resident> getAll() {
        Session s = factory.getObject().getCurrentSession();
        return s.createQuery("SELECT r FROM Resident r", Resident.class).getResultList();
    }
}