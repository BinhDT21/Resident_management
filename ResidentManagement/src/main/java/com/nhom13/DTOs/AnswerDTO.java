package com.nhom13.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class AnswerDTO {
    private int id;
    private int questionId;
    private Short answer;

    @JsonCreator
    public AnswerDTO(@JsonProperty("id") int id, @JsonProperty("answer") Short answer, @JsonProperty("question_id") int questionId) {
        this.id = id;
        this.answer = answer;
        this.questionId = questionId;
    }

}
