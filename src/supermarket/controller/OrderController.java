/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controller;

import java.util.ArrayList;
import supermarket.dto.OrderDetailDto;
import supermarket.dto.OrderDto;
import supermarket.model.OrderModel;

/**
 *
 * @author Sanjaya
 */
public class OrderController {

    private final OrderModel ORDER_MODEL;

    public OrderController() throws Exception {
        this.ORDER_MODEL = new OrderModel();
    }

    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception {
        return ORDER_MODEL.placeOrder(orderDto, orderDetailDtos);
    }
}
