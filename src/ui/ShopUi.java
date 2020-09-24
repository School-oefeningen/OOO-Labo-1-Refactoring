package ui;

import domain.Shop;

import javax.swing.*;

public class ShopUi {
    public static void main(String[] args) {
        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
               shop.addProduct();
            } else if (choice == 2) {
                shop.showProduct();
            } else if (choice == 3){
                shop.showPrice();
            }
        }
    }
}