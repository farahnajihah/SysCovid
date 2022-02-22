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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ListNeed extends javax.swing.JFrame {
     private FileWriter fw;
     private PrintWriter pw;
     private BufferedReader br;
     String product, brand, paid, total;
     int quantity;
     double[] DefaultLIstModel = new double [20];
     DefaultListModel<String> listModel;
     private JFrame frame;
     ArrayList <Need> needList;
     ArrayList <Student> stList;
     
    /**
     * Creates new form ListNeed
     */
    public ListNeed() {
        listModel = new DefaultListModel<>();
        initComponents();
        this.setLocationRelativeTo(null);
        needList = new ArrayList <Need> ();
        stList = new ArrayList <Student> ();
        
    }
    
    ListNeed(String fname, String lname, String id, String nphone, String ncollege)
    {
        studName.setText(fname+"  "+lname);
        studID.setText(id);
        phone.setText(nphone);
        college.setText(ncollege);
        
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
    public PageFormat getPageFormat(PrinterJob pj)
    {
    
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();    

        double middleHeight =8.0;  
        double headerHeight = 2.0;                  
        double footerHeight = 2.0;                  
        double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
        double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
        paper.setSize(width, height);
        paper.setImageableArea(                    
            0,
            10,
            width,            
            height - convert_CM_To_PPI(1)
        );   //define boarder size    after that print area width is about 180 points

        pf.setOrientation(PageFormat.LANDSCAPE);           //select orientation portrait or landscape but for this time portrait
        pf.setPaper(paper);    

        return pf;
}

protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}

public class BillPrintable implements Printable {
     
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {  
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));

            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=5;
            int headerRectHeighta=10;
            
            ///////////////// Product names Get ///////////
                String pn1a=jCbBW.getText();
                String pn2a=jCbS.getText();
                String pn3a=jCbB.getText();
                String pn4a=jCbIN.getText();
                String pn5a=jCbBis.getText();
            ///////////////// Product names Get ///////////
                String q1=txtBW.getText();
                String q2=txtS.getText();
                String q3=txtB.getText();
                String q4=txtIN.getText();
                String q5=txtBis.getText();
             ///////////////// Student names Get ///////////
                String name=studName.getText();
                String id=studID.getText();
                String num=phone.getText();
                String col=college.getText();            
            ///////////////// Product price Get ///////////
                double pp1a=Double.valueOf(txtBW.getText())* 10.00;
                double pp2a=Double.valueOf(txtS.getText())* 12.50;
                double pp3a=Double.valueOf(txtB.getText())* 5.50;
                double pp4a=Double.valueOf(txtIN.getText())* 8.50;
                double pp5a=Double.valueOf(txtBis.getText())* 15.50;
                double paid=pp1a+pp2a+pp3a+pp4a+pp5a;
                double sum=pp1a+pp2a+pp3a+pp4a+pp5a+3;
            ///////////////// Product price Get ///////////
                
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("Student Name   : " + name ,10,y);y+=yShift;
            g2d.drawString("Student ID     : "+id,10,y);y+=yShift;
            g2d.drawString("Phone No.      : "+num,10,y);y+=yShift;
            g2d.drawString("College        : "+col,10,y);y+=yShift;
            g2d.drawString("---------------------------------------------------",10,y);y+=yShift;
            g2d.drawString("                   List Of Item                ",10,y);y+=yShift;
            g2d.drawString("---------------------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString(" Item                       Quantity     Price   ",10,y);y+=yShift;
            g2d.drawString("---------------------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString(" "+pn1a+"        "+q1+"         "+pp1a+"  ",10,y);y+=yShift;
            g2d.drawString(" "+pn2a+"            "+q2+"         "+pp2a+"  ",10,y);y+=yShift;
            g2d.drawString(" "+pn3a+"             "+q3+"         "+pp3a+"  ",10,y);y+=yShift;
            g2d.drawString(" "+pn4a+"   "+q4+"         "+pp4a+"  ",10,y);y+=yShift;
            g2d.drawString(" "+pn5a+"       "+q5+"         "+pp5a+"  ",10,y);y+=yShift;
            g2d.drawString("---------------------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total Paid     :RM "+paid+"            ",10,y);y+=yShift;
            g2d.drawString(" Charge Delivery:RM 3.00                ",10,y);y+=yShift;
            g2d.drawString(" Grand Total    :RM "+sum+"             ",10,y);y+=yShift;
            g2d.drawString("---------------------------------------------------",10,y);y+=yShift;
            g2d.drawString("***************************************************",10,y);y+=yShift;
            g2d.drawString("                      THANK YOU              ",10,y);y+=yShift;
            g2d.drawString("**************************************************",10,y);y+=yShift;
                   
    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtReceipt = new javax.swing.JTextArea();
        Cancel = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        college = new java.awt.TextField();
        phone = new java.awt.TextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studName = new java.awt.TextField();
        studID = new java.awt.TextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCbBW = new javax.swing.JCheckBox();
        txtBW = new javax.swing.JTextField();
        jCbS = new javax.swing.JCheckBox();
        txtS = new javax.swing.JTextField();
        jCbB = new javax.swing.JCheckBox();
        txtB = new javax.swing.JTextField();
        jCbIN = new javax.swing.JCheckBox();
        txtIN = new javax.swing.JTextField();
        jCbBis = new javax.swing.JCheckBox();
        txtBis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTot = new javax.swing.JTextField();
        Okay = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        PBW = new javax.swing.JTextField();
        PB = new javax.swing.JTextField();
        PS = new javax.swing.JTextField();
        PIN = new javax.swing.JTextField();
        PBis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jtxtReceipt.setColumns(20);
        jtxtReceipt.setRows(5);
        jScrollPane1.setViewportView(jtxtReceipt);

        Cancel.setBackground(new java.awt.Color(204, 0, 0));
        Cancel.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Save.setBackground(new java.awt.Color(51, 204, 0));
        Save.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Save.setText("Save");
        Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        LogOut.setText("Log Out");
        LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("College");

        college.setEditable(false);

        phone.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone No.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student Name");

        studName.setEditable(false);

        studID.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogOut)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(252, 252, 252)
                                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(studID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(college, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(college, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Cancel))
                .addGap(19, 19, 19))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(410, 434));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("List of Available Item");

        jCbBW.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCbBW.setForeground(new java.awt.Color(255, 255, 255));
        jCbBW.setText("Body Wash Dettol 900 ml");
        jCbBW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBWActionPerformed(evt);
            }
        });

        txtBW.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtBW.setText("0");
        txtBW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBWActionPerformed(evt);
            }
        });

        jCbS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCbS.setForeground(new java.awt.Color(255, 255, 255));
        jCbS.setText("Shampoo Safi 800 ml");
        jCbS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbSActionPerformed(evt);
            }
        });

        txtS.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtS.setText("0");

        jCbB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCbB.setForeground(new java.awt.Color(255, 255, 255));
        jCbB.setText("Bread Gardenia Bun");
        jCbB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBActionPerformed(evt);
            }
        });

        txtB.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtB.setText("0");

        jCbIN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCbIN.setForeground(new java.awt.Color(255, 255, 255));
        jCbIN.setText("Instant Noodles Maggie Curry");
        jCbIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbINActionPerformed(evt);
            }
        });

        txtIN.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtIN.setText("0");

        jCbBis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCbBis.setForeground(new java.awt.Color(255, 255, 255));
        jCbBis.setText("Biscuits Lexus Chocolate");
        jCbBis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbBisActionPerformed(evt);
            }
        });

        txtBis.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        txtBis.setText("0");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Paid");

        txtPay.setEditable(false);
        txtPay.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grand Total");

        txtTot.setEditable(false);
        txtTot.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N

        Okay.setBackground(new java.awt.Color(51, 204, 0));
        Okay.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Okay.setText("OK");
        Okay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Okay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkayActionPerformed(evt);
            }
        });

        Reset.setBackground(new java.awt.Color(204, 0, 0));
        Reset.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        Reset.setText("Reset");
        Reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        PBW.setEditable(false);
        PBW.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        PBW.setText("0.00");

        PB.setEditable(false);
        PB.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        PB.setText("0.00");

        PS.setEditable(false);
        PS.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        PS.setText("0.00");

        PIN.setEditable(false);
        PIN.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        PIN.setText("0.00");
        PIN.setToolTipText("");

        PBis.setEditable(false);
        PBis.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        PBis.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbBW)
                            .addComponent(jCbS))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(200, 200, 200)
                        .addComponent(txtTot, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jCbIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jCbB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCbBis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBis, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBW, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(PB)
                                        .addComponent(PIN, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PBis, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PBW, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(Okay, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbBW)
                    .addComponent(txtBW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PBW, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbS)
                    .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbB)
                    .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbIN)
                    .addComponent(txtIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PIN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbBis)
                    .addComponent(PBis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Okay)
                    .addComponent(Reset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        frame = new JFrame ("Cancel");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to Cancel",
            "System Student Whereabouts",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Thank You");
            this.hide();
            new LoginStudent().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
            pj.print();

        }
        catch (PrinterException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_SaveActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        frame = new JFrame ("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit",
            "System Student Whereabouts",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Thank You");
            this.hide();
            new MainMenu().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_LogOutActionPerformed

    private void jCbBWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBWActionPerformed
        // TODO add your handling code here:
        if(jCbBW.isSelected())
        {
            txtBW.setEnabled(true);
            txtBW.setText("");
            txtBW.requestFocus();
        }
        else
        {
            txtBW.setEnabled(false);
            txtBW.setText("0");
        }
    }//GEN-LAST:event_jCbBWActionPerformed

    private void txtBWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBWActionPerformed

    private void jCbSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbSActionPerformed
        // TODO add your handling code here:
        if(jCbS.isSelected())
        {
            txtS.setEnabled(true);
            txtS.setText("");
            txtS.requestFocus();
        }
        else
        {
            txtS.setEnabled(false);
            txtS.setText("0");
        }
    }//GEN-LAST:event_jCbSActionPerformed

    private void jCbBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBActionPerformed
        // TODO add your handling code here:
        if(jCbB.isSelected())
        {
            txtB.setEnabled(true);
            txtB.setText("");
            txtB.requestFocus();
        }
        else
        {
            txtB.setEnabled(false);
            txtB.setText("0");
        }
    }//GEN-LAST:event_jCbBActionPerformed

    private void jCbINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbINActionPerformed
        // TODO add your handling code here:
        if(jCbIN.isSelected())
        {
            txtIN.setEnabled(true);
            txtIN.setText("");
            txtIN.requestFocus();
        }
        else
        {
            txtIN.setEnabled(false);
            txtIN.setText("0");
        }
    }//GEN-LAST:event_jCbINActionPerformed

    private void jCbBisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbBisActionPerformed
        // TODO add your handling code here:
        if(jCbBis.isSelected())
        {
            txtBis.setEnabled(true);
            txtBis.setText("");
            txtBis.requestFocus();
        }
        else
        {
            txtBis.setEnabled(false);
            txtBis.setText("0");
        }
    }//GEN-LAST:event_jCbBisActionPerformed

    private void OkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkayActionPerformed
        // TODO add your handling code here:
        double tot = 0 ,gTot = 0, dTotal=0;
        double price = 0;
        String pN = "";
        int quantity = 0;
        String _sName = studName.getText().toString();
        String _sID = studID.getText().toString();
        String _sPhone = phone.getText().toString();
        String _sCollege = college.getText().toString();
        
        try
        {
            //PrintWriter printWriter = new PrintWriter(writer);

            if(jCbBW.isSelected())
            {
                pN = "Body Wash Dettol";
                quantity = Integer.parseInt(txtBW.getText());
                price = 10.00;
                Need n = new Need(pN,quantity,price);
                needList.add(n);
                
                tot = (n.getPrice()*n.getQuantity());
                gTot = tot;
                
                PBW.setText(String.valueOf(gTot));
                
            }
            if(jCbS.isSelected())
            {
                pN = "Shampoo Safi Lemon";
                quantity = Integer.parseInt(txtS.getText());
                price = 12.50;
                Need n = new Need(pN,quantity,price);
                needList.add(n);

                tot = (n.getPrice()*n.getQuantity());
                gTot = tot;
                
                PS.setText(String.valueOf(gTot));

            }

            if(jCbB.isSelected())
            {
                pN = "Bread Gardenia Bun";
                quantity = Integer.parseInt(txtB.getText());
                price = 5.50;
                Need n = new Need(pN,quantity,price);
                needList.add(n);

                if(quantity<3)
                {
                    tot = (n.getPrice()*n.getQuantity());
                    gTot = tot;
                }
                else
                {
                    tot = n.calcDis()*n.getQuantity();
                    gTot = tot;
                }
                PB.setText(String.valueOf(gTot));
            }

            if(jCbIN.isSelected())
            {
                pN = "Instant Noodle Curry";
                quantity = Integer.parseInt(txtIN.getText());
                price = 8.50;
                Need n = new Need(pN,quantity,price);
                needList.add(n);

                if(quantity<3)
                {
                    tot = (n.getPrice()*n.getQuantity());
                    gTot = tot;
                }
                else
                {
                    tot = n.calcDis()*n.getQuantity();
                    gTot = tot;
                }
                PIN.setText(String.valueOf(gTot));

            }
            if(jCbBis.isSelected())
            {
                pN = "Biscuit Lexus Chocolate";
                quantity = Integer.parseInt(txtBis.getText());
                price = 15.50;
                Need n = new Need(pN,quantity,price);
                needList.add(n);

                if(quantity<3)
                {
                    tot = (n.getPrice()*n.getQuantity());
                    gTot = tot;
                }
                else
                {
                    tot = n.calcDis()*n.getQuantity();
                    gTot = tot;
                }
                PBis.setText(String.valueOf(gTot));

            }

            dTotal = Double.parseDouble(PBW.getText())+Double.parseDouble(PS.getText())+Double.parseDouble(PB.getText())
            +Double.parseDouble(PIN.getText())+Double.parseDouble(PBis.getText());
            double pNeed = dTotal+3.00;

            txtPay.setText(String.valueOf(dTotal));
            txtTot.setText(String.valueOf(pNeed));

            for(int i=0; i<needList.size(); i++)
            {
                FileWriter writer = new FileWriter("ListNeeds.txt",true);
                writer.write(""+_sName+"\t"+_sID+"\t"+_sPhone+"\t"+_sCollege+"\t"+needList.get(i).getProductName().replace(" ", "_")+"\t"+needList.get(i).getQuantity()+"\t"+needList.get(i).getPrice()+"\t"+gTot);
                writer.write("\n");
                writer.close();
            }
            
            JOptionPane.showMessageDialog(null, "Add Item Success");
        }
        catch(Exception e)
        {

        }

        jtxtReceipt.setEnabled(true);

        jtxtReceipt.append("\tSystem Student Whereabouts\n" +
            "\n============================================\t" +
            "\n============================================\t" +
            "\n Items " + "\t |     Price " + "\t|     Quantity" + "\t|     Total" +
            "\n Body Wash " +"\t |     RM 10.00 "  + "\t|     "+ txtBW.getText() +"\t|     RM "+ PBW.getText() +
            "\n Shampoo " +"\t |     RM 12.50 "    + "\t|     "+ txtS.getText()  +"\t|     RM "+ PS.getText() +
            "\n Bread " +"\t |     RM 5.50"       + "\t|     "+ txtB.getText()  +"\t|     RM "+ PB.getText() +
            "\n Instant Noodles "+"|     RM 8.50 "+ "\t|     "+ txtIN.getText() +"\t|     RM "+ PIN.getText() +
            "\n Biscuit "+"\t |     RM 15.50 "      + "\t|     "+ txtBis.getText()+"\t|     RM "+ PBis.getText() +
            "\n============================================\t" +
            "\n Total Paid "     +"\t\t\t :   RM "  + txtPay.getText()+
            "\n Charge Delivery "+"\t\t"  +" :   RM 3.00"+
            "\n Grand Total "    +"\t\t\t :   RM "  + txtTot.getText()+
            "\n============================================\t" +
            "\n================= THANK YOU =================");

    }//GEN-LAST:event_OkayActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed

        txtBW.setEnabled(false);
        txtS.setEnabled(false);
        txtB.setEnabled(false);
        txtIN.setEnabled(false);
        txtBis.setEnabled(false);

        txtBW.setText("0");
        txtS.setText("0");
        txtB.setText("0");
        txtIN.setText("0");
        txtBis.setText("0");
        txtTot.setText("");
        txtPay.setText("");
        PBW.setText("");
        PS.setText("");
        PB.setText("");
        PIN.setText("");
        PBis.setText("");

        jCbBW.setSelected(false);
        jCbS.setSelected(false);
        jCbB.setSelected(false);
        jCbIN.setSelected(false);
        jCbBis.setSelected(false);
    }//GEN-LAST:event_ResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListNeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListNeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListNeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListNeed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListNeed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton Okay;
    private javax.swing.JTextField PB;
    private javax.swing.JTextField PBW;
    private javax.swing.JTextField PBis;
    private javax.swing.JTextField PIN;
    private javax.swing.JTextField PS;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Save;
    public static java.awt.TextField college;
    private javax.swing.JCheckBox jCbB;
    private javax.swing.JCheckBox jCbBW;
    private javax.swing.JCheckBox jCbBis;
    private javax.swing.JCheckBox jCbIN;
    private javax.swing.JCheckBox jCbS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtxtReceipt;
    public static java.awt.TextField phone;
    public static java.awt.TextField studID;
    public static java.awt.TextField studName;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtBW;
    private javax.swing.JTextField txtBis;
    private javax.swing.JTextField txtIN;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtS;
    private javax.swing.JTextField txtTot;
    // End of variables declaration//GEN-END:variables
}
