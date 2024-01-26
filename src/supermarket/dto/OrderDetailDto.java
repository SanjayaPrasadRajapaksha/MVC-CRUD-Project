/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.dto;

/**
 *
 * @author Sanjaya
 */
public class OrderDetailDto {

    private String orderID;
    private String ItemCode;
    private Integer OrderQTY;
    private Double Discount;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String orderID, String ItemCode, Integer OrderQTY, Double Discount) {
        this.orderID = orderID;
        this.ItemCode = ItemCode;
        this.OrderQTY = OrderQTY;
        this.Discount = Discount;
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
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the OrderQTY
     */
    public Integer getOrderQTY() {
        return OrderQTY;
    }

    /**
     * @param OrderQTY the OrderQTY to set
     */
    public void setOrderQTY(Integer OrderQTY) {
        this.OrderQTY = OrderQTY;
    }

    /**
     * @return the Discount
     */
    public Double getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(Double Discount) {
        this.Discount = Discount;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" + "orderID=" + orderID + ", ItemCode=" + ItemCode + ", OrderQTY=" + OrderQTY + ", Discount=" + Discount + '}';
    }
    
    
}
