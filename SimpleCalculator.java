import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        // Step 1: Create a list to store history
        ArrayList<String> history = new ArrayList<>();
        
        // Step 2: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Step 3: Display welcome message
        System.out.println("Welcome to the Simple Calculator!");
        System.out.println("Available operations: + (Add), - (Subtract), * (Multiply), / (Divide)");
        System.out.println("Type 'history' to view previous calculations.");
        System.out.println("Type 'clear' to delete history.");
        System.out.println("Type 'exit' to close the calculator.");

        // Step 4: Start a loop for user interaction
        while (true) {
            System.out.print("\nEnter an operation (+, -, *, /) or a command: ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Step 5: Handle 'exit' command
            if (input.equals("exit")) {
                System.out.println("Thanks for using the calculator. Goodbye!");
                break;
            }

            // Step 6: Handle 'history' command
            else if (input.equals("history")) {
                if (history.isEmpty()) {
                    System.out.println("No history available.");
                } else {
                    System.out.println("Calculation History:");
                    for (String record : history) {
                        System.out.println(record);
                    }
                }
                continue;
            }

            // Step 7: Handle 'clear' command
            else if (input.equals("clear")) {
                history.clear();
                System.out.println("History has been cleared.");
                continue;
            }

            // Step 8: Validate operation
            else if (!(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/"))) {
                System.out.println("Invalid operation! Please enter +, -, *, or /.");
                continue;
            }

            // Step 9: Get numbers from user
            double num1, num2;
            try {
                System.out.print("Enter the first number: ");
                num1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter the second number: ");
                num2 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values.");
                continue;
            }

            // Step 10: Perform calculation
            double result;
            String operation;

            switch (input) {
                case "+":
                    result = num1 + num2;
                    operation = num1 + " + " + num2 + " = " + result;
                    break;
                case "-":
                    result = num1 - num2;
                    operation = num1 + " - " + num2 + " = " + result;
                    break;
                case "*":
                    result = num1 * num2;
                    operation = num1 + " * " + num2 + " = " + result;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        continue;
                    }
                    result = num1 / num2;
                    operation = num1 + " / " + num2 + " = " + result;
                    break;
                default:
                    // Should never reach here
                    continue;
            }

            // Step 11: Show result and save to history
            System.out.println("Result: " + operation);
            history.add(operation);
        }

        // Step 12: Close the scanner
        scanner.close();
    }
}
