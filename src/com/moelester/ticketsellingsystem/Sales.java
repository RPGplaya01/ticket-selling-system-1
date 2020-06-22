package com.moelester.ticketsellingsystem;

import java.time.LocalDate;

public class Sales {

    private LocalDate date = LocalDate.now();
    private int[] ticketCount = {0, 0};
    private double[] ticketProfit = {0, 0};

    public Sales() {}

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

}
