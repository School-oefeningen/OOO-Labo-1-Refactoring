package domain;

public class Product {
    private ProductBehaviour productBehaviour;
    private String productTitle, productId;
    private boolean isAvailable;

    public Product(String productTitle, String productId) {
        setProductTitle(productTitle);
        setProductId(productId);
        isAvailable = true;
    }

    public ProductBehaviour getProductBehaviour() {
        return productBehaviour;
    }

    public void setProductBehaviour(ProductBehaviour productBehaviour) {
        this.productBehaviour = productBehaviour;
    }

    public String getProductTitle() {
        return productTitle;
    }

    private void setProductTitle(String productTitle) {
        if (Checker.isEmptyString(productTitle)) throw new DomainException("Producttitel can't be empty");
        this.productTitle = productTitle;
    }

    public String getProductId() {
        return productId;
    }

    private void setProductId(String productId) {
        if (Checker.isEmptyString(productId)) throw new DomainException("Product id can't be empty");
        this.productId = productId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setLent() {
        isAvailable = false;
    }

    public double getPrice(int days) {
        if (days <= 0) throw new DomainException("Amount of days can't be negative or zerp");
        return productBehaviour.getPrice(days);
    }

    public String toString() {
        return "Type: " + productBehaviour.getClass().getSimpleName() + ", id: " + productId + ", title: " + productTitle;
    }

    public String toCSV() {
        return productBehaviour.getClass().getSimpleName() + ";" + productTitle + ";" + productId;
    }
}
