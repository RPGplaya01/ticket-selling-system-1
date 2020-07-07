package com.moelester.ticketsellingsystem;

import java.time.LocalDate;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Sales {

    public static String obtainTransactionData(String type, int quantity, double profit) {
        return "\nTransaction Date: " + LocalDate.now() +
                "\nTicket Type: " + type +
                "\nTicket Quantity: " + quantity +
                "\nTotal Price: RM" + profit;
    }

    public static void writeTransaction(String transactionData) {
        try {
            File transaction = new File("transactions.txt");
            if (transaction.createNewFile()) {
                System.out.println("\ntransactions.txt is successfully created.");
            }
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when creating transactions.txt.");
            e.printStackTrace();
        }

        try {
            FileWriter transactionWriter = new FileWriter("transactions.txt", true);
            transactionWriter.write(transactionData);
            transactionWriter.close();
            System.out.println("\nTransaction successfully written to transactions.txt.");
        } catch (IOException e) {
            System.out.println("\nAn error has occurred when writing transaction to transactions.txt.");
            e.printStackTrace();
        }
    }

}
