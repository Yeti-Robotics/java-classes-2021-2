import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.println("Enter your operation: ");
        String operation = input.next();
        System.out.println("Enter the second number: ");
        double number2 = input.nextDouble();

        System.out.println(number1 + operation + number2);
        double result = 0;
        switch (operation) {
        case "+":
            result = add(number1, number2);
            break;
        case "-":
            result = subtract(number1, number2);
            break;
        case "*":
            result = multiply(number1, number2);
            break;
        case "/":
            result = divide(number1, number2);
            break;
        default:
            input.close();
            throw new IllegalArgumentException("That's not an operation...");
        }

        System.out.println("The result is " + result);
        input.close();
    }

    private static double add(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
