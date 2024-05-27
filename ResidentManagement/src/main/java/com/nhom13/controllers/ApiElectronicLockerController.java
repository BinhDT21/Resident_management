package com.nhom13.controllers;

import com.nhom13.services.ElectronicLockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ApiElectronicLockerController {
    @Autowired
    private ElectronicLockerService electronicLockerService;


}
