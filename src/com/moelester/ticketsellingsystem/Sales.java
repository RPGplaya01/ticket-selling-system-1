package com.moelester.ticketsellingsystem;

import java.time.LocalDate;

public class Sales {

    private LocalDate date = LocalDate.now();
    private int[] ticketCount = {0, 0};
    private double[] ticketProfit = {0, 0};

    public Sales() {
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTicketCount(String type) {
        if (type.equals("Daily")) {
            return ticketCount[0];
        } else if (type.equals("Yearly")) {
            return ticketCount[1];
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

    public void addTicketTransaction(String type, int count, double profit) {
        if (type.equals("Daily")) {
            ticketCount[0] += count;
            ticketProfit[0] += profit;
        } else if (type.equals("Yearly")) {
            ticketCount[1] += count;
            ticketProfit[1] += profit;
        } else {
            System.out.println("Invalid Type");
        }
    }

    private int calcTotalTickets() {
        return ticketCount[0] + ticketCount[1];
    }

    private double calcTotalProfit() {
        return ticketProfit[0] + ticketProfit[1];
    }

    public void printReport() {
        System.out.println("\nReport Date: " + getDate());
        System.out.println("Daily Tickets Sold: " + ticketCount[0]);
        System.out.println("Yearly Tickets Sold: " + ticketCount[1]);
        System.out.println("Total Tickets Sold: " + calcTotalTickets());
        System.out.println("Daily Tickets Profit Earned: " + ticketProfit[0]);
        System.out.println("Yearly Tickets Profit Earned: " + ticketProfit[1]);
        System.out.println("Total Tickets Profit Earned: " + calcTotalProfit());
    }

}
