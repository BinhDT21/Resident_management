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
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ResidentRepositoryImpl implements ResidentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Resident> loadResident(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = b.createQuery(Object[].class);

        Root rR = query.from(Resident.class);
        Root rU = query.from(User.class);

        query.multiselect(rR.get("id"), rU.get("firstName"), rU.get("lastName"),
                rU.get("dob"), rU.get("address"), rU.get("phone"), rU.get("active"), rU.get("id"));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rU.get("id"), rR.get("userId")));
        predicates.add(b.equal(rU.get("active"), 1));

        String name = params.get("name");
        if (name != null && !name.isEmpty()) {
            predicates.add(b.like(rU.get("lastName"), String.format("%%%s%%", name)));
        }

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(b.asc(rR.get("id")));

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    //Add resident by User and create a electronic locker for this resident 
    @Override
    public void addResident(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        u.setRole("resident");
        u.setActive(Short.parseShort("1"));
        s.save(u);

        Resident r = new Resident();
        r.setBalance(Long.parseLong("0"));
        r.setUserId(u);
        s.save(r);

        ElectronicLocker l = new ElectronicLocker();
        l.setResidentId(r);
        s.save(l);
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

}
