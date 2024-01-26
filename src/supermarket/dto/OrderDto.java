/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dto;

/**
 *
 * @author Sanjaya
 */
public class OrderDto {

    private String orderID;
    private String orderDate;
    private String custID;

    public OrderDto() {
    }

    public OrderDto(String orderID, String orderDate, String custID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", custID=" + custID + '}';
    }

}
