package com.thoughtworks.Intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String [] args) {
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("\nExercise to execute?");
            System.out.println("1. Print an asterisk");
            System.out.println("2. Draw a horizontal line of asterisks");
            System.out.println("3. Draw a vertical line of asterisks");
            System.out.println("4. Draw a right triangle");
            System.out.println("5. Draw an isosceles triangle");
            System.out.println("6. Draw a diamond");
            System.out.println("7. Draw a diamond with a name in the middle");
            System.out.println("8. FizzBuzz");
            System.out.println("9. Prime factors");
            System.out.println("0. Exit");

            switch (readInput("Exercise number: ")) {
                case "1":
                    printAsterisk();
                    break;
                case "2":
                    drawHorizontalLine();
                    break;
                case "3":
                    drawVerticalLine();
                    break;
                case "4":
                    drawRightTriangle();
                    break;
                case "5":
                    drawIsoscelesTriangle();
                    break;
                case "6":
                    drawDiamond();
                    break;
                case "7":
                    drawDiamondWithName();
                    break;
                case "8":
                    fizzBuzz();
                    break;
                case "9":
                    generate(Integer.parseInt(readInput("Number to prime factorize: ")));
                    break;
                case "0":
                    isAlive = false;
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    public static void printAsterisk() {
        System.out.println("*");
    }

    public static void drawHorizontalLine() {
        int x = 0;
        int lineLength = Integer.parseInt(readInput("How many characters long? "));
        while (x < lineLength) {
            System.out.print("*");
            x++;
        }
        System.out.println();
    }

    public static void drawVerticalLine() {
        int x = 0;
        int lineLength = Integer.parseInt(readInput("How many characters wide? "));
        while (x < lineLength) {
            System.out.println("*");
            x++;
        }
        System.out.println();
    }

    public static void drawRightTriangle() {
        int lineLength = Integer.parseInt(readInput("Triangle is how tall? "));
        for (int i = 0; i < lineLength; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void drawIsoscelesTriangle() {
        int lineLength = Integer.parseInt(readInput("Triangle is how tall? "));
        for (int i = 0; i < lineLength; i++){
            for (int j = i; j < lineLength - 1; j++) {
                System.out.print(" ");
            }
            int lineWidth = (int) (((i + 1) * 2) - .5);
            for (int k = 0; k < lineWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawDiamond() {
        int lineLength = Integer.parseInt(readInput("Diamond is how tall? "));
        for (int i = 0; i < lineLength; i++){
            for (int j = i; j < lineLength - 1; j++) {
                System.out.print(" ");
            }
            int lineWidth = (int) (((i + 1) * 2) - .5);
            for (int k = 0; k < lineWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = lineLength - 1; i > 0; i--){
            for (int j = 0; j < Math.abs(i - lineLength); j++) {
                System.out.print(" ");
            }
            int lineWidth = (int) ((i * 2) - .5);
            for (int k = lineWidth; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawDiamondWithName() {
        int lineLength = Integer.parseInt(readInput("Diamond is how tall? "));
        String name = readInput("Name to display? ");
        for (int i = 0; i < lineLength - 1; i++){
            for (int j = i; j < lineLength - 1; j++) {
                System.out.print(" ");
            }
            int lineWidth = (int) (((i + 1) * 2) - .5);
            for (int k = 0; k < lineWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println(name);
        for (int i = lineLength - 1; i > 0; i--){
            for (int j = 0; j < Math.abs(i - lineLength); j++) {
                System.out.print(" ");
            }
            int lineWidth = (int) ((i * 2) - .5);
            for (int k = lineWidth; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fizzBuzz() {
        int fizzStart = 1;
        int fizzEnd = 100;
        while (fizzStart <= fizzEnd) {
            if (fizzStart % 3 == 0) {
                System.out.print("Fizz");
            }
            if (fizzStart % 5 == 0) {
                System.out.print("Buzz");
            }
            if (fizzStart % 3 != 0 && fizzStart % 5 != 0) {
                System.out.print(fizzStart);
            }
            fizzStart++;
            System.out.println();
        }
        System.out.println();
    }

    public static void generate(int n) {
        if (n == 1) {
            System.out.println("List is empty.");
            return;
        } else if (n < 1) {
            System.out.println("Number must be positive and non-zero");
        }
        List<Integer> primeNums = new ArrayList<>();
        for (int x = 2; x <= n; x++) {
            while (n % x == 0) {
                primeNums.add(x);
                n /= x;
            }
        }
        for (int i = 0; i <= primeNums.size() - 1; i++) {
            System.out.print(primeNums.get(i));
            if (i != primeNums.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static String readInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}
