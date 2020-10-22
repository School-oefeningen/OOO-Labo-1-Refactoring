package domain;

import org.w3c.dom.DOMException;

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
            String id = Integer.toString(products.size() + 1);
            Product p = new Product(title, id);
            switch (type.trim().toLowerCase()) {
                case "m":
                    p.setProductBehaviour(new Movie());
                    break;
                case "g":
                    p.setProductBehaviour(new Game());
                    break;
                case "c":
                    p.setProductBehaviour(new Cd());
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

    private Product findProduct(String productId) {
        if (Checker.isEmptyString(productId)) throw new DomainException("Product id can't be empty");

        int idx = -1;
        boolean found = false;
        for (int i = 0; i < products.size() && !found; i++) {
            if (products.get(i).getProductId().equals(productId)) {
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
