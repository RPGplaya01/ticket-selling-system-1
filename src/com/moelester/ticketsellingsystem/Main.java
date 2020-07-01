package com.moelester.ticketsellingsystem;

public class Main {
    public static void main(String[] args) {
        Ticket myTicket1 = new Yearly("Yearly","Senior");
        Ticket myTicket2 = new Daily("Daily", "Kid/Student");

        System.out.println("Instantiated ticket 1:");
        System.out.println("Ticket type: " + myTicket1.getType());
        System.out.println("Ticket category: " + myTicket1.getCategory());
        System.out.println("Ticket price: " + myTicket1.getPrice());

        System.out.println("\n\nInstantiated ticket 2:");
        System.out.println("Ticket type: " + myTicket2.getType());
        System.out.println("Ticket category: " + myTicket2.getCategory());
        System.out.println("Ticket price: " + myTicket2.getPrice());
    }
}
