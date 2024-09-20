package com.example.project;
import java.util.Scanner;

public class ExtraCredit {

    public static String calculateTip(int people, int percent, double cost, String items) {
        StringBuilder result = new StringBuilder();

        // Ensure rounding to 2 decimal places for monetary values
        double tip = Math.round(cost * (percent / 100.0) * 100.0) / 100.0;
        double totalBill = Math.round((cost + tip) * 100.0) / 100.0;
        double tipPerPerson = Math.round(tip / people * 100.0) / 100.0;
        double costPerPerson = Math.round(cost / people * 100.0) / 100.0;
        double finalCostPerPerson = Math.round(totalBill / people * 100.0) / 100.0;

        result.append("-------------------------------\n");
        result.append("Total bill before tip: $").append(String.format("%.2f", cost)).append("\n");
        result.append("Total percentage: ").append(percent).append("%\n");
        result.append("Total tip: $").append(String.format("%.2f", tip)).append("\n");
        result.append("Total Bill with tip: $").append(String.format("%.2f", totalBill)).append("\n");
        result.append("Per person cost before tip: $").append(String.format("%.2f", costPerPerson)).append("\n");
        result.append("Tip per person: $").append(String.format("%.2f", tipPerPerson)).append("\n");
        result.append("Total cost per person: $").append(String.format("%.2f", finalCostPerPerson)).append("\n");
        result.append("-------------------------------\n");

        // Ensure the item string formatting is correct
        result.append("Items ordered:\n").append(items);  // No extra \n needed at the end

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = 6;
        int percent = 25;
        double cost = 52.27;

        // Capture the menu items using a while loop
        StringBuilder items = new StringBuilder();
        String input;

        while (true) {
            System.out.print("Enter the names of the items ordered (enter '-1' to finish): ");
            input = scanner.nextLine();
            if (input.equals("-1")) {
                break; // Exit the loop when user inputs '-1'
            }
            items.append(input).append("\n");
        }

        System.out.println(calculateTip(people, percent, cost, items.toString()));
    }
}
