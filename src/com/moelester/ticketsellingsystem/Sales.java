package com.moelester.ticketsellingsystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class Sales {

    public static String obtainTransactionData(String type, int quantity, double profit) {
        return "\nTransaction Date:\n" +
                LocalDate.now() +
                "\nTicket Type:\n" +
                type +
                "\nTicket Quantity:\n" +
                quantity +
                "\nTotal Price (RM):\n" +
                (int) profit;
    }

    public static void writeTransaction(String transactionData) {
        try {
            File transaction = new File("transactions.txt");
            if (transaction.createNewFile()) {
                System.out.println("\ntransactions.txt is successfully created.");
            }
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when creating transactions.txt.");
            e.printStackTrace();
        }

        try {
            FileWriter transactionWriter = new FileWriter("transactions.txt", true);
            transactionWriter.write(transactionData + "\n");
            transactionWriter.close();
            System.out.println("\nTransaction successfully written to transactions.txt.");
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when writing transaction to transactions.txt.");
            e.printStackTrace();
        }
    }

    private static String askReportDate() {
        boolean isValidDate = false;
        String reportDate;
        do {
            System.out.println("Please input the report date (YYYY-MM-DD):");
            Scanner dateScanner = new Scanner(System.in);
            reportDate = dateScanner.nextLine();

            if (reportDate.matches("(\\d{4}-\\d{2}-\\d{2})")) {
                isValidDate = true;
            } else {
                System.out.println("Invalid input! Please input the date with only integers and dashes (YYYY-MM-DD).");
            }
        } while (!isValidDate);
        return reportDate;
    }

    public static String generateReport() {
        String reportDate = askReportDate();
        try {

            int line = 2;
            int[] ticketQuantity = {0, 0};
            double[] ticketProfit = {0, 0};

            String transactionDate = Files.readAllLines(Paths.get("transactions.txt")).get(line);
            long lineCount = Files.lines(Paths.get("transactions.txt")).count();

            for (line = 2; line <= lineCount; line += 9) {
                if (transactionDate.equals(reportDate)) {

                    String type = Files.readAllLines(Paths.get("transactions.txt")).get(line + 2);

                    if (type.equals("Daily")) {

                        String dailyQuantity = Files.readAllLines(Paths.get("transactions.txt")).get(line + 4);
                        ticketQuantity[0] += Integer.parseInt(dailyQuantity);

                        String dailyProfit = Files.readAllLines(Paths.get("transactions.txt")).get(line + 6);
                        ticketProfit[0] += Double.parseDouble(dailyProfit);

                    } else {

                        String yearlyQuantity = Files.readAllLines(Paths.get("transactions.txt")).get(line + 4);
                        ticketQuantity[1] += Integer.parseInt(yearlyQuantity);

                        String yearlyProfit = Files.readAllLines(Paths.get("transactions.txt")).get(line + 6);
                        ticketProfit[1] += Double.parseDouble(yearlyProfit);

                    }

                }
            }

            return "\nReport Date:" + reportDate +
                    "\nDaily Tickets Sold: " + ticketQuantity[0] +
                    "\nYearly Tickets Sold: " + ticketQuantity[1] +
                    "\nTotal Tickets Sold: " + (ticketQuantity[0] + ticketQuantity[1]) +
                    "\nDaily Ticket Profit: " + ticketProfit[0] +
                    "\nYearly Ticket Profit: " + ticketProfit[1] +
                    "\nTotal Ticket Profit: " + (ticketProfit[0] + ticketProfit[1]);

        } catch (IOException e) {
            System.out.println("\nAn error has occurred when reading transaction in transactions.txt.");
            e.printStackTrace();
            return null;
        }

    }

    public static void writeReport(String reportData) {
        try {
            File report = new File("reports.txt");
            if (report.createNewFile()) {
                System.out.println("\nreports.txt is successfully created.");
            }
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when creating reports.txt.");
            e.printStackTrace();
        }

        try {
            FileWriter reportWriter = new FileWriter("reports.txt", true);
            reportWriter.write(reportData + "\n");
            reportWriter.close();
            System.out.println("\nReport successfully written to reports.txt.");
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when writing report to reports.txt.");
            e.printStackTrace();
        }
    }

}
