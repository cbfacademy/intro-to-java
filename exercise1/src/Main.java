import java.util.Scanner;

public class Main {
    private class Product{
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
    private final Product[] products = new Product[]{
            new Product("water", 1.0F),
            new Product("sprite", 1.2F),
            new Product("cola", 1.3F),
            new Product("fanta", 1.1F),
            new Product("orange", 1.5F)
    };
    private static float balance = 0;

    public static void main(String[] args)
    {
        try
        {
            Main app = new Main();
            app.run();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run() {
        int selectedItem;

        do {
            showContents();
            selectedItem = getUserSelection();

            if (selectedItem != 0) {
                dispenseItem(selectedItem - 1);
            }
        } while (selectedItem != 0);

        System.out.printf("Amount to pay: £%.2f", balance);
    }

    public void showContents() {
        System.out.println("+---------------------------+");
        System.out.println("|      Vending Machine      |");
        System.out.println("+---------------------------+");

        for(int i = 0; i < products.length; i++) {
            System.out.printf(
                    "|   %s   %s £%.2f [%s]   |%n",
                    i+1,
                    formatFixedLengthString(products[i].getName(), 6),
                    products[i].getPrice(),
                    formatFixedLengthString(Integer.toString(products[i].getStock()), 2)
            );
        }
        System.out.println("+---------------------------+");
    }

    private static String formatFixedLengthString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }

    private static int getUserSelection() {
        Scanner readInput = new Scanner(System.in);
        System.out.print("Enter a number (0 = Exit): ");

        try {
            return readInput.nextInt();
        } catch (Exception e) {
            System.out.println("Please input a number!");
            return -1;
        }
    }

    private void dispenseItem(int index) {
        if (index < 0 || index >= this.products.length) {
            System.out.println("Invalid option selected, please try again");

            return;
        }

        Product product = products[index];

        if(product.dispense()) {
            balance = balance + product.getPrice();
        }
    }
}