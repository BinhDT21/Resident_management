package com.nhom13.pojo;

import com.nhom13.pojo.Admin;
import com.nhom13.pojo.Resident;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-22T18:48:01", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, String> role;
    public static volatile SingularAttribute<User, Short> gender;
    public static volatile SetAttribute<User, Resident> residentSet;
    public static volatile SingularAttribute<User, Short> active;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SetAttribute<User, Admin> adminSet;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Date> dob;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}