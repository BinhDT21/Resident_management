/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhom13.DTOs.FeedbackDTO;
import com.nhom13.DTOs.FeedbackRequestDto;
import com.nhom13.pojo.Feedback;
import com.nhom13.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ApiFeedbackController {
    @Autowired
    private FeedbackService feedbackSer;
    //-------GET All Feedback-------//

    @GetMapping(value = "/feedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks(@RequestParam Map<String, String> params){
        List<Object[]> feedbacks = this.feedbackSer.loadFeedbacks(params);
        List<FeedbackDTO> dtoList = new ArrayList<>();
        for (Object[] obj : feedbacks) {
            Integer id = (Integer) obj[0];
            String content = (String) obj[1];
            String firstName = (String) obj[2];
            String lastName = (String) obj[3];
            Short stShort = Short.parseShort(String.valueOf(obj[4]));
            Date createdDate = (Date) obj[5];

            FeedbackDTO dto = new FeedbackDTO(id, content, firstName, lastName, stShort, createdDate);
            dtoList.add(dto);
        }

        if (feedbacks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    //-------POST Feedback----------//
    @PostMapping("/feedbacks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeedback(@RequestBody FeedbackRequestDto dto){
        Feedback f = new Feedback();
        f.setContent(dto.getContent());
        this.feedbackSer.createFeedback(f);
    }

    @DeleteMapping("/feedbacks/{feedbackId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void solve(@PathVariable(value = "feedbackId") int id) {
        this.feedbackSer.solveFeedback(id);
    }
}
