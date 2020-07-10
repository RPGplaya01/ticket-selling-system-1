package com.moelester.ticketsellingsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboardInput = new Scanner(System.in);

        char repeat;

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

        System.out.println("Ticket Prices");
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

            do {

                System.out.println("\nPlease select the function (1-3):");
                System.out.println("1. Perform Daily Ticket Transaction");
                System.out.println("2. Perform Yearly Ticket Transaction");
                System.out.println("3. Generate Report");
                System.out.println("0. Exit");

                typeChar = keyboardInput.next().charAt(0);

                switch (typeChar) {
                    case '1' -> {
                        System.out.println("\nYou have selected perform daily ticket transaction.");
                        double[] dailyTotal = Daily.performDailyTransaction();
                        String dailyTransactionData = Sales.obtainTransactionData("Daily", (int) dailyTotal[0], dailyTotal[1]);
                        System.out.println(dailyTransactionData);
                        Sales.writeTransaction(dailyTransactionData);
                    }
                    case '2' -> {
                        System.out.println("\nYou have selected perform yearly ticket transaction.");
                        double[] yearlyTotal = Yearly.performYearlyTransaction();
                        String yearlyTransactionData = Sales.obtainTransactionData("Yearly", (int) yearlyTotal[0], yearlyTotal[1]);
                        System.out.println(yearlyTransactionData);
                        Sales.writeTransaction(yearlyTransactionData);
                    }
                    case '3' -> {
                        System.out.println("\nYou have selected generate report.");
                        String reportData = Sales.generateReport();
                        System.out.println(reportData);
                        Sales.writeReport(reportData);
                    }
                    case '0' -> System.exit(0);
                    default -> System.out.println("\nInvalid input! Please input only 0-3.");
                }

            } while (typeChar != '1' && typeChar != '2' && typeChar != '3');

        } while (true);

    }
}