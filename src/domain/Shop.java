package domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    public void addProduct() {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        try {
            if (type.trim().toLowerCase().equals("m")) {
                Movie m = new Movie(title, id);
                products.add(m);

            } else if (type.trim().toLowerCase().equals("g")) {
                Game p = new Game(title, id);
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showProduct() {
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product p = findProduct(id);
        if (p != null) {
            JOptionPane.showMessageDialog(null, p.getProductTitle());
        }
    }

    public void showPrice() {
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product p = findProduct(id);
        if (p != null) {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, p.getPrice(days));
        }
    }

    private Product findProduct(String id) {
        int idx = -1;
        boolean found = false;
        for (int i = 0; i < products.size() && !found; i++) {
            if (products.get(i).getProductId().equals(id)) {
                idx = i;
                found = true;
            }
        }
        if (found) {
            return products.get(idx);
        }
        return null;
    }
}
