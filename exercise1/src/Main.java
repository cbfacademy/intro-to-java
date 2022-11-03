import java.util.Scanner;

public class Main {
    private static final Product[] products = new Product[]{
            new Product("water", 1.0F),
            new Product("sprite", 1.2F),
            new Product("cola", 1.3F),
            new Product("fanta", 1.1F),
            new Product("orange", 1.5F)
    };
    private static float balance = 0;
    private static Scanner readInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        int selectedItem;

        do {
            showContents();
            selectedItem = getUserSelection();

            if (selectedItem > 0) {
                dispenseItem(selectedItem - 1);
            }
        } while (selectedItem != 0);

        System.out.printf("Amount to pay: £%.2f", balance);
    }

    public static void showContents() {
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
        System.out.print("Enter a number (0 = Exit): ");

        try {
            return readInput.nextInt();
        } catch (Exception e) {
            System.out.println("Please input a number!");
            readInput = new Scanner(System.in);
            return -1;
        }
    }

    private static void dispenseItem(int index) {
        if (index < 0 || index >= products.length) {
            System.out.println("Invalid option selected, please try again");

            return;
        }

        Product product = products[index];

        if(product.dispense()) {
            balance = balance + product.getPrice();
        }
    }
}