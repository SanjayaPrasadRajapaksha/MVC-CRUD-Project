/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.model;

import java.sql.Connection;
import static supermarket.db.DBConnection.getInstance;
import supermarket.dto.CustomerDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    private final Connection CONNECTION;

    public CustomerModel() throws Exception {
        this.CONNECTION = getInstance().getConnection();
    }

    public String saveCustomer(CustomerDto customerDto) throws Exception {

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        statement.setString(1, customerDto.getId());
        statement.setString(2, customerDto.getTitle());
        statement.setString(3, customerDto.getName());
        statement.setString(4, customerDto.getDob());
        statement.setDouble(5, customerDto.getSalary());
        statement.setString(6, customerDto.getAddress());
        statement.setString(7, customerDto.getCity());
        statement.setString(8, customerDto.getProvince());
        statement.setString(9, customerDto.getZip());
        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }

    }

    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
        String sql = "SELECT * FROM Customer";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getString("CustID"));
            customerDto.setTitle(resultSet.getString("CustTitle"));
            customerDto.setName(resultSet.getString("CustName"));
            customerDto.setDob(resultSet.getString("DOB"));
            customerDto.setSalary(resultSet.getDouble("salary"));
            customerDto.setAddress(resultSet.getString("CustAddress"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setProvince(resultSet.getString("Province"));
            customerDto.setZip(resultSet.getString("PostalCode"));

            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    public CustomerDto searchCustomer(String custId) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE CustID=?";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        statement.setString(1, custId);
        ResultSet resultSet = statement.executeQuery();

        CustomerDto customerDto;
        while (resultSet.next()) {
            customerDto = new CustomerDto();
            customerDto.setId(resultSet.getString("CustID"));
            customerDto.setTitle(resultSet.getString("CustTitle"));
            customerDto.setName(resultSet.getString("CustName"));
            customerDto.setDob(resultSet.getString("DOB"));
            customerDto.setSalary(resultSet.getDouble("salary"));
            customerDto.setAddress(resultSet.getString("CustAddress"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setProvince(resultSet.getString("Province"));
            customerDto.setZip(resultSet.getString("PostalCode"));

            return customerDto;
        }
        return null;
    }

    public String updateCustomer(CustomerDto customerDto) throws Exception {
        String sql = "UPDATE Customer SET CustTitle=?, CustName=?, DOB=?, salary=?, CustAddress=?, City=?, Province=?, PostalCode=? WHERE CustID=?";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);

        statement.setString(1, customerDto.getTitle());
        statement.setString(2, customerDto.getName());
        statement.setString(3, customerDto.getDob());
        statement.setDouble(4, customerDto.getSalary());
        statement.setString(5, customerDto.getAddress());
        statement.setString(6, customerDto.getCity());
        statement.setString(7, customerDto.getProvince());
        statement.setString(8, customerDto.getZip());
        statement.setString(9, customerDto.getId());
        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }

    public String deleteCustomer(CustomerDto customerDto) throws Exception {
        String sql = "DELETE FROM Customer WHERE CustID=?";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        statement.setString(1, customerDto.getId());

        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}
