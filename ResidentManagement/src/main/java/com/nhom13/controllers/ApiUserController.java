/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.nhom13.components.JwtService;
import com.nhom13.pojo.User;
import com.nhom13.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ApiUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    @PostMapping("/login/")
    public ResponseEntity<String> login (@RequestBody User user){
        if (this.userService.authUser(user.getUsername(), user.getPassword())==true){
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("something went wrong !!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getCurrentUser (Principal p){
        String name = p.getName();
        User u = this.userService.getUserByUsername(name);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    //update avt and password
    @PostMapping(path = "/update-user/", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.OK)
    public void update (@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file){
        User u = this.userService.getUserByUsername(params.get("username"));
        String password = params.get("password");
        u.setPassword(this.passwordEncoder.encode(password));
        if (file.length > 0)
            u.setFile(file[0]);


        this.userService.updateUser(u);
    }
}
