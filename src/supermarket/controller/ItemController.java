/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.controller;

import java.util.ArrayList;
import supermarket.dto.ItemDto;
import supermarket.model.ItemModel;

/**
 *
 * @author Sanjaya
 */
public class ItemController {

    private final ItemModel ITEM_MODEL;

    public ItemController() throws Exception {
        this.ITEM_MODEL = new ItemModel();
    }

    public String saveItem(ItemDto itemDto) throws Exception {

        return ITEM_MODEL.saveItem(itemDto);
    }

    public ArrayList<ItemDto> getAllItem() throws Exception {

        return ITEM_MODEL.getAllItem();
    }

    public ItemDto searchItem(String itemCode) throws Exception {

        return ITEM_MODEL.searchItem(itemCode);
    }

    public String updateItem(ItemDto itemDto) throws Exception {

        return ITEM_MODEL.updateItem(itemDto);
    }

    public String deleteItem(ItemDto itemDto) throws Exception {

        return ITEM_MODEL.deleteItem(itemDto);
    }
}
