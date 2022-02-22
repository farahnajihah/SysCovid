/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscovid;
import java.util.*;
import java.io.*;

/**
 *
 * @author Acer
 */
public class Postgraduate extends Student {
    private String status;
   // private int year;
    //Postgraduate(){}
    Postgraduate(String name,String lastName,String noMatric,String noPhone,String passField,
            String category,String program,String state,String college,String currentLocation,String year, String status)
    {
        super(name,lastName,noMatric,noPhone,passField,category,program,state,college,currentLocation,year);
        this.status = status;
    }
    public String getStatus()
    {
        return status;
    }
    public void display()
    {
        System.out.println(super.getName()+"\t\t"+super.getLastName()+"\t\t"+super.getNoMatric()+"\t\t"+super.getNoPhone()+"\t\t"+super.getPassField()+"\t\t"+super.getCategory()+"\t\t"+super.getProgram()+"\t\t"+super.getState()+"\t\t"+super.getCollege()+"\t\t"+super.getCurrent()+"\t\t"+super.getYear());
        System.out.println(status+"\n");
    }
}
