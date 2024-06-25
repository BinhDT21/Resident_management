/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.services;



import com.nhom13.pojo.Resident;
import com.nhom13.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface ResidentService {
    List<Resident> loadResident (Map<String, String> params);
    List<Resident> getByIds (List<Integer> ids);
    User getUserById (int id);  //lay user theo id
    void deleteUser(int id);    //deactive user
    List<Resident> getAll();
    List<Resident> getResidentWithInvoices(Map<String, String> params);
}
