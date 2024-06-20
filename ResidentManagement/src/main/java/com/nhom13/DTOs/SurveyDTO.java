package com.nhom13.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SurveyDTO {
    private int id;
    private int residentId;
    private String question;
    private List<AnswerDTO> answers;
    private Date createdDate;

    @JsonCreator
    public SurveyDTO(@JsonProperty("id") int id, @JsonProperty("residentId") int residentId, @JsonProperty("question") String question, @JsonProperty("answers") List<AnswerDTO> answers) {
        this.id = id;
        this.residentId = residentId;
        this.question = question;
        this.answers = answers;
        this.createdDate = new Date();
    }
}
