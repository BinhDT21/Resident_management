/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.nhom13.pojo.User;
import com.nhom13.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class ResidentController {
    
    @Autowired
    private ResidentService resSer;
    
    @GetMapping("/resident")
    public String createUserView (Model model){
        model.addAttribute("user", new User());
        return "resident";
    }
    
    @PostMapping("/resident")
    public String createUser (@ModelAttribute(value = "user") User u){
        
        this.resSer.addResident(u);
        return "redirect:/";
    }
    
    
}
