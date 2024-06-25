package com.nhom13.controllers;

import com.nhom13.pojo.ElectronicLocker;
import com.nhom13.services.ElectronicLockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/electronic-lockers")
public class ElectronicLockerController {
    @Autowired
    private ElectronicLockerService electronicLockerService;

    @GetMapping
    public String listElectronicLockers(@RequestParam Map<String, String> params, Model model) {
        List<ElectronicLocker> electronicLockers = electronicLockerService.getAllElectronicLockers(params);
        model.addAttribute("electronicLockers", electronicLockers);
        model.addAttribute("totalPages", params.get("totalPages"));
        model.addAttribute("currentPage", params.get("currentPage"));
        return "electronic-lockers";
    }
}
