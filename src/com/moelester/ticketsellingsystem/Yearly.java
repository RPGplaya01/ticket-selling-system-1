package com.moelester.ticketsellingsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Yearly implements Ticket {

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

    private String idNum;
    private String name;
    private String addr;
    private String gender;

    /**
     * <pre>
     * -+-----------------------------------+---------+---------+
     * | ArrayList of ArrayList of Strings | Ticket1 | ...     |
     * +-----------------------------------+---------+---------+
     * | idNum                             |         |         |
     * | name                              |         |         |
     * | addr                              |         |         |
     * | gender                            |         |         |
     * | ticketId                          |         |         |
     * +-----------------------------------+---------+---------+
     * <pre>
     */
    private ArrayList<ArrayList<String>> YearlyTickets = new ArrayList<ArrayList<String>>();

    public Yearly(String c, String idNum, String name, String addr, String gender) {
        this.type = "Yearly";
        this.category = c;
        determinePrice(type, category);
        setIdNum(idNum);
        setName(name);
        setAddr(addr);
        setGender(gender);

        //Make new ArrayList with params
        ArrayList<String> arrayX = new ArrayList<String>();
        arrayX.add(idNum);
        arrayX.add(name);
        arrayX.add(addr);
        arrayX.add(gender);

        //Adding the ArrayList of Strings (arrayX) to the ArrayList of ArrayList of Strings (YearlyTickets)
        YearlyTickets.add(arrayX);
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
    public String getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getGender() {
        return gender;
    }

    public void setIdNum(String idNum) {
            this.idNum = idNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setGender(String gender) {
            this.gender = gender.toUpperCase();
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

    /**
     * Display personal details
     * @return all personal details from user input
     */
    public String obtainYearlyTicketInfo() {
        return "\nID Number: " + getIdNum() +
                "\nName: " + getName() +
                "\nAddress: " + getAddr() +
                "\nGender: " + getGender();
    }

    /**
     * Writes into txt file
     * @param yearlyTicketInfo
     */
    public void writeYearlyTicketInfo(String yearlyTicketInfo) {
        try {
            File info = new File("yearly_ticket_info.txt");
            if (info.createNewFile()) {
                System.out.println("\nyearly_ticket_info.txt is successfully created.");
            }
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when creating yearly_ticket_info.txt.");
            e.printStackTrace();
        }

        try {
            FileWriter infoWriter = new FileWriter("yearly_ticket_info.txt", true);
            infoWriter.write(yearlyTicketInfo + "\n");
            infoWriter.close();
            System.out.println("\nInformation successfully written to yearly_ticket_info.txt.");
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when writing information to yearly_ticket_info.txt.");
            e.printStackTrace();
        }
    }

    /**
     * The loop for buying yearly ticket
     * @return number of tickets wanted to buy, getting personal info
     */
    public static double[] performYearlyTransaction() {
        double[] total = {0, 0};
        Scanner yearlyScanner = new Scanner(System.in);

        do {

            System.out.println("\nPlease enter the amount of tickets:");
            total[0] = yearlyScanner.nextInt();

            if (total[0] > 3) {
                System.out.println("\nYou can only purchase 3 yearly tickets in one transaction.");
            }

        } while (total[0] > 3);

        for (int i = 1; i <= total[0]; i++) {

            char catChar;
            String catStr = null;

            System.out.println("\nPlease select the ticket category (1-3):");
            System.out.println("1. Senior");
            System.out.println("2. Adult");
            System.out.println("3. Kid/Student");

            catChar = yearlyScanner.next().charAt(0);

            switch (catChar) {
                case '1' -> catStr = "Senior";
                case '2' -> catStr = "Adult";
                case '3' -> catStr = "Kid/Student";
                default -> System.out.println("\nInvalid input! Please input only 1-3.");
            }

        
            String idNum = askIdNum();

            String name = askName();

            String address = askAddress();

            String gender = askGender();

            Yearly yearlyTicket = new Yearly(catStr, idNum, name, address, gender);
            String yearlyTicketInfo = yearlyTicket.obtainYearlyTicketInfo();
            System.out.println(yearlyTicketInfo);
            yearlyTicket.writeYearlyTicketInfo(yearlyTicketInfo);

            total[1] += yearlyTicket.getPrice();

        }
        return total;
    }

    /**
     * Method to get Id Number with validation of only input numbers
     * @return id number
     */
    private static String askIdNum() {
        boolean idValidation = false;
        Scanner idScanner = new Scanner(System.in);
        String idNum;

        do {
            System.out.println("\nPlease enter the ID number e.g. 1234567890:");
            idNum = idScanner.next();

            if (idNum.matches("[0-9]+")) {
                idValidation = true;
            } else {
                System.out.print("\nInvalid input. Please input numbers only.");
            }

        } while (!idValidation);
        return idNum;
    }

    /**
     * Method to get name with validation of only input alphabets
     * @return name
     */
    private static String askName() {
        boolean nameValidation = false;
        Scanner nameScanner = new Scanner(System.in);
        String name;

        do {
            System.out.println("\nPlease enter the name:");
            name = nameScanner.next();

            if (name.matches("[a-z A-Z]+")) {
                nameValidation = true;
            } else {
                System.out.print("\nInvalid input. Please enter again.");
                name = null;
            }

        } while (!nameValidation);
        return name;
    }

    /**
     * Method to get address
     * @return address
     */
    private static String askAddress() {
        Scanner addressScanner = new Scanner(System.in);
        String address;

        System.out.println("\nPlease enter the address:");
        address = addressScanner.next();
        
        return address;
    }

    /**
     * Method to get gender with validation of only F or M
     * @return gender
     */
    private static String askGender() {
        boolean genderValidation = false;
        Scanner genderScanner = new Scanner(System.in);
        String gender;
        
        do{
            System.out.println("\nPlease enter the gender ('f' or 'm'):");
            gender = genderScanner.next();

         if (gender.equals("m") || gender.equals("M") || gender.equals("f") || gender.equals("F")) {
             genderValidation = true;
             gender = gender.toUpperCase();
            } else {
                System.out.print("\nInvalid input. Please input 'f' or 'm' only.");
                gender = null;
            }

        } while (!genderValidation);
        return gender;
    }

}
