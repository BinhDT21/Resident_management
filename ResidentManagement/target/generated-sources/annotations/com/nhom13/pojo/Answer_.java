package com.nhom13.pojo;

import com.nhom13.pojo.Question;
import com.nhom13.pojo.Resident;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-22T18:48:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Answer.class)
public class Answer_ { 

    public static volatile SingularAttribute<Answer, Date> createdDate;
    public static volatile SingularAttribute<Answer, Question> questionId;
    public static volatile SingularAttribute<Answer, Resident> residentId;
    public static volatile SingularAttribute<Answer, Integer> id;
    public static volatile SingularAttribute<Answer, Integer> content;

}