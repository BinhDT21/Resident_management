package com.nhom13.pojo;

import com.nhom13.pojo.Question;
import com.nhom13.pojo.Resident;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-05-26T02:36:35")
@StaticMetamodel(Answer.class)
public class Answer_ { 

    public static volatile SingularAttribute<Answer, Date> createdDate;
    public static volatile SingularAttribute<Answer, Question> questionId;
    public static volatile SingularAttribute<Answer, Resident> residentId;
    public static volatile SingularAttribute<Answer, Integer> id;
    public static volatile SingularAttribute<Answer, Integer> content;

}