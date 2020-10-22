package domain;

public class Movie implements ProductBehaviour {
    private final static int PRICE = 5;


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
