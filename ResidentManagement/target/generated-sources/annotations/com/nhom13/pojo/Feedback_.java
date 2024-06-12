package com.nhom13.pojo;

import com.nhom13.pojo.Resident;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-12T17:44:28", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Date> createdDate;
    public static volatile SingularAttribute<Feedback, Resident> residentId;
    public static volatile SingularAttribute<Feedback, Integer> id;
    public static volatile SingularAttribute<Feedback, String> content;
    public static volatile SingularAttribute<Feedback, Short> status;

}