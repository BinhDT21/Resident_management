package com.nhom13.pojo;

import com.nhom13.pojo.Admin;
import com.nhom13.pojo.Question;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-16T16:07:31", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Survey.class)
public class Survey_ { 

    public static volatile SingularAttribute<Survey, Date> createdDate;
    public static volatile SetAttribute<Survey, Question> questionSet;
    public static volatile SingularAttribute<Survey, Admin> adminId;
    public static volatile SingularAttribute<Survey, Short> active;
    public static volatile SingularAttribute<Survey, Integer> id;
    public static volatile SingularAttribute<Survey, String> title;

}