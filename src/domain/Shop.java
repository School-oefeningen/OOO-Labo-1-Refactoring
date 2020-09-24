package domain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        products.sort(new ComparatorByType());
        return products;
    }

    public void addProduct() {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for cd):");

        try {
            Product p = null;
            String id = Integer.toString(products.size() + 1);
            switch (type.trim().toLowerCase()) {
                case "m":
                    p = new Movie(title, id);
                    break;
                case "g":
                    p = new Game(title, id);
                    break;
                case "c":
                    p = new Cd(title, id);
                    break;
            }
            products.add(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addProduct(Product p) {
        if (p != null) {
            products.add(p);
        }
    }

    public void showProduct() {
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product p = findProduct(id);
        if (p != null) {
            String out = p.getProductTitle() + "\n";
            if (p.isAvailable()) out += "The product is available.";
            else out += "The product is being lent.";
            JOptionPane.showMessageDialog(null, out);
        }
    }

    public void showProducts() {
        if (!products.isEmpty()) {
            String out = "";
            for (Product p: getProducts()) {
                out += p.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, out);
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

    public void lentProduct() {
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product p = findProduct(id);
        if (p != null && p.isAvailable()) {
            p.setLent();
            String out = "The product '" + p.getProductTitle() + "' is now being lent.";
            JOptionPane.showMessageDialog(null, out);
        }
    }
}
