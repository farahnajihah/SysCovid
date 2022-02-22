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
class Need implements Charges
{
    
    private String productName;
    private int quantity;
    private double price;
    
    public Need( String pN, int quantity, double price)
    {
        productName = pN;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double calcDis()
    {
        return getPrice() - (getPrice() * Charges.RATE);
    }
}

