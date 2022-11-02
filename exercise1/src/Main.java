import java.util.Scanner;

public class Main {
    private class Product{

    }
    private static final String[] products = new String[]{"water","sprite","cola","fanta","orange"};
    private static final float[] prices = new float[]{1.0F,1.2F,1.3F,1.1F,1.5F};
    private static final int[] stock = new int[]{10,10,10,10,10};
    private static float balance = 0;

    public static void main(String[] args)
    {
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

    public static void showContents() {
        System.out.println("+---------------------------+");
        System.out.println("|      Vending Machine      |");
        System.out.println("+---------------------------+");

        for(int i = 0; i < products.length; i++) {
            System.out.printf(
                    "|   %s   %s £%.2f [%s]   |%n",
                    i+1,
                    formatFixedLengthString(products[i], 6),
                    prices[i],
                    formatFixedLengthString(Integer.toString(stock[i]), 2)
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

    private static void dispenseItem(int index) {
        if (index < 0 || index >= stock.length) {
            System.out.println("Invalid option selected, please try again");

            return;
        }

        if (stock[index] <= 0) {
            System.out.printf("Sorry, %s is out of stock%n", products[index]);

            return;
        }

        stock[index] = stock[index] - 1;
        balance = balance + prices[index];
    }
}