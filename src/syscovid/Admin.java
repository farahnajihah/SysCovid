/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscovid;

import java.util.ArrayList;

/**
 *
 * @author amie
 */
//ASSOCIATION
public class Admin {
    
    private ArrayList <Student> stdList = new ArrayList<Student>();
    private ArrayList <Staff> sList = new ArrayList <Staff> ();
    private ArrayList <Need> needList = new ArrayList<Need>();
    private String name;
    private String aID;
    
    Admin(String name, String aID)
    {
        this.name=name;
        this.aID=aID;
        stdList = new ArrayList<Student>();
        sList = new ArrayList<Staff>();  
        needList = new ArrayList<Need>();
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setAID(String aID)
    {
        this.aID=aID;
    }
    public String getAID()
    {
        return aID;
    }
    public void viewStudent(Student std)
    {
        stdList.add(std);
    }
    public void viewStaff(Staff s)
    {
        sList.add(s);
    }
    public void viewNeed (Need n)
    {
        needList.add(n);
    }
    
    public String showResult()
    {
        String result="";
        for(int i=0; i<sList.size(); i++)
        {
            result = sList.get(i).getFName()+" "+sList.get(i).getLName()+
                    "\t"+sList.get(i).getStaffID()+"\t"+sList.get(i).getNoPhone()+"\t"+
                    sList.get(i).getLocation()+"\t"+
                    sList.get(i).getCity()+"\t"+sList.get(i).getState()+"\n";
        }
        return result;
    }
    
    public String showResultNeed()
    {
        String results="";
        for(int i=0; i<needList.size(); i++)
        {
            results = needList.get(i).getProductName()+" "+needList.get(i).getQuantity()+
                    "\t"+needList.get(i).getPrice()+"\n";
        }
        return results;
    }
    
}
