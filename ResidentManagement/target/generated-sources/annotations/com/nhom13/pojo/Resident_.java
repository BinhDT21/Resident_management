package com.nhom13.pojo;

import com.nhom13.pojo.Answer;
import com.nhom13.pojo.ElectronicLocker;
import com.nhom13.pojo.Feedback;
import com.nhom13.pojo.Invoice;
import com.nhom13.pojo.ResidentVisitor;
import com.nhom13.pojo.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-19T00:26:23", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile SetAttribute<Resident, Invoice> invoiceSet;
    public static volatile SingularAttribute<Resident, Long> balance;
    public static volatile SetAttribute<Resident, Answer> answerSet;
    public static volatile SetAttribute<Resident, ResidentVisitor> residentVisitorSet;
    public static volatile SetAttribute<Resident, Feedback> feedbackSet;
    public static volatile SingularAttribute<Resident, Integer> id;
    public static volatile SingularAttribute<Resident, User> userId;
    public static volatile SetAttribute<Resident, ElectronicLocker> electronicLockerSet;

}