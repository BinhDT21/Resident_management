package com.nhom13.pojo;

import com.nhom13.pojo.Answer;
import com.nhom13.pojo.Survey;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-05-25T12:30:09")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, Survey> surveyId;
    public static volatile SetAttribute<Question, Answer> answerSet;
    public static volatile SingularAttribute<Question, Integer> id;
    public static volatile SingularAttribute<Question, String> content;

}