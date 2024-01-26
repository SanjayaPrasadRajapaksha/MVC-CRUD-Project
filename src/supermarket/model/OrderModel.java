/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.model;

import java.sql.Connection;
import static supermarket.db.DBConnection.getInstance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.dto.OrderDetailDto;
import supermarket.dto.OrderDto;

/**
 *
 * @author Sanjaya
 */
public class OrderModel {

    private final Connection CONNECTION;

    public OrderModel() throws Exception {
        this.CONNECTION = getInstance().getConnection();
    }

    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception {
        try {

            CONNECTION.setAutoCommit(false);
            String orderSql = "INSERT INTO Orders VALUES(?,?,?)";
            PreparedStatement orderStatement = CONNECTION.prepareStatement(orderSql);
            orderStatement.setString(1, orderDto.getOrderID());
            orderStatement.setString(2, orderDto.getOrderDate());
            orderStatement.setString(3, orderDto.getCustID());

            boolean isOrderSave = orderStatement.executeUpdate() > 0;
            if (isOrderSave) {
                boolean isOrderDetaiSaved = true;

                String orderDetailSql = "INSERT INTO orderDetail VALUES(?,?,?,?)";
                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    PreparedStatement orderDetailStatemet = CONNECTION.prepareStatement(orderDetailSql);
                    orderDetailStatemet.setString(1, orderDto.getOrderID());
                    orderDetailStatemet.setString(2, orderDetailDto.getItemCode());
                    orderDetailStatemet.setInt(3, orderDetailDto.getOrderQTY());
                    orderDetailStatemet.setDouble(4, orderDetailDto.getDiscount());

                    if (!(orderDetailStatemet.executeUpdate() > 0)) {
                        isOrderDetaiSaved = false;
                    }
                }
                if (isOrderDetaiSaved) {
                    boolean isItemUpdate = true;

                    String itemUpdateSql = "UPDATE item SET QtyOnHand = QtyOnHand - ? WHERE ItemCode = ?";
                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                        PreparedStatement itemStatement = CONNECTION.prepareStatement(itemUpdateSql);
                        itemStatement.setInt(1, orderDetailDto.getOrderQTY());
                        itemStatement.setString(2, orderDetailDto.getItemCode());

                        if (!(itemStatement.executeUpdate() > 0)) {
                            isItemUpdate = false;
                        }
                    }

                    if (isItemUpdate) {
                        CONNECTION.commit();
                        return "Sucess";
                    } else {
                        CONNECTION.rollback();
                        return "Item Update Error";
                    }

                } else {
                    CONNECTION.rollback();
                    return "Order Detail Save Error";
                }

            } else {
                CONNECTION.rollback();
                return "Order Save Error";

            }
        } catch (Exception e) {
            CONNECTION.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            CONNECTION.setAutoCommit(true);
        }
    }
}
