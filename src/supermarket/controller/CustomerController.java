/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.dto.CustomerDto;
import supermarket.model.CustomerModel;

/**
 *
 * @author Sanjaya
 */
public class CustomerController {

    private final CustomerModel CUSTOMER_MODEL;

    public CustomerController() throws Exception {
        this.CUSTOMER_MODEL = new CustomerModel();
    }

    public String saveCustomer(CustomerDto customerDto) throws Exception {
        return CUSTOMER_MODEL.saveCustomer(customerDto);
    }

    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
        return CUSTOMER_MODEL.getAllCustomer();
    }

    public CustomerDto searchCustomer(String custId) throws Exception {
        return CUSTOMER_MODEL.searchCustomer(custId);
    }

    public String updateCustomer(CustomerDto customerDto) throws Exception {
        return CUSTOMER_MODEL.updateCustomer(customerDto);
    }

    public String deleteCustomer(CustomerDto customerDto) throws Exception {
        return CUSTOMER_MODEL.deleteCustomer(customerDto);

    }
}
