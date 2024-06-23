/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cinema;

import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Kheang
 */
public class MultiButtons extends javax.swing.JPanel {

    public MultiButtons() {
        initComponents();
        createButtons();
    }
    private void createButtons()
    {
        this.removeAll(); //remove all component on panel
        setBtn(new SubJbutton[getRow()][getCol()]);
        String txt;
        int x=5,y=5;
        for(int i=0;i<getBtn().length;i++)
        {
            x=5;
            for(int j=0;j<getBtn()[i].length;j++)
            {
                txt=(char)('A'+i)+"-"+(j+1); //ASCII code A=65 --> A+i=65, i=0 char conver from 65 to A
                getBtn()[i][j]=new SubJbutton(txt); //parameter txt throw to constructor SubJbutton for intialize
                add(getBtn()[i][j],new AbsoluteConstraints(x, y, 60, 30));
                x+=65; //x absis distance btn from one to other by width 65;
            }
            y+=35; // after loop j end y absis change position increase height= 35
        }
    }
    private int row=20,col=30;
    private SubJbutton [][]btn;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
        createButtons();
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
        createButtons();
    }

    /**
     * @return the btn
     */
    public SubJbutton[][] getBtn() {
        return btn;
    }

    /**
     * @param btn the btn to set
     */
    public void setBtn(SubJbutton[][] btn) {
        this.btn = btn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
