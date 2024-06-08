/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.services;

import com.nhom13.pojo.Admin;
import com.nhom13.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author ADMIN
 */
public interface UserService  extends  UserDetailsService{
    void addResident (User u);
    void addAdmin(User u);
    User getUserByUsername (String username); 
    Admin getAdminByUsername (String username);
    boolean authUser (String username, String password);
}
