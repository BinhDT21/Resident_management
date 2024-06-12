package com.nhom13.pojo;

import com.nhom13.pojo.Survey;
import com.nhom13.pojo.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-12T17:44:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SetAttribute<Admin, Survey> surveySet;
    public static volatile SingularAttribute<Admin, Integer> id;
    public static volatile SingularAttribute<Admin, User> userId;

}