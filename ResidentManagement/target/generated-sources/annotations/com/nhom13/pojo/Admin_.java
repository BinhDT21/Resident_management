package com.nhom13.pojo;

import com.nhom13.pojo.Survey;
import com.nhom13.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-07T14:37:35")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SetAttribute<Admin, Survey> surveySet;
    public static volatile SingularAttribute<Admin, Integer> id;
    public static volatile SingularAttribute<Admin, User> userId;

}