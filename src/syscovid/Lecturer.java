/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscovid;

/**
 *
 * @author amie
 */
public class Lecturer extends Staff{
    
    private String faculty;
    private String department;
    
    Lecturer() {}
    
    Lecturer(String fname, String lname, String staffID, String noPhone, String password, String location, String city, String state, String position, String faculty, String department)
    {
        super(fname,lname,staffID,noPhone,password,location,city,state,position);
        this.faculty=faculty;
        this.department=department;
    }
    
    public String display()
    {
        return super.display()+ " " + faculty+" "+department;
    }   
}
