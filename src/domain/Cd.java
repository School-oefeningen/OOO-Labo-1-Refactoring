package domain;

public class Cd extends Product {

    public Cd(String productTitle, String productId) {
        super(productTitle, productId);
    }

    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }
}
