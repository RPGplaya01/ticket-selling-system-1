package com.moelester.ticketsellingsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Sales sales = new Sales();

        Scanner keyboardInput = new Scanner(System.in);

        char repeat = 'N';

        System.out.println("                                     /$$$$$$$$                           /$$   /$$                                                                                                    \n" +
                "                                    |_____ $$                           | $$$ | $$                                                                                                    \n" +
                "                                         /$$/   /$$$$$$   /$$$$$$       | $$$$| $$  /$$$$$$   /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$                                                    \n" +
                "                                        /$$/   /$$__  $$ /$$__  $$      | $$ $$ $$ /$$__  $$ /$$__  $$ |____  $$ /$$__  $$|____  $$                                                   \n" +
                "                                       /$$/   | $$  \\ $$| $$  \\ $$      | $$  $$$$| $$$$$$$$| $$  \\ $$  /$$$$$$$| $$  \\__/ /$$$$$$$                                                   \n" +
                "                                      /$$/    | $$  | $$| $$  | $$      | $$\\  $$$| $$_____/| $$  | $$ /$$__  $$| $$      /$$__  $$                                                   \n" +
                "                                     /$$$$$$$$|  $$$$$$/|  $$$$$$/      | $$ \\  $$|  $$$$$$$|  $$$$$$$|  $$$$$$$| $$     |  $$$$$$$                                                   \n" +
                "                                    |________/ \\______/  \\______/       |__/  \\__/ \\_______/ \\____  $$ \\_______/|__/      \\_______/                                                   \n" +
                "                                                                                             /$$  \\ $$                                                                                \n" +
                "                                                                                            |  $$$$$$/                                                                                \n" +
                "                                                                                             \\______/                                                                                 \n" +
                " /$$$$$$$$ /$$           /$$                   /$$            /$$$$$$            /$$ /$$ /$$                            /$$$$$$                        /$$                            \n" +
                "|__  $$__/|__/          | $$                  | $$           /$$__  $$          | $$| $$|__/                           /$$__  $$                      | $$                            \n" +
                "   | $$    /$$  /$$$$$$$| $$   /$$  /$$$$$$  /$$$$$$        | $$  \\__/  /$$$$$$ | $$| $$ /$$ /$$$$$$$   /$$$$$$       | $$  \\__/ /$$   /$$  /$$$$$$$ /$$$$$$    /$$$$$$  /$$$$$$/$$$$ \n" +
                "   | $$   | $$ /$$_____/| $$  /$$/ /$$__  $$|_  $$_/        |  $$$$$$  /$$__  $$| $$| $$| $$| $$__  $$ /$$__  $$      |  $$$$$$ | $$  | $$ /$$_____/|_  $$_/   /$$__  $$| $$_  $$_  $$\n" +
                "   | $$   | $$| $$      | $$$$$$/ | $$$$$$$$  | $$           \\____  $$| $$$$$$$$| $$| $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  | $$|  $$$$$$   | $$    | $$$$$$$$| $$ \\ $$ \\ $$\n" +
                "   | $$   | $$| $$      | $$_  $$ | $$_____/  | $$ /$$       /$$  \\ $$| $$_____/| $$| $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$ \\____  $$  | $$ /$$| $$_____/| $$ | $$ | $$\n" +
                "   | $$   | $$|  $$$$$$$| $$ \\  $$|  $$$$$$$  |  $$$$/      |  $$$$$$/|  $$$$$$$| $$| $$| $$| $$  | $$|  $$$$$$$      |  $$$$$$/|  $$$$$$$ /$$$$$$$/  |  $$$$/|  $$$$$$$| $$ | $$ | $$\n" +
                "   |__/   |__/ \\_______/|__/  \\__/ \\_______/   \\___/         \\______/  \\_______/|__/|__/|__/|__/  |__/ \\____  $$       \\______/  \\____  $$|_______/    \\___/   \\_______/|__/ |__/ |__/\n" +
                "                                                                                                       /$$  \\ $$                 /$$  | $$                                            \n" +
                "                                                                                                      |  $$$$$$/                |  $$$$$$/                                            \n" +
                "                                                                                                       \\______/                  \\______/                                             ");

        System.out.println("\nWelcome to Zoo Negara Ticket Selling System!");

        System.out.println("     +--------------------+----------+-----------+\n" +
                "     | Category           | Daily    | Yearly    |\n" +
                "     +--------------------+----------+-----------+\n" +
                "     | Senior             | 30       | 100       |\n" +
                "     +--------------------+----------+-----------+\n" +
                "     | Adult              | 50       | 120       |\n" +
                "     +--------------------+----------+-----------+\n" +
                "     | Kid/Student        | 20       | 80        |\n" +
                "     +--------------------+----------+-----------+");

        do {

        char typeChar;
        String typeStr = null;

        do {

            System.out.println("\nPlease select the ticket type (1-2):");
            System.out.println("1. Daily");
            System.out.println("2. Yearly");
            System.out.println("0. Exit");

            typeChar = keyboardInput.next().charAt(0);

            switch (typeChar) {
                case '1' -> typeStr = "Daily";
                case '2' -> typeStr = "Yearly";
                case '0' -> System.exit(0);
                default -> System.out.println("\nInvalid input! Please input only 1-2.");
            }

        } while (typeChar != '1' && typeChar != '2');

        System.out.println("\nYou have selected " + typeStr + " ticket type.");

        int[] catCount = {0, 0, 0};

        System.out.println("\nPlease enter the amount of tickets for each category:");
        System.out.println("Senior: ");
        catCount[0] = keyboardInput.nextInt();

        System.out.println("Adult: ");
        catCount[1] = keyboardInput.nextInt();

        System.out.println("Kid/Student: ");
        catCount[2] = keyboardInput.nextInt();

        if (typeStr.equals("Daily")) {

            double totalProfit = 0;
            Daily seniorTicket = new Daily("Senior");
            totalProfit += seniorTicket.getPrice() * catCount[0];
            Daily adultTicket = new Daily("Adult");
            totalProfit += adultTicket.getPrice() * catCount[1];
            Daily kidTicket = new Daily("Kid/Student");
            totalProfit += kidTicket.getPrice() * catCount[2];

            int totalCount = catCount[0] + catCount[1] + catCount[2];
            System.out.println("\nTicket Type: " + typeStr);
            System.out.println("Ticket Quantity: " + totalCount);
            System.out.println("Total Price: RM" + totalProfit);

            sales.addTicketTransaction(typeStr, totalCount, totalProfit);

        } else if (typeStr.equals("Yearly")) {
//            Yearly yearlyTicket = new Yearly(category, "011111101111", "playa", "valorant", "m");
//            Yearly yearlyTicket2 = new Yearly(category, "011111102222", "playo", "csgo", "f");
//            yearlyTicket.printInfo();
//            yearlyTicket.writeInfo();
//            yearlyTicket2.printInfo();
//            yearlyTicket2.writeInfo();
//            double profit = yearlyTicket.getPrice() * count;
//            System.out.println("The total is RM" + profit);
//            sales.addTicketTransaction(type, count, profit);
            System.out.println("Yearly Test");
        }

            System.out.println("Do you want to perform another transaction? (Y/N)");
            repeat = keyboardInput.next().charAt(0);

            // Consuming the leftover new line using the nextLine() method
            keyboardInput.nextLine();

        } while (repeat == 'Y');

        sales.printReport();
        sales.writeReport();

    }
}
