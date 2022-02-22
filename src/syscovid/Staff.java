/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscovid;

import java.io.*;

/**
 *
 * @author amie
 */
public class Staff implements Serializable {
    
    private String fname;
    private String lname;
    private String staffID;
    private String noPhone;
    private String password;
    private String location;
    private String city;
    private String state;
    private String position;
    
    Staff() {}
    
    Staff(String fname, String lname, String staffID, String noPhone, String password, String location, String city, String state, String position)
    {
        this.fname=fname;
        this.lname=lname;
        this.staffID=staffID;
        this.noPhone=noPhone;
        this.password=password;
        this.location=location;
        this.city=city;
        this.state=state;
        this.position=position;
    }
    public String display()
    {
        return fname+" "+lname+" "+staffID+" "+noPhone+" "+password+" "+location+" "+city+" "+state+" "+position;
    }
    public void setFName(String fname)
    {
        this.fname=fname;
    }
    public String getFName()
    {
        return fname;
    }
    public void setLName(String lname)
    {
        this.lname=lname;
    }
    public String getLName()
    {
        return lname;
    }
    public void setStaffID(String staffID)
    {
        this.staffID=staffID;
    }
    public String getStaffID()
    {
        return staffID;
    }
    public void setNoPhone(String noPhone)
    {
        this.noPhone=noPhone;
    }
    public String getNoPhone()
    {
        return noPhone;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return password;
    }
    public void setLocation(String location)
    {
        this.location=location;
    }
    public String getLocation()
    {
        return location;
    }        
    public void setCity(String city)
    {
        this.city=city;
    }
    public String getCity()
    {
        return city;
    }
    public void setState(String state)
    {
        this.state=state;
    }
    public String getState()
    {
        return state;
    }  
    public void setPosition(String position)
    {
        this.position=position;
    }
    public String getPosition()
    {
        return position;
    }      

}
