package com.nhom13.pojo;

import com.nhom13.pojo.Item;
import com.nhom13.pojo.Resident;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-26T12:37:12", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(ElectronicLocker.class)
public class ElectronicLocker_ { 

    public static volatile SingularAttribute<ElectronicLocker, Resident> residentId;
    public static volatile SingularAttribute<ElectronicLocker, Integer> id;
    public static volatile SetAttribute<ElectronicLocker, Item> itemSet;

}