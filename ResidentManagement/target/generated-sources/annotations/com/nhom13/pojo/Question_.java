package com.nhom13.pojo;

import com.nhom13.pojo.Answer;
import com.nhom13.pojo.Survey;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-09T00:45:45", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, Survey> surveyId;
    public static volatile SingularAttribute<Question, Date> createdDate;
    public static volatile SetAttribute<Question, Answer> answerSet;
    public static volatile SingularAttribute<Question, Integer> id;
    public static volatile SingularAttribute<Question, String> content;

}