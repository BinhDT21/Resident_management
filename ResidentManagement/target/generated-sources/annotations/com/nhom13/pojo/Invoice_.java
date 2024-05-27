package com.nhom13.pojo;

import com.nhom13.pojo.Resident;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-26T12:37:12", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Long> amount;
    public static volatile SingularAttribute<Invoice, Date> createdDate;
    public static volatile SingularAttribute<Invoice, Date> dueDate;
    public static volatile SingularAttribute<Invoice, String> name;
    public static volatile SingularAttribute<Invoice, String> paymentProve;
    public static volatile SingularAttribute<Invoice, Resident> residentId;
    public static volatile SingularAttribute<Invoice, Integer> id;
    public static volatile SingularAttribute<Invoice, String> status;

}