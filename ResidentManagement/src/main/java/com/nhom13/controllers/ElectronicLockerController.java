package com.nhom13.controllers;

import com.nhom13.services.ElectronicLockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/electronic-lockers")
public class ElectronicLockerController {
    @Autowired
    private ElectronicLockerService electronicLockerService;

    @GetMapping
    public String getAll(Map<String, String> params, Model model) {
        model.addAttribute("electronicLockers", electronicLockerService.getAllElectronicLockers(params));
        return "electronicLocker";
    }
}
