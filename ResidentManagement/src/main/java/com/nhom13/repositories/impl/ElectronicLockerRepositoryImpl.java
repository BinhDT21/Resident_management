package com.nhom13.repositories.impl;

import com.nhom13.pojo.ElectronicLocker;
import com.nhom13.pojo.Item;
import com.nhom13.pojo.Resident;
import com.nhom13.repositories.ElectronicLockerRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class ElectronicLockerRepositoryImpl implements ElectronicLockerRepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;
    @Autowired
    private Environment env;

    @Override
    public List<ElectronicLocker> getAllElectronicLockers(Map<String, String> params) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ElectronicLocker> q = b.createQuery(ElectronicLocker.class);
        Root<ElectronicLocker> r = q.from(ElectronicLocker.class);
        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String residentName = params.get("residentName");
        if (residentName != null && residentName.isEmpty()) {
            Join<ElectronicLocker, Resident> residentJoin = r.join("residentId");
            predicates.add(b.like(residentJoin.get("name"), String.format("%%%s%%", residentName)));
        }

        if (!predicates.isEmpty()) {
            q.where(predicates.toArray(new Predicate[0]));
        }

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void addElectronicLocker(ElectronicLocker el) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        s.save(el);
    }

    @Override
    public ElectronicLocker getElectronicLockerById(int id) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        return s.get(ElectronicLocker.class, id);
    }

    @Override
    public void updateElectronicLocker(ElectronicLocker el) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        s.update(el);
    }

    @Override
    public void deleteElectronicLocker(int id) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        ElectronicLocker el = s.load(ElectronicLocker.class, id);
        if (el != null) {
            s.delete(el);
        }
    }


}
