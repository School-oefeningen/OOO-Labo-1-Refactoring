package domain;

import java.util.Comparator;

public class ComparatorByType implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        if (p1 == null || p2 == null) return 1;

        if (p1.getClass() == p2.getClass()) {
            return 0;
        } else if (p1 instanceof Movie) {
            return -1;
        } else if (p1 instanceof Game && !(p2 instanceof Movie)) {
            return -1;
        } else {
            return 1;
        }
    }
}
