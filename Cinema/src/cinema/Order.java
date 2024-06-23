/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cinema;

import java.text.DecimalFormat;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Kheang
 */
public class Order extends javax.swing.JDialog {

    
    public double getAmount() {
        return amount;
    }

   
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getDis() {
        return dis;
    }
    
    /**
     * @param dis the dis to set
     */
    public void setDis(double dis) {
        this.dis = dis;
    }

    /**
     * @return the disPrice
     */
    public double getDisPrice() {
        return disPrice;
    }

    /**
     * @param disPrice the disPrice to set
     */
    public void setDisPrice(double disPrice) {
        this.disPrice = disPrice;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public double getRecieved() {
        return recieved;
    }

    
    public void setRecieved(double recieved) {
        this.recieved = recieved;
    }

    /**
     * @return the returned
     */
    public double getReturned() {
        return returned;
    }

    /**
     * @param returned the returned to set
     */
    public void setReturned(double returned) {
        this.returned = returned;
    }

    /**
     * @return the click
     */
    public int getClick() {
        return click;
    }

    /**
     * @param click the click to set
     */
    public void setClick(int click) {
        this.click = click;
    }

    public Order() {
    }
    
    /** Creates new form Order */
    public Order(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private double amount,dis,disPrice,total,recieved,returned;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRecieved = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtReturn = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDisPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        comboDis = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("!Khmer OS Siemreap", 0, 18)); // NOI18N
        setMaximumSize(new java.awt.Dimension(557, 618));
        setMinimumSize(new java.awt.Dimension(557, 618));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amount:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 170, 90, 21);

        txtAmount.setEditable(false);
        txtAmount.setBackground(new java.awt.Color(0, 0, 0));
        txtAmount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(255, 255, 255));
        txtAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(txtAmount);
        txtAmount.setBounds(230, 160, 209, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Received:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 400, 90, 21);

        txtRecieved.setBackground(new java.awt.Color(0, 0, 0));
        txtRecieved.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtRecieved.setForeground(new java.awt.Color(255, 255, 255));
        txtRecieved.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtRecieved.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRecievedKeyReleased(evt);
            }
        });
        getContentPane().add(txtRecieved);
        txtRecieved.setBounds(230, 400, 209, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Return:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 450, 90, 21);

        txtReturn.setEditable(false);
        txtReturn.setBackground(new java.awt.Color(0, 0, 0));
        txtReturn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtReturn.setForeground(new java.awt.Color(255, 255, 255));
        txtReturn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(txtReturn);
        txtReturn.setBounds(230, 450, 209, 22);

        btnPay.setBackground(new java.awt.Color(153, 0, 0));
        btnPay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPay);
        btnPay.setBounds(120, 510, 280, 28);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Discount:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 220, 90, 21);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Discount Price:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 280, 120, 21);

        txtDisPrice.setEditable(false);
        txtDisPrice.setBackground(new java.awt.Color(0, 0, 0));
        txtDisPrice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDisPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtDisPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(txtDisPrice);
        txtDisPrice.setBounds(230, 280, 209, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Payment:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 340, 120, 21);

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(0, 0, 0));
        txtTotal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(txtTotal);
        txtTotal.setBounds(230, 336, 209, 30);

        comboDis.setBackground(new java.awt.Color(0, 0, 0));
        comboDis.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboDis.setForeground(new java.awt.Color(255, 255, 255));
        comboDis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "10%", "20%", "30%", "40%", "50%" }));
        comboDis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        comboDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDisActionPerformed(evt);
            }
        });
        getContentPane().add(comboDis);
        comboDis.setBounds(230, 220, 209, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_image/legend-cinema-logo-pay.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(180, 20, 190, 100);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_image/gradient_img (6) pay.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 560, 620);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private int click=0;
    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        setClick(1);
        this.dispose();
    }//GEN-LAST:event_btnPayActionPerformed
    DecimalFormat dec=new DecimalFormat("$0.00");
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        btnPay.setEnabled(false);
        amount=TotalAmount();
        txtAmount.setText(dec.format(amount));
        comboDisActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened

    private void comboDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDisActionPerformed
        String d=comboDis.getSelectedItem()+"";
        d=d.substring(0,d.length()-1);
        setDis(Double.parseDouble(d));
        disPrice=amount*(getDis()/100);
        txtDisPrice.setText(dec.format(disPrice));
        total=amount-disPrice;
        txtTotal.setText(dec.format(total));
        
    }//GEN-LAST:event_comboDisActionPerformed

    private void txtRecievedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecievedKeyReleased
       try
       {
           recieved=Double.parseDouble(txtRecieved.getText());
           returned=recieved-total;
           txtReturn.setText(dec.format(returned));
           if(recieved>=total)
           {
               btnPay.setEnabled(true);
           }
           else
               btnPay.setEnabled(false);
 
       }
       catch(Exception ex)
       {
           txtReturn.setText(dec.format("$0"));
           btnPay.setEnabled(false);
       }
    }//GEN-LAST:event_txtRecievedKeyReleased
    private double TotalAmount()
    {
        double t=0;
        double newPrice;
        for(int i=0;i<SeatPay.getSeatPay().size();i++)
        {
            String ordPrice=SeatPay.getSeatPay().get(i).getPrice();
            newPrice=Double.parseDouble(ordPrice);
            t+=newPrice;
        }
        return t;
    }
    public void PrintReport() throws Exception
    {
        JasperReport jp=JasperCompileManager.compileReport("D:\\CinemaProject\\Report\\Payment1.jrxml");
        HashMap<String, Object> para = new HashMap<>(); //object for parameter in report
        para.put("Seller", DatabaseConnection.getUser());
 
        System.out.println("Seller: " + DatabaseConnection.getUser());
        System.out.println("Discount: " + getDis());
        System.out.println("Received: " + getRecieved());

        para.put("dis",getDis()/100);
        para.put("recieved", getRecieved());
        JRBeanCollectionDataSource jcd=new JRBeanCollectionDataSource(Report.data()); //object for detail in report
        JasperPrint print=JasperFillManager.fillReport(jp, para, jcd);
        //JasperViewer.viewReport(print, false);
        JasperPrintManager.printReport(print, false);
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Order dialog = new Order(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox<String> comboDis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDisPrice;
    private javax.swing.JTextField txtRecieved;
    private javax.swing.JTextField txtReturn;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
