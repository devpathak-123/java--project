import java.util.Scanner;

// ===================== ENCAPSULATION =====================
class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ===================== ABSTRACTION =====================
abstract class Currency {

    protected double amount;

    public Currency(double amount) {
        this.amount = amount;
    }

    public abstract double convert();

    // Method Overloading
    public void displayCurrency() {
        System.out.println("Currency Conversion");
    }

    public void displayCurrency(String currency) {
        System.out.println("Selected Currency: " + currency);
    }
}

// ===================== INHERITANCE + POLYMORPHISM =====================
class USDConverter extends Currency {

    public static final double RATE = 83.0;

    public USDConverter(double amount) {
        super(amount);
    }

    @Override
    public double convert() {
        return amount * RATE;
    }
}

class EURConverter extends Currency {

    public static final double RATE = 90.0;

    public EURConverter(double amount) {
        super(amount);
    }

    @Override
    public double convert() {
        return amount * RATE;
    }
}

class GBPConverter extends Currency {

    public static final double RATE = 105.0;

    public GBPConverter(double amount) {
        super(amount);
    }

    @Override
    public double convert() {
        return amount * RATE;
    }
}

// ===================== UTILITY CLASS =====================
class ConversionHistory {

    private static int totalConversions = 0;

    public static void addConversion() {
        totalConversions++;
    }

    public static void showHistory() {
        System.out.println("--------------------------------");
        System.out.println("Total Conversions Performed: "
                + totalConversions);
        System.out.println("--------------------------------");
    }
}

// ===================== MAIN APPLICATION =====================
public class CurrencyConverterAppfull {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("      GLOBAL CURRENCY CONVERTER");
        System.out.println("======================================");

        System.out.print("Enter Your Name: ");
        String userName = sc.nextLine();

        User user = new User(userName);

        int choice;

        do {

            System.out.println("\nWelcome, " + user.getName());

            System.out.println("\nChoose Currency:");
            System.out.println("1. USD to INR");
            System.out.println("2. EUR to INR");
            System.out.println("3. GBP to INR");
            System.out.println("4. View Conversion History");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            Currency currency = null;

            switch (choice) {

                case 1:

                    System.out.print("Enter Amount in USD: ");
                    double usdAmount = sc.nextDouble();

                    currency = new USDConverter(usdAmount);

                    currency.displayCurrency("USD");

                    System.out.println(
                            "Converted INR = ₹"
                                    + currency.convert());

                    ConversionHistory.addConversion();
                    break;

                case 2:

                    System.out.print("Enter Amount in EUR: ");
                    double eurAmount = sc.nextDouble();

                    currency = new EURConverter(eurAmount);

                    currency.displayCurrency("EUR");

                    System.out.println(
                            "Converted INR = ₹"
                                    + currency.convert());

                    ConversionHistory.addConversion();
                    break;

                case 3:

                    System.out.print("Enter Amount in GBP: ");
                    double gbpAmount = sc.nextDouble();

                    currency = new GBPConverter(gbpAmount);

                    currency.displayCurrency("GBP");

                    System.out.println(
                            "Converted INR = ₹"
                                    + currency.convert());

                    ConversionHistory.addConversion();
                    break;

                case 4:

                    ConversionHistory.showHistory();
                    break;

                case 5:

                    System.out.println(
                            "\nThank You For Using Currency Converter!");
                    break;

                default:

                    System.out.println(
                            "\nInvalid Choice! Please Try Again.");
            }

        } while (choice != 5);

        sc.close();
    }
}