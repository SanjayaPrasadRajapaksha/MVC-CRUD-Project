/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import static supermarket.db.DBConnection.getInstance;
import supermarket.dto.ItemDto;

/**
 *
 * @author Sanjaya
 */
public class ItemModel {

    private final Connection CONNECTION;

    public ItemModel() throws Exception {
        this.CONNECTION = getInstance().getConnection();

    }

    public String saveItem(ItemDto itemDto) throws Exception {

        String sql = "INSERT INTO item VALUES(?,?,?,?,?)";

        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        statement.setString(1, itemDto.getItemCode());
        statement.setString(2, itemDto.getDescription());
        statement.setString(3, itemDto.getPackSize());
        statement.setDouble(4, itemDto.getUnitPrice());
        statement.setInt(5, itemDto.getQtyOnHand());

        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }

    public ArrayList<ItemDto> getAllItem() throws Exception {

        String sql = "SELECT * FROM item";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<ItemDto> ItemDtos = new ArrayList<>();

        while (resultSet.next()) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemCode(resultSet.getString("ItemCode"));
            itemDto.setDescription(resultSet.getString("Description"));
            itemDto.setPackSize(resultSet.getString("PackSize"));
            itemDto.setUnitPrice(resultSet.getDouble("UnitPrice"));
            itemDto.setQtyOnHand(resultSet.getInt("QtyOnHand"));

            ItemDtos.add(itemDto);
        }
        return ItemDtos;
    }

    public ItemDto searchItem(String itemCode) throws Exception {

        String sql = "SELECT * FROM item WHERE ItemCode=?";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        statement.setString(1, itemCode);
        ResultSet resultSet = statement.executeQuery();

        ItemDto itemDto;
        while (resultSet.next()) {
            itemDto = new ItemDto();
            itemDto.setItemCode(resultSet.getString("ItemCode"));
            itemDto.setDescription(resultSet.getString("Description"));
            itemDto.setPackSize(resultSet.getString("PackSize"));
            itemDto.setUnitPrice(resultSet.getDouble("UnitPrice"));
            itemDto.setQtyOnHand(resultSet.getInt("QtyOnHand"));

            return itemDto;
        }
        return null;
    }

    public String updateItem(ItemDto itemDto) throws Exception {
        String sql = "UPDATE item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);

        statement.setString(1, itemDto.getDescription());
        statement.setString(2, itemDto.getPackSize());
        statement.setDouble(3, itemDto.getUnitPrice());
        statement.setInt(4, itemDto.getQtyOnHand());
        statement.setString(5, itemDto.getItemCode());
        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }

    }

    public String deleteItem(ItemDto itemDto) throws Exception {
        String sql = "DELETE FROM item WHERE ItemCode=?";
        PreparedStatement statement = CONNECTION.prepareStatement(sql);
        statement.setString(1, itemDto.getItemCode());
        if (statement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}
