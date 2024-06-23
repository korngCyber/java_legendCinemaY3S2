package cinema;

import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Kheang
 */
public class SubJbutton extends JButton { 

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
//when extend it mean SubJbutton=button
    
    private static ArrayList<SubJbutton> sold=new ArrayList<>();
    private int id;
    private double price;
    public SubJbutton()
    {
        this.setBackground(new Color(255,51,51));
        this.setForeground(new Color(255,255,255));
        this.addActionListener((e)->{ //add event to subj button
            thisActionperformed(e);
        });
    }
    public SubJbutton(String txt)
    {
        this(); //call constructor above;
        this.setText(txt);
        this.txt=txt;
    }
    private String txt;
    //create event click for button
    private void thisActionperformed(ActionEvent evt)
    {
        //JOptionPane.showMessageDialog(this, this.getText());
       
        try
        {
            String seat=this.getText();
            Color c=this.getBackground();
            Color free=new Color(255,51,51);
            if(c.getRGB()==free.getRGB())
            {
                DatabaseConnection.getDatacon().setAutoCommit(false);
                String sql = "SELECT Roomid, Price FROM tbRooms WHERE Seat = '"+seat+"' AND status = 0 FOR UPDATE"; // for update use to lock row in transaction

                Statement statement=DatabaseConnection.getDatacon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = statement.executeQuery(sql);
                if(rs.first()) //rs.first() means there's selected data
                {
                    id=rs.getInt(1);
                    price=rs.getDouble(2);
                    sql="UPDATE tbRooms SET Status=-1 WHERE Seat='"+seat+"' AND Status=0";
                    int count=statement.executeUpdate(sql);
                    if(count>0)
                    {
                        getSold().add(this);
                        this.setBackground(Color.GREEN);
                        this.setText("✔");
                        
                        //JOptionPane.showMessageDialog(this,"Testing");
                        DatabaseConnection.getDatacon().commit();
                        DatabaseConnection.getDatacon().setAutoCommit(true);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, seat+"\t busy");
                }
                rs.close();
                statement.close();
            }
             else if(c.getRGB()==Color.GREEN.getRGB()) //return background color if the button already gray
            {
                Statement st=DatabaseConnection.getDatacon().createStatement();
                String sql="UPDATE tbRooms SET Status=0 WHERE Roomid="+id;
                st.execute(sql);
                getSold().remove(this);
                this.setBackground(free);
                this.setText(txt);    
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Sold Out");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        
       
       
    }

    /**
     * @return the sold
     */
    public static ArrayList<SubJbutton> getSold() {
        return sold;
    }

    /**
     * @param aSold the sold to set
     */
    public static void setSold(ArrayList<SubJbutton> aSold) {
        sold = aSold;
    }
}
