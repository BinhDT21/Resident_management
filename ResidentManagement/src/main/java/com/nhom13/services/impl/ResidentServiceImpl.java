/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.services.impl;

import com.nhom13.pojo.Resident;
import com.nhom13.repositories.ResidentRepository;
import com.nhom13.services.ResidentService;
import java.util.List;
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
    public List<Resident> loadResident() {
        return this.resRepo.loadResident();
    }
    
}
