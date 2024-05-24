/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.nhom13.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class IndexController {
    
    @Autowired
    private ResidentService resSer;
    
    @RequestMapping("/")
    public String index (Model model){
        
        model.addAttribute("residents",this.resSer.loadResident());
        
        return "index";
    }
    
}
