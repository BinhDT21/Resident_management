package com.nhom13.pojo;

import com.nhom13.pojo.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-05-24T17:25:02")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Resident> residentId;
    public static volatile SingularAttribute<Feedback, Integer> id;
    public static volatile SingularAttribute<Feedback, String> content;
    public static volatile SingularAttribute<Feedback, Short> status;

}