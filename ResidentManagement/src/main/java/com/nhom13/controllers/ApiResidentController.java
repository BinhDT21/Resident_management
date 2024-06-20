/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.nhom13.pojo.Resident;
import com.nhom13.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ApiResidentController {
    @Autowired
    private ResidentService resSer;
    
    @DeleteMapping("/resident/{residentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "residentId") int id) {
        this.resSer.deleteUser(id);
    }

}
