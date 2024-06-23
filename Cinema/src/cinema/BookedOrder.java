/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cinema;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Kheang
 */
public class BookedOrder extends javax.swing.JFrame {

    /** Creates new form BookedOrder */
    public BookedOrder() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        multiButtons1 = new cinema.MultiButtons();
        jScrollPane1 = new javax.swing.JScrollPane();
        multiButtons2 = new cinema.MultiButtons();
        btnBooking = new javax.swing.JButton();
        btnCheckin = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("!Khmer OS Siemreap", 0, 18)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1052, 779));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        multiButtons2.setBackground(new java.awt.Color(0, 0, 0));
        multiButtons2.setToolTipText("");
        multiButtons2.setDoubleBuffered(false);
        jScrollPane1.setViewportView(multiButtons2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 969, 550);

        btnBooking.setBackground(new java.awt.Color(255, 51, 0));
        btnBooking.setForeground(new java.awt.Color(255, 255, 255));
        btnBooking.setText("Booking");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });
        getContentPane().add(btnBooking);
        btnBooking.setBounds(40, 660, 200, 30);

        btnCheckin.setBackground(new java.awt.Color(255, 51, 0));
        btnCheckin.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckin.setText("Check in");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });
        getContentPane().add(btnCheckin);
        btnCheckin.setBounds(420, 660, 200, 30);

        btnOrder.setBackground(new java.awt.Color(255, 51, 0));
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrder);
        btnOrder.setBounds(810, 650, 200, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Screen");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 50, 310, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_image/gradient_nuyticket(6) (1) (1).png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1090, 780);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private String insertBooking(String phone) throws Exception
    { 
        //insert into booking
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
        String date=sdf.format(System.currentTimeMillis());
        sdf=new SimpleDateFormat("HH:mm:ss");
        String time=sdf.format(System.currentTimeMillis());
        String UserName=DatabaseConnection.getUser();
        String sql="INSERT INTO Booking(bookDate,bTime,telephone,Seller) VALUES(?,?,?,?)";
        PreparedStatement ps=DatabaseConnection.getDatacon().prepareStatement(sql);
        ps.setString(1,date);
        ps.setString(2, time);
        ps.setString(3, phone);
        ps.setString(4, UserName);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Booking Successful");
        
        //catch id to insert into booking detail
        sql="SELECT LAST_INSERT_ID()";
        ps=DatabaseConnection.getDatacon().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=ps.executeQuery();
        rs.first();
        String id=rs.getString(1);
        rs.close();     
        ps.close();
        return id;
    }
    private void InsertBookingDetail(String id) throws Exception
    {
       for(int i=0;i<SubJbutton.getSold().size();i++)
       {
           int seat=SubJbutton.getSold().get(i).getId();
           String sql="SELECT Roomid,Price FROM tbRooms WHERE Roomid="+seat;
           Statement st=DatabaseConnection.getDatacon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet r=st.executeQuery(sql);
           if(r.first()){
                String roomID=r.getString(1);
                String prices=r.getString(2);
                sql="INSERT INTO BookingDetail(bookID,RoomID,Price) VALUES(?,?,?)";
                PreparedStatement ps=DatabaseConnection.getDatacon().prepareStatement(sql);
                ps.setString(1,id);
                ps.setString(2, roomID);
                ps.setString(3, prices);
                ps.execute();// executeUpdate is used only to verify if the update was successful
                ps.close();
                sql="UPDATE tbRooms SET Status=1 WHERE Roomid=?";
                ps=DatabaseConnection.getDatacon().prepareStatement(sql);
                ps.setString(1, roomID);
                ps.execute();
                ps.close();
           }
           r.close();
           st.close();
       }
        
    }
    private String InsertOrder() throws Exception
    {
            Order or=new Order();
            SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
            String date=sdf.format(System.currentTimeMillis());
            sdf=new SimpleDateFormat("HH:mm:ss");
            String time=sdf.format(System.currentTimeMillis());
            String seller=DatabaseConnection.getUser();
            String discount=or.getDis()+"";
            String sql="INSERT INTO `Order`(OrdDate,OrdTime,Discount,Seller) VALUES(?,?,?,?)";
            PreparedStatement ps=DatabaseConnection.getDatacon().prepareStatement(sql);
            ps.setString(1,date);
            ps.setString(2, time);
            ps.setString(3, discount);
            ps.setString(4, seller);
            ps.execute();
            ps.close();
            sql="SELECT LAST_INSERT_ID()";
            ps=DatabaseConnection.getDatacon().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=ps.executeQuery();
            rs.first();
            String ordId=rs.getString(1);
            rs.close();     
            ps.close();
            return ordId;  
    }
    private void InsertOrderDetail(String ordID)throws Exception
    {
        for(int i=0;i<SubJbutton.getSold().size();i++)
        {
            int seat=SubJbutton.getSold().get(i).getId();
            String sql="SELECT Roomid,Price FROM tbRooms WHERE Roomid="+seat;
            Statement s=DatabaseConnection.getDatacon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=s.executeQuery(sql);
            if(rs.first())
            {
                String roomid=rs.getString(1);
                String price=rs.getString(2);
                sql="INSERT INTO OrderDetail(OrdID,RoomID,Price) VALUES(?,?,?)";
                PreparedStatement ps=DatabaseConnection.getDatacon().prepareStatement(sql);
                ps.setString(1, ordID);
                ps.setString(2, roomid);
                ps.setString(3, price);
                ps.execute();
                ps.close();
            }
            rs.close();
            s.close();
        }
    }
    
    private void Pay() throws Exception
    {
        for(int i=0;i<SubJbutton.getSold().size();i++)
        {
            int seat=SubJbutton.getSold().get(i).getId();
            String sql="SELECT Roomid,Seat,Price FROM tbRooms WHERE Roomid='"+seat+"'";
            Statement st=DatabaseConnection.getDatacon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=st.executeQuery(sql);
            if(rs.first())
            {
                String seatID=rs.getString(1);
                String seatTitle=rs.getString(2);
                String seatPrice=rs.getString(3);
                SeatPay sp=new SeatPay(seatID,seatTitle,seatPrice);
            }
            st.close();
            rs.close();
        }
    }
    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        if(SubJbutton.getSold().size()>0)
        {
            try
            {
                String phone=JOptionPane.showInputDialog("Enter your phone number: "); //phone return null valued not empty string
                if(phone!=null) //phone kir chea object null jg method ey kor call ot ban dea bah yg juj cancel ng error
                {
                    //insert data into booking
                    String id=insertBooking(phone);
                    JOptionPane.showMessageDialog(this, id+"");
                    
                    InsertBookingDetail(id);
                    Statement st=DatabaseConnection.getDatacon().createStatement();
                    String sql;
                    for(SubJbutton s:SubJbutton.getSold())
                    {
                        s.setBackground(Color.lightGray);
                        sql="UPDATE tbRooms SET Status=1 WHERE Roomid= "+s.getId();
                        st.execute(sql);
                    }
                    //JOptionPane.showMessageDialog(this,SubJbutton.getSold().size()); //testing is selected flow correct or not
                    SubJbutton.getSold().clear();
                    st.close();
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
       
    }//GEN-LAST:event_btnBookingActionPerformed
    Timer time=new Timer(0,(e)->{   //delay 0 mean start without delay
        run();
    });
    private void run()
    {
        try
        {
            String sql="SELECT Seat,Status FROM tbRooms WHERE Status=1 OR Status=2";
            Statement st=DatabaseConnection.getDatacon().createStatement();
            ResultSet r=st.executeQuery(sql);
            while(r.next())
            {
                String seat=r.getString(1); //"A-1" Matrice(0,0)
                int stt=r.getInt(2);
                String []d=seat.split("-");
                int idx1=d[0].charAt(0)-65; //A=65 --> 65-65=0 -->idx1=0
                int idx2=Integer.valueOf(d[1])-1; //Seat 1-1=0 --> idx2=0
                SubJbutton subBtn=multiButtons2.getBtn()[idx1][idx2];
                subBtn.setForeground(Color.WHITE);
                if(stt==1)
                    subBtn.setBackground(Color.lightGray);
                else if(stt==2)
                    subBtn.setBackground(Color.GRAY);
                  
                
            }
            r.close();
            st.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       time.start();
       time.setDelay(3000); //delay after start 3 seconds
    }//GEN-LAST:event_formWindowOpened

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        CheckIn ch=new CheckIn(this, true);
        ch.setVisible(true);
    }//GEN-LAST:event_btnCheckinActionPerformed
  
    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
       if(SubJbutton.getSold().size()>0)
       {
           try
           {
                Order ord=new Order(this,true);
                Pay();
                ord.setVisible(true);
                if(ord.getClick()==1)
                {
                    //insert into order and select last index
                    String ordID=InsertOrder();
                    //insert lastindex of order into orderDetail
                    InsertOrderDetail(ordID);
                    //print report
                    ord.PrintReport();
                    
                    Statement st=DatabaseConnection.getDatacon().createStatement();
                    String sql;
                    for(SubJbutton s:SubJbutton.getSold())
                    {
                        s.setBackground(Color.GRAY);
                        sql="UPDATE tbRooms SET Status=2 WHERE Roomid= "+s.getId();
                        st.execute(sql);
                    }
                    SubJbutton.getSold().clear();
                    st.close();
                }
           }
           catch(Exception ex)
           {
               JOptionPane.showMessageDialog(this, ex.getMessage());
           }
       }
    }//GEN-LAST:event_btnOrderActionPerformed

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
            java.util.logging.Logger.getLogger(BookedOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookedOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookedOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookedOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookedOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnCheckin;
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private cinema.MultiButtons multiButtons1;
    private cinema.MultiButtons multiButtons2;
    // End of variables declaration//GEN-END:variables
}