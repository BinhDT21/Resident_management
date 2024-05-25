/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.services.impl;

import com.nhom13.pojo.Resident;
import com.nhom13.pojo.User;
import com.nhom13.repositories.ResidentRepository;
import com.nhom13.services.ResidentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ResidentServiceImpl implements ResidentService{
    
    @Autowired
    private ResidentRepository resRepo;

    @Override
    public List<Resident> loadResident(Map<String, String> params) {
        return this.resRepo.loadResident(params);
    }

    @Override
    public void addResident(User u) {
        System.out.print(u);
        this.resRepo.addResident(u);
    }

    @Override
    public User getUserById(int id) {
        return this.resRepo.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        this.resRepo.deleteUser(id);
    }

    

    
    
}
