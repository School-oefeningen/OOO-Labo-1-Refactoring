package domain;

import java.util.Comparator;

public class ComparatorByType implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        if (p1 == null || p2 == null) return 1;

        if (p1.getProductBehaviour() == p2.getProductBehaviour()) {
            return p1.getProductId().compareTo(p2.getProductId());
        } else if (p1.getProductBehaviour() instanceof Movie) {
            return -1;
        } else if (p1.getProductBehaviour() instanceof Game && !(p2.getProductBehaviour() instanceof Movie)) {
            return -1;
        } else {
            return 1;
        }
    }
}