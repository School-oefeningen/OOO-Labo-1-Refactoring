package ui;

import domain.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ShopUi {
    public static void main(String[] args) {
        Shop shop = new Shop();

        String fileName = "products.txt";
        loadProductsFromFile(fileName, shop);

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show products list\n5. Lent product\n\n0. Quit";
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
            } else if (choice == 4){
                shop.showProducts();
            } else if (choice == 5){
                shop.lentProduct();
            }
        }

        saveProductsToFile(fileName, shop.getProducts());
    }

    private static void loadProductsFromFile(String fileName, Shop shop) {
        File productsFile = new File(fileName);
        try {
            Scanner scannerFile = new Scanner(productsFile);
            while (scannerFile.hasNext()) {
                String s = scannerFile.nextLine();
                String[] parts = s.split(";");

                Product p = null;
                switch (parts[0]) {
                    case "Movie":
                        p = new Movie(parts[1], parts[2]);
                        break;
                    case "Game":
                        p = new Game(parts[1], parts[2]);
                        break;
                    case "Cd":
                        p = new Cd(parts[1], parts[2]);
                        break;
                }
                shop.addProduct(p);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void saveProductsToFile(String fileName, List<Product> products) {
        File productsFile = new File(fileName);
        try {
            PrintWriter writer = new PrintWriter(productsFile);
            for (Product p: products) {
                writer.println(p.toCSV());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}