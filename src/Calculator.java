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

        System.out.printf("Add result: %.2f \n", add(a, b));
        System.out.printf("Subtract result: %.2f \n", subtract(a, b));
        System.out.printf("Multiply result: %.2f \n", multiply(a, b));
        System.out.printf("Divide result: %.2f \n", divide(a, b));
        System.out.printf("Modulo result: %.2f \n", modulo(a, b));
        System.out.printf("Power result: %.2f \n", power(a, b));

        System.out.printf("%.2f!: %d \n", a, factorial((int) a));
        System.out.printf("%.2f!: %d \n", b, factorial((int) b));

        System.out.printf("Is num1 prime?: %b \n", isPrime(a));
        System.out.printf("Is num2 prime?: %b \n", isPrime(b));

        System.out.printf("Sqrt num1 result: %.2f \n", sqrt(a));
        System.out.printf("Sqrt num2 result: %.2f \n", sqrt(b));
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

    // Newton method x = (x + n/x) / 2.0
    private static double sqrt(double n) {
        if (n < 0) {
            System.out.println("Cannot Sqrt by n < 0.");
            return 0.0;
        }
        double x = 0;
        double result = n / 2.0;

        while(x - result != 0) {
            x = result;
            result = (x + n/x) / 2.0;
        }

        return result;
    }

    private static double power(double a, double b) {
        //todo fix when B is fraction like 2,5 when 2 * 2^5/2 = 5,65 but we got 8,00
        double result = 1;
        if (a == 0) {
            System.out.println("Cannot power ZERO.");
            return 0.0;
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

    //I don't get function of gamma, so I need to change this for int :c
    private static int factorial(int n) {
        if (n < 0) {
            System.out.print("n must be > or = to 0");
            return 0;
        }
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    private static boolean isPrime(double n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
