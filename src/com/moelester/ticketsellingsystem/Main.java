package com.moelester.ticketsellingsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Sales sales = new Sales();

        Scanner keyboardInput = new Scanner(System.in);

        char repeat = 'N';

        do {

            System.out.println("Please select ticket type:");
            String type = keyboardInput.nextLine();

            System.out.println("Please select ticket category:");
            String category = keyboardInput.nextLine();

            System.out.println("Please input ticket count:");
            int count = keyboardInput.nextInt();

            if (type.equals("Daily")) {
                Ticket ticket = new Daily(category);
                double profit = ticket.getPrice() * count;
                System.out.println("The total is RM" + profit);
                sales.addTicketTransaction(type, count, profit);
            } else if (type.equals("Yearly")) {
                Ticket ticket = new Yearly(category);
                double profit = ticket.getPrice() * count;
                System.out.println("The total is RM" + profit);
                sales.addTicketTransaction(type, count, profit);
            }

            System.out.println("Do you want to perform another transaction? (Y/N)");
            repeat = keyboardInput.next().charAt(0);

            // Consuming the leftover new line using the nextLine() method
            keyboardInput.nextLine();

        } while (repeat == 'Y');

        sales.printReport();

    }
}
