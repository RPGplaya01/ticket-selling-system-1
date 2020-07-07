package com.moelester.ticketsellingsystem;

import java.time.LocalDate;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Sales {

    private LocalDate date = LocalDate.now();
    private int[] ticketQuantity = {0, 0};
    private double[] ticketProfit = {0, 0};

    public Sales() {
    }

    // Getters implementation
    public LocalDate getDate() {
        return date;
    }

    public int getTicketQuantity(String type) {
        if (type.equals("Daily")) {
            return ticketQuantity[0];
        } else if (type.equals("Yearly")) {
            return ticketQuantity[1];
        } else {
            System.out.println("Invalid Type");
            return 0;
        }
    }

    public double getTicketProfit(String type) {
        if (type.equals("Daily")) {
            return ticketProfit[0];
        } else if (type.equals("Yearly")) {
            return ticketProfit[1];
        } else {
            System.out.println("Invalid Type");
            return 0;
        }
    }

    public void addTicketTransaction(String type, int quantity, double profit) {
        if (type.equals("Daily")) {
            ticketQuantity[0] += quantity;
            ticketProfit[0] += profit;
        } else if (type.equals("Yearly")) {
            ticketQuantity[1] += quantity;
            ticketProfit[1] += profit;
        } else {
            System.out.println("Invalid Type");
        }
    }

    private int calcTotalTickets() {
        return ticketQuantity[0] + ticketQuantity[1];
    }

    private double calcTotalProfit() {
        return ticketProfit[0] + ticketProfit[1];
    }

    public void printReport() {
        System.out.println("\nReport Date: " + getDate());
        System.out.println("Daily Tickets Sold: " + ticketQuantity[0]);
        System.out.println("Yearly Tickets Sold: " + ticketQuantity[1]);
        System.out.println("Total Tickets Sold: " + calcTotalTickets());
        System.out.println("Daily Tickets Profit Earned: " + ticketProfit[0]);
        System.out.println("Yearly Tickets Profit Earned: " + ticketProfit[1]);
        System.out.println("Total Tickets Profit Earned: " + calcTotalProfit());
    }

    public void writeReport() {
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
            reportWriter.write(
                    "Report Date: " + getDate() +
                            "\nDaily Tickets Sold: " + ticketQuantity[0] +
                            "\nYearly Tickets Sold: " + ticketQuantity[1] +
                            "\nTotal Tickets Sold: " + calcTotalTickets() +
                            "\nDaily Tickets Profit Earned: " + ticketProfit[0] +
                            "\nYearly Tickets Profit Earned: " + ticketProfit[1] +
                            "\nTotal Tickets Profit Earned: " + calcTotalProfit() + "\n\n"
            );
            reportWriter.close();
            System.out.println("\nReport successfully written to reports.txt.");
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when writing report to reports.txt.");
            e.printStackTrace();
        }
    }

}
