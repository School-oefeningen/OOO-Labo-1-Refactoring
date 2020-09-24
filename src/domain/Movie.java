package domain;

public class Movie extends Product {
    private final static int PRICE = 5;

    public Movie(String productTitle, String productId) {
        super(productTitle, productId);
    }

    @Override
    public double getPrice(int days) {
        int tempPrice = PRICE;
        int daysLeft = days - 3;
        if (daysLeft > 0) {
            tempPrice += (daysLeft * 2);
        }
        return tempPrice;
    }
}
