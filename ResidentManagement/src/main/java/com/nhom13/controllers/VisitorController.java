/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.nhom13.pojo.Visitor;
import com.nhom13.services.VisitorService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
public class VisitorController {
    
    @Autowired
    private VisitorService visitorService;
    
    
    @RequestMapping("/visitor")
    public String visitor(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("visitors",this.visitorService.loadVisitors(params));
        return "visitor";
    }
    
    @GetMapping("/visitor/{visitorId}")
    public String update (Model model, @PathVariable("visitorId") int id){
        model.addAttribute("visitor",this.visitorService.getVisitorById(id));
        return "updateVisitor";
    }
    @PostMapping("/visitor")
    public String update(@ModelAttribute(value = "visitor") Visitor v){
        this.visitorService.updateVisitor(v);
        return "redirect:/visitor";
    }
}
