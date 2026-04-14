import java.util.Scanner;

// Utility Class (No object needed)
class ConverterEngine {

    // Static Exchange Rates
    public static final double USD_TO_INR = 83.0;
    public static final double EUR_TO_INR = 90.0;
    public static final double GBP_TO_INR = 105.0;

    // Static Method for Conversion
    public static double convert(double amount, String currencyType) {

        switch (currencyType.toUpperCase()) {

            case "USD":
                return amount * USD_TO_INR;

            case "EUR":
                return amount * EUR_TO_INR;

            case "GBP":
                return amount * GBP_TO_INR;

            default:
                System.out.println("❌ Invalid Currency Type!");
                return 0;
        }
    }
}

// Main Class
public class CurrencyConverterApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====== Global Currency Converter ======");

        // Input Amount
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // Input Currency
        System.out.print("Enter Currency (USD / EUR / GBP): ");
        String currency = sc.next();

        // Call Static Method
        double result = ConverterEngine.convert(amount, currency);

        // Output
        if (result != 0) {
            System.out.println("✅ Converted Amount in INR: " + result);
        }

        sc.close();
    }
}