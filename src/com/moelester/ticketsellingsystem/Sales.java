package com.moelester.ticketsellingsystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class Sales {

    /**
     * Obtains the transaction data including type, quantity and profit
     *
     * @param type     The type of ticket sold which is either daily or yearly
     * @param quantity The number of tickets sold
     * @param profit   The amount of profit earned in RM
     * @return A String value which contains the transaction data with labels
     */
    public static String obtainTransactionData(String type, int quantity, double profit) {
        return "\nTransaction Date:\n" +
                LocalDate.now() + // Obtains the current date of the system
                "\nTicket Type:\n" +
                type +
                "\nTicket Quantity:\n" +
                quantity +
                "\nTotal Price (RM):\n" +
                (int) profit; // Convert double to integer to remove decimal places which are always zeroes (.0)
    }

    /**
     * Writes the transaction data obtained from the obtainTransactionData() method into a text file named transactions.txt
     *
     * @param transactionData The String which contains transaction data returned from the obtainTransactionData() method
     */
    public static void writeTransaction(String transactionData) {
        //  Creates transactions.txt if the file does not exist in the directory
        try {
            File transaction = new File("transactions.txt");
            if (transaction.createNewFile()) {
                System.out.println("\ntransactions.txt is successfully created.");
            }
        }
        // Catch input output exception if it occurs
        catch (IOException e) {
            System.out.println("\nAn error has occurred when creating transactions.txt.");
            e.printStackTrace();
        }

        // Writes the transaction data to transactions.txt
        try {
            FileWriter transactionWriter = new FileWriter("transactions.txt", true);
            transactionWriter.write(transactionData + "\n");
            transactionWriter.close();
            System.out.println("\nTransaction data successfully written to transactions.txt.");
        }
        // Catch input output exception if it occurs
        catch (IOException e) {
            System.out.println("\nAn error has occurred when writing transaction data to transactions.txt.");
            e.printStackTrace();
        }
    }

    /**
     * Asks the user to input the date required for the generation of the report
     *
     * @return A String value which contains the date of the the report (YYYY-MM-DD)
     */
    private static String askReportDate() {
        boolean isValidDate = false; // Whether the date provided is valid or not
        String reportDate;
        do {
            System.out.println("Please input the report date (YYYY-MM-DD):");
            Scanner dateScanner = new Scanner(System.in);
            reportDate = dateScanner.nextLine();

            // If the report date matches the YYYY-MM-DD format, it is valid
            if (reportDate.matches("(\\d{4}-\\d{2}-\\d{2})")) {
                isValidDate = true;
            }
            // If the report date does not match the YYYY-MM-DD format, it is not valid
            else {
                System.out.println("Invalid input! Please input the date with only integers and dashes (YYYY-MM-DD).");
            }
        } while (!isValidDate); // Loops the input process until the report date is valid
        return reportDate;
    }

    /**
     * Generates the report data from transactions.txt based on the report date obtained from the askReportDate() method
     *
     * @return A String value which contains the report data with labels including date, total quantity and total profit
     */
    public static String generateReport() {
        // Obtains the report date from the askReportDate() method
        String reportDate = askReportDate();
        try {

            int line = 2; // Initialises with line 3 (index starts at 0) which contains the first transaction date

            int[] ticketQuantity = {0, 0};
            // The first element - ticketQuantity[0] stores the quantity for daily tickets
            // The second element - ticketQuantity[1] stores the quantity for yearly tickets

            double[] ticketProfit = {0, 0};
            // The first element - ticketProfit[0] stores the profit for daily tickets
            // The second element - ticketProfit[1] stores the profit for yearly tickets

            // Obtains the first transaction date from line 3 of transactions.txt
            String transactionDate = Files.readAllLines(Paths.get("transactions.txt")).get(line);
            // Counts the total number of lines in transactions.txt
            long lineCount = Files.lines(Paths.get("transactions.txt")).count();

            // Iterates through transactions.txt to find transaction dates that matches the report date
            for (line = 2; line <= lineCount; line += 9) {
                // If the transaction date matches the report date
                if (transactionDate.equals(reportDate)) {

                    // Obtains the transaction ticket type which is located 2 lines after the transaction date
                    String type = Files.readAllLines(Paths.get("transactions.txt")).get(line + 2);

                    // If the transaction ticket type is daily
                    if (type.equals("Daily")) {

                        // Obtains the transaction ticket quantity which is located 4 lines after the transaction date
                        String dailyQuantity = Files.readAllLines(Paths.get("transactions.txt")).get(line + 4);
                        // Parses the string as an integer and adds the value to the daily ticket quantity
                        ticketQuantity[0] += Integer.parseInt(dailyQuantity);

                        // Obtains the transaction ticket profit which is located 6 lines after the transaction date
                        String dailyProfit = Files.readAllLines(Paths.get("transactions.txt")).get(line + 6);
                        // Parses the string as a double and adds the value to the daily ticket profit
                        ticketProfit[0] += Double.parseDouble(dailyProfit);

                    }
                    // If the transaction ticket type is yearly
                    else {

                        // Obtains the transaction ticket quantity which is located 4 lines after the transaction date
                        String yearlyQuantity = Files.readAllLines(Paths.get("transactions.txt")).get(line + 4);
                        // Parses the string as an integer and adds the value to the yearly ticket quantity
                        ticketQuantity[1] += Integer.parseInt(yearlyQuantity);

                        // Obtains the transaction ticket profit which is located 6 lines after the transaction date
                        String yearlyProfit = Files.readAllLines(Paths.get("transactions.txt")).get(line + 6);
                        // Parses the string as a double and adds the value to the yearly ticket profit
                        ticketProfit[1] += Double.parseDouble(yearlyProfit);

                    }

                }
            }

            // Returns the report data with labels generated from all transaction data with matching dates from transactions.txt
            return "\nReport Date:" + reportDate +
                    "\nDaily Tickets Sold: " + ticketQuantity[0] +
                    "\nYearly Tickets Sold: " + ticketQuantity[1] +
                    "\nTotal Tickets Sold: " + (ticketQuantity[0] + ticketQuantity[1]) +
                    "\nDaily Ticket Profit: " + ticketProfit[0] +
                    "\nYearly Ticket Profit: " + ticketProfit[1] +
                    "\nTotal Ticket Profit: " + (ticketProfit[0] + ticketProfit[1]);

        }
        // Catch input output exception if it occurs
        catch (IOException e) {
            System.out.println("\nAn error has occurred when reading transaction in transactions.txt.");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Writes the report data obtained from the generateReport() method into a text file named reports.txt
     *
     * @param reportData The String which contains report data returned from the generateReport() method
     */
    public static void writeReport(String reportData) {
        //  Creates reports.txt if the file does not exist in the directory
        try {
            File report = new File("reports.txt");
            if (report.createNewFile()) {
                System.out.println("\nreports.txt is successfully created.");
            }
        }
        // Catch input output exception if it occurs
        catch (IOException e) {
            System.out.println("\nAn error has occurred when creating reports.txt.");
            e.printStackTrace();
        }

        // Writes the report data to reports.txt
        try {
            FileWriter reportWriter = new FileWriter("reports.txt", true);
            reportWriter.write(reportData + "\n");
            reportWriter.close();
            System.out.println("\nReport data successfully written to reports.txt.");
        }
        // Catch input output exception if it occurs
        catch (IOException e) {
            System.out.println("\nAn error has occurred when writing report data to reports.txt.");
            e.printStackTrace();
        }
    }

}
