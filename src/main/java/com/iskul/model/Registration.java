package com.iskul.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sowrozit on 2/9/2017.
 */

@Entity
@Table(name="USER")
public class Registration implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 11 )
    private int id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String userType;

    @Column
    private String password;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName=userName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;
    }

    public String getUserType()
    {
        return userType;
    }
    public void setUserType(String userType)
    {
        this.userType=userType;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

}
