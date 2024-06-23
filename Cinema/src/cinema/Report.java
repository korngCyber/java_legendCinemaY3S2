/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Kheang
 */
public class Report {

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the seat
     */
    public String getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(String seat) {
        this.seat = seat;
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

    /**
     * @return the reports
     */
    public static List<Report> getReports() {
        return reports;
    }

    /**
     * @param aReports the reports to set
     */
    public static void setReports(List<Report> aReports) {
        reports = aReports;
    }
    private int no;
    private String seat;
    private double price;
    private static List<Report> reports=new ArrayList<>();

    public Report() {
    }

    public Report(int no, String seat, double price) {
        this.no = no;
        this.seat = seat;
        this.price = price;
    }
    public static Collection<Report> data()
    {
        reports.clear();
        int i=0;
        for(SeatPay s:SeatPay.getSeatPay())
        {
            i++;
            String titleSeat=s.getSeat();
            double prices=Double.parseDouble(s.getPrice());
            Report r=new Report(i,titleSeat,prices);
            reports.add(r);
        }
        return getReports();
    }
}
