package com.nhom13.pojo;

import com.nhom13.pojo.ResidentVisitor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-09T00:45:45", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Visitor.class)
public class Visitor_ { 

    public static volatile SetAttribute<Visitor, ResidentVisitor> residentVisitorSet;
    public static volatile SingularAttribute<Visitor, String> name;
    public static volatile SingularAttribute<Visitor, Integer> id;
    public static volatile SingularAttribute<Visitor, String> relation;

}