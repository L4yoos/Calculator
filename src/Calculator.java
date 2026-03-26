public class Calculator {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Calculator <num1> <num2>");
            return;
        }

        double a;
        double b;
        try {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Use number format.");
            return;
        }

        System.out.printf("Add result: %2f \n", add(a, b));
        System.out.printf("Subtract result: %2f \n", subtract(a, b));
        System.out.printf("Multiply result: %2f \n", multiply(a, b));
        System.out.printf("Divide result: %2f \n", divide(a, b));
        System.out.printf("Modulo result: %2f \n", modulo(a, b));
        System.out.printf("Power result: %2f \n", power(a, b));

        System.out.printf("%2f!: %2f \n", a, factorial(a));
        System.out.printf("%2f!: %2f \n", b, factorial(b));

        System.out.printf("Is num1 prime?: %b \n", isPrime(a));
        System.out.printf("Is num2 prime?: %b \n", isPrime(b));
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by ZERO.");
            return 0;
        }
        return a / b;
    }

    private static double modulo(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by ZERO.");
            return 0;
        }
        return a % b;
    }

    private static double power(double a, double b) {
        double result = 1;
        if (a == 0) {
            System.out.println("Cannot power ZERO.");
            return 0;
        }
        if (b < 0) {
            a = 1 / a;
            for (int i = 0; i > b; i--) {
                result *= a;
            }
        } else {
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        }
        return result;
    }

    private static boolean isPrime(double n) {
        if (n <= 1) return false; // (-infinity, 1)
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static double factorial(double n) {
        if (n < 0) {
            System.out.print("n must be > or = to 0 ");
            return 0;
        }
        double result = 1;
        while (n != 0) {
            result *= n; // 4! = 4 * 3 * 2 * 1
            n--;
        }
        return result;
    }
}
