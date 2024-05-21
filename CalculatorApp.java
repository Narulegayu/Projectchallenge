package org.sample;

import java.util.Scanner;

public class CalculatorApp {
    private static final String PREDEFINED_PASSWORD = "JAVA";
    private static final int MAX_ATTEMPTS = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (authenticateUser()) {
            showMenu();
        } else {
            System.out.println("Too many failed attempts. Exiting program.");
        }
    }

    private static boolean authenticateUser() {
        for (int i = 1; i <= MAX_ATTEMPTS; i++) {
            System.out.print("Enter password: ");
            String inputPassword = scanner.nextLine();
            if (inputPassword.equals(PREDEFINED_PASSWORD)) {
                return true;
            } else {
                System.out.println("Incorrect password. Attempts remaining: " + (MAX_ATTEMPTS - i));
            }
        }
        return false;
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Factorial Calculation");
            System.out.println("2. Fibonacci Sequence");
            System.out.println("3. Prime Number Check");
            System.out.println("4. Sum of Digits");
            System.out.println("5. Reverse Number");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 6) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            System.out.print("Enter a number: ");
            int num = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (num >= 0) {
                        System.out.println("Factorial: " + factorial(num));
                    } else {
                        System.out.println("Error: Enter a non-negative integer.");
                    }
                    break;
                case 2:
                    if (num >= 0) {
                        System.out.println("Fibonacci: " + fibonacci(num));
                    } else {
                        System.out.println("Error: Enter a non-negative integer.");
                    }
                    break;
                case 3:
                    if (num > 0) {
                        System.out.println("Prime Check: " + (isPrime(num) ? "Prime" : "Not Prime"));
                    } else {
                        System.out.println("Error: Enter a positive integer.");
                    }
                    break;
                case 4:
                    if (num > 0) {
                        System.out.println("Sum of Digits: " + sumOfDigits(num));
                    } else {
                        System.out.println("Error: Enter a positive integer.");
                    }
                    break;
                case 5:
                    if (num > 0) {
                        System.out.println("Reversed Number: " + reverseNumber(num));
                    } else {
                        System.out.println("Error: Enter a positive integer.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            // Clear the buffer
            scanner.nextLine();
        }
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    private static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }
}

	
	

	