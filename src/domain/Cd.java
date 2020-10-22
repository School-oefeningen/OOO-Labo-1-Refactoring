package domain;

public class Cd implements ProductBehaviour {

    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }
}
