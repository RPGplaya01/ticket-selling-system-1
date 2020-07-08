package com.moelester.ticketsellingsystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Sales {

    public static String obtainTransactionData(String type, int quantity, double profit) {
        return "\nTransaction Date:\n" +
                LocalDate.now() +
                "\nTicket Type:\n" +
                type +
                "\nTicket Quantity:\n" +
                quantity +
                "\nTotal Price (RM):\n" +
                (int) profit + "\n";
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
            transactionWriter.write(transactionData);
            transactionWriter.close();
            System.out.println("\nTransaction successfully written to transactions.txt.");
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when writing transaction to transactions.txt.");
            e.printStackTrace();
        }
    }

    public static String generateReport(String reportDate) {
        try {

            int line = 2;
            int[] ticketQuantity = {0, 0};
            double[] ticketProfit = {0, 0};

            String transactionDate = Files.readAllLines(Paths.get("transactions.txt")).get(line);
            long lineCount = Files.lines(Paths.get("transactions.txt")).count();

            for (line = 2 ; line <= lineCount ; line += 9) {
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

}
