package com.moelester.ticketsellingsystem;

import java.util.Scanner;

public class Daily implements Ticket {

    /**
     * <pre>
     * Indicates the type of ticket:
     * ONLY USE "Yearly" or "Daily"
     * Failure to do so results in exceptions in determinePrice()
     * <pre>
     */
    private String type = null;
    /**
     * <pre>
     * Indicates the category of ticket:
     * ONLY USE "Senior", "Adult" or "Kid/Student"
     * Failure to do so results in exceptions in determinePrice()
     * <pre>
     */
    private String category = null;
    /**
     * <pre>
     * Indicates the price of ticket:
     * It is automatically determined with determinePrice()
     * <pre>
     */
    private double price = 0;

    /**
     * Constructor for ticket subtypes
     *
     * @param c "Senior", "Adult" or "Kid/Student"
     */

    public Daily(String c) {
        determinePrice(type, category);
    }

    // Override getters and setters from Ticket interface
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }

    @Override
    public void setCategory(String c) {
        category = c;
    }

    @Override
    public void setType(String t) {
        type = t;
    }

    /**
     * Switch case for price table
     * This method determines/assigns the price of each ticket category for each ticket type
     * @param t Represents the ticket type (Daily/Yearly)
     * @param c Represents the ticket category (Senior, Adult, Kid/Student)
     */
    private void determinePrice(String t, String c) {
        switch (t) {
            case "Daily":
                switch (c) {
                    case "Senior":
                        setPrice(PRICE_LIST[0][0]);
                        break;
                    case "Adult":
                        setPrice(PRICE_LIST[1][0]);
                        break;
                    case "Kid/Student":
                        setPrice(PRICE_LIST[2][0]);
                        break;
                    default:
                        System.out.println("Invalid category entered.");
                }
                break;

            case "Yearly":
                switch (c) {
                    case "Senior":
                        setPrice(PRICE_LIST[0][1]);
                        break;
                    case "Adult":
                        setPrice(PRICE_LIST[1][1]);
                        break;
                    case "Kid/Student":
                        setPrice(PRICE_LIST[2][1]);
                        break;
                    default:
                        System.out.println("Invalid category entered.");
                }
                break;

            default:
                System.out.println("Invalid type entered.");
                break;
        }
    }

    /**
     * If perform daily transaction is selected, integer input for each category of tickets are stored in an array(catQuantity).
     *
     * @return Total quantity of tickets and total profit from those tickets are returned
     */
    public static double[] performDailyTransaction() {
        int[] catQuantity = {0, 0, 0};

        Scanner dailyScanner = new Scanner(System.in); // Scanner is used to obtain user input

        System.out.println("\nPlease enter the amount of tickets for each category:");
        System.out.println("Senior: ");
        catQuantity[0] = dailyScanner.nextInt(); // User inputs amount of ticket for Senior category

        System.out.println("Adult: ");
        catQuantity[1] = dailyScanner.nextInt(); // User inputs amount of ticket for Adult category

        System.out.println("Kid/Student: ");
        catQuantity[2] = dailyScanner.nextInt(); // User inputs amount of ticket for Kid/Student category

        double[] total = {0, 0}; // An array with double data type is used to store total tickets sold and total profit earned

        total[0] = catQuantity[0] + catQuantity[1] + catQuantity[2]; // Adding up quantity of each ticket category into total.

        Daily seniorTicket = new Daily("Senior");
        total[1] += seniorTicket.getPrice() * catQuantity[0]; // Multiplying quantity of Senior category with price of Senior ticket and incrementing the value in total[1].
        Daily adultTicket = new Daily("Adult");
        total[1] += adultTicket.getPrice() * catQuantity[1]; // Multiplying quantity of Adult category with price of Adult ticket and incrementing the value in total[1].
        Daily kidTicket = new Daily("Kid/Student");
        total[1] += kidTicket.getPrice() * catQuantity[2]; // Multiplying quantity of Kid/Student category with price of Kid/Student ticket and incrementing the value in total[1].

        return total;
    }

}
