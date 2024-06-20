/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.nhom13.pojo.Survey;
import com.nhom13.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ApiSurveyController {
    @Autowired
    private SurveyService surService;

    //------------GET all survey--------------------//
    @GetMapping(value="/surveys")
    public ResponseEntity<List<Survey>> getAllSurveys(@RequestParam Map<String,String> params) {
        return new ResponseEntity<>(this.surService.loadSurveys(params), HttpStatus.OK);
    }

    @GetMapping(path="/surveys/{surveyId}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable int surveyId) {
        return new ResponseEntity<>(this.surService.getSurveyById(surveyId), HttpStatus.OK);
    }

    @DeleteMapping("/surveys/{surveyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void block (@PathVariable(value = "surveyId") int id){
        this.surService.blockSurvey(id);
    }
    
}
