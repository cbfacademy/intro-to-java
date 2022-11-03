public class Product{
    private final String name;
    private final float price;
    private int stock;

    public Product(String main, float price) {
        this(main, price, 10);
    }
    public Product(String name, float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public boolean dispense() {
        if (this.stock <= 0) {
            System.out.printf("Sorry, %s is out of stock%n", this.getName());

            return false;
        }

        this.stock--;

        return true;
    }
}