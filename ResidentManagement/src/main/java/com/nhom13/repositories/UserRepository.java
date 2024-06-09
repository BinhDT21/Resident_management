/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.repositories;

import com.nhom13.pojo.Admin;
import com.nhom13.pojo.User;

/**
 *
 * @author ADMIN
 */
public interface UserRepository {
    void addResident (User u);
    void addAdmin(User u);
    Admin getAdminByUsername (String username);
    User getUserByUsername (String username); 
    boolean authUser (String username, String password);
}