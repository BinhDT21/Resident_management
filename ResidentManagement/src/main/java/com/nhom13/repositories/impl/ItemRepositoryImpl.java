package com.nhom13.repositories.impl;

import com.nhom13.pojo.Item;
import com.nhom13.repositories.ItemRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
public class ItemRepositoryImpl implements ItemRepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addItem(Map<String, Item> items) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        try{
            for(Map.Entry<String, Item> entry : items.entrySet()){
                Item item = entry.getValue();
                s.save(item);
            }
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Item> getAllItemById(int id, Map<String, String> params)
    {
        Session s = factoryBean.getObject().getCurrentSession();
//        do filter params
        return s.createQuery("SELECT i FROM Item i " +
                        "WHERE i.electronicLockerId.id=:id " +
                        "ORDER BY i.status", Item.class)
                .setParameter("id", id)
                .getResultList();

    }

    public Item getItemById(int itemId)
    {
        Session s = factoryBean.getObject().getCurrentSession();
        return s.get(Item.class, itemId);
    }

    public void updateOrCreateItem(Item item)
    {
        Session s = factoryBean.getObject().getCurrentSession();
        if (item.getId() != null)
            s.update(item);
        else s.save(item);
    }
}
