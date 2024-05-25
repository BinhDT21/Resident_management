package com.nhom13.pojo;

import com.nhom13.pojo.Admin;
import com.nhom13.pojo.Question;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-05-25T12:30:09")
@StaticMetamodel(Survey.class)
public class Survey_ { 

    public static volatile SetAttribute<Survey, Question> questionSet;
    public static volatile SingularAttribute<Survey, Admin> adminId;
    public static volatile SingularAttribute<Survey, Integer> id;
    public static volatile SingularAttribute<Survey, String> title;

}