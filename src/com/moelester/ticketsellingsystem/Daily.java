package com.moelester.ticketsellingsystem;

import java.time.LocalDate;
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

    private int noOfTickets;
    private LocalDate dayPurchased;

    public Daily(String c) {
        this.type = "Daily";
        this.category = c;
        determinePrice(type, category);
    }

    public Daily() {
        noOfTickets = 0;
        dayPurchased = null;
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

    // Getters and setters implementation
    public int getNoOfTickets() {
        return noOfTickets;
    }

    public LocalDate getDayPurchased() {
        return dayPurchased;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public void setDayPurchased(LocalDate dayPurchased) {
        this.dayPurchased = dayPurchased;
    }

    public void dailyTicket(int noOfTickets, LocalDate dayPurchased) {
        this.noOfTickets = noOfTickets;
        this.dayPurchased = dayPurchased;
    }

    // Switch case for price table
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

    public static double[] performDailyTransaction() {
        int[] catQuantity = {0, 0, 0};

        Scanner dailyScanner = new Scanner(System.in);

        System.out.println("\nPlease enter the amount of tickets for each category:");
        System.out.println("Senior: ");
        catQuantity[0] = dailyScanner.nextInt();

        System.out.println("Adult: ");
        catQuantity[1] = dailyScanner.nextInt();

        System.out.println("Kid/Student: ");
        catQuantity[2] = dailyScanner.nextInt();

        double[] total = {0, 0};

        total[0] = catQuantity[0] + catQuantity[1] + catQuantity[2];

        Daily seniorTicket = new Daily("Senior");
        total[1] += seniorTicket.getPrice() * catQuantity[0];
        Daily adultTicket = new Daily("Adult");
        total[1] += adultTicket.getPrice() * catQuantity[1];
        Daily kidTicket = new Daily("Kid/Student");
        total[1] += kidTicket.getPrice() * catQuantity[2];

        return total;
    }

}
