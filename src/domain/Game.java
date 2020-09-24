package domain;

public class Game extends Product {

    public Game(String productTitle, String productId) {
        super(productTitle, productId);
    }

    @Override
    public double getPrice(int days) {
        return days * 3;
    }
}
