/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscovid;
import java.io.*;
import java.util.*;


/**
 *
 * @author Acer
 */
abstract class Student {
    private String name , lastName,noMatric, noPhone, passField, category, program, state,college,currentLocation ;
    private String year;
    private String passwrodStud;
    private ArrayList <Need> needList;
    
    //public Need needs;
    Student(){}
    Student(String name,String lastName,String noMatric,String noPhone,String passField,
            String category,String program,String state,String college,String currentLocation,String year)
    {
        this.name = name;
        this.lastName = lastName;
        this.currentLocation = currentLocation;
        //this.passwrodStud = passwordStud;
        this.noMatric = noMatric;
        this.noPhone = noPhone;
        this.passField = passField;
        this.category = category;
        this.program = program;
        //this.city = city;
        this.state = state;
        this.college = college;
        //this.block = block;
        this.year = year;
        needList = new ArrayList <Need>();
    }
    public void addOrder(Need n)	
    {
        this.needList.add(n);
    }
    public String getName()
    {
        return name;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getFullname()
    {
        return name+" "+lastName;
    }
    public String getCurrent()
    {
        return currentLocation;
    }
    public String getNoMatric()
    {
        return noMatric;
    }
    public String getNoPhone()
    {
        return noPhone;
    }
    public String getPassField()
    {
        return passField;
    }
    public String getCategory()
    {
        return category;
    }
    public String getState()
    {
        return state;
    }
    public String getProgram()
    {
        return program;
    }
    public String getCollege()
    {
        return college;
    }
    
    public String getYear()
    {
        return year;
    }
    public abstract void display();
    
    int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
