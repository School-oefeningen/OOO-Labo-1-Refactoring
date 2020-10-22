package domain;

public class Game implements ProductBehaviour {

    @Override
    public double getPrice(int days) {
        return days * 3;
    }
}
