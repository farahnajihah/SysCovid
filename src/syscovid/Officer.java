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
public class Officer extends Staff {
    
    private String designation;
    
    Officer(){}
    Officer(String fname, String lname, String staffID, String noPhone, String password, String location, String city, String state, String position, String designation)
    {
        super(fname,lname,staffID,noPhone,password,location,city,state,position);
        this.designation=designation;
    }
   
    public String display()
    {
        return super.display() + " "+designation+"\n";
    }
}


