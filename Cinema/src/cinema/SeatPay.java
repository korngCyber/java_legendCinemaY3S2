/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kheang
 */
public class SeatPay {

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the seatPay
     */
    public static List<SeatPay> getSeatPay() {
        return seatPay;
    }

    /**
     * @param aSeatPay the seatPay to set
     */
    public static void setSeatPay(List<SeatPay> aSeatPay) {
        seatPay = aSeatPay;
    }

    public SeatPay() {
    }

    public SeatPay(String seatId, String seat,String price) {
        this.seatId = seatId;
        this.seat = seat;
        this.price=price;
        seatPay.add(this);
    }

    
    /**
     * @return the seatId
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * @param seatId the seatId to set
     */
    public void setSeatId(String seatId) {
        this.seatId = seatId;
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
    private String seatId;
    private String seat;
    private String price;
    private static List<SeatPay> seatPay=new ArrayList<SeatPay>();
}
