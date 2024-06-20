/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.repositories.impl;

import com.nhom13.pojo.Feedback;
import com.nhom13.pojo.Resident;
import com.nhom13.pojo.User;
import com.nhom13.repositories.FeedbackRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class FeedbackRepositoryImpl implements FeedbackRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> loadFeedbacks(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = b.createQuery(Object[].class);

        Root<User> rU = query.from(User.class);
        Root<Resident> rR = query.from(Resident.class);
        Root<Feedback> rF = query.from(Feedback.class);

        query.multiselect(
                rF.get("id"),
                rF.get("content"),
                rU.get("firstName"),
                rU.get("lastName"),
                rF.get("status"),
                rF.get("createdDate"));

        List<Predicate> predicates = new ArrayList<>();

        //join User and Resident on User.id == Resident.userId 
        predicates.add(b.equal(rU.get("id"), rR.get("userId")));
        //join Feedback and Resident on Feedback.residentId == Resident.id
        predicates.add(b.equal(rF.get("residentId"), rR.get("id")));

        String status = params.get("status");
        if (status != null && !status.isEmpty()) {
            predicates.add(b.equal(rF.get("status"), Short.parseShort(status)));
        }

        query.where(predicates.toArray(Predicate[]::new));
        query.orderBy(b.desc(rF.get("createdDate")));

        Query q = s.createQuery(query);
        return q.getResultList();
    }
    
    @Override
    public Feedback getFeedbackById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Feedback f = s.get(Feedback.class, id);
        return f;
    }

    //lấy id resident từ id user
    public int getIdResident(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Resident> q = b.createQuery(Resident.class);

        Root rR = q.from(Resident.class);

        q.select(rR);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rR.get("userId"), id));

        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        Resident r = (Resident) query.getSingleResult();
        return r.getId();
    }

//    @Override
//    public void creatFeedback(Feedback f, int userId) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Resident r = s.createQuery("SELECT r FROM Resident r WHERE r.userId.id = :uid", Resident.class)
//                .setParameter("uid", userId).getSingleResult();
//
//        Date currentDate = new Date();
//        f.setCreatedDate(currentDate);
//        f.setStatus(Short.parseShort("0"));
//        f.setResidentId(r);
//        s.save(f);
//    }

    @Override
    public void creatFeedback(Feedback f, int userId) {
        Session s = this.factory.getObject().getCurrentSession();
        Resident r = s.get(Resident.class, this.getIdResident(userId));

        Date currentDate = new Date();
        f.setCreatedDate(currentDate);
        f.setStatus(Short.parseShort("0"));
        f.setResidentId(r);
        s.save(f);
    }

    @Override
    public void solveFeedback(int id) {

        Feedback f = this.getFeedbackById(id);
        f.setStatus(Short.parseShort("1"));
    }

}
