/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;

import java.util.logging.Level;
import java.util.logging.Logger;
import supermarket.view.CustomerView;
import supermarket.view.ItemView;
import supermarket.view.OrderView;

/**
 *
 * @author Sanjaya
 */
public class Main {

    public static void main(String[] args) {
        try {
           //new CustomerView().setVisible(true);
           //new ItemView().setVisible(true);
           new OrderView().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
