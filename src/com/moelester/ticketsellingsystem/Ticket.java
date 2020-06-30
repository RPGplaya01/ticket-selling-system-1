package com.moelester.ticketsellingsystem;

public interface Ticket {
    /**
     * Price list is a 2D array that stores the prices in a single variable,
     * the price variable will be determined by the constructor
     * <pre>
     * +--------------------+----------+-----------+
     * | Array[row][column] | Daily[0] | Yearly[1] |
     * +--------------------+----------+-----------+
     * | Senior[0]          | 30       | 100       |
     * +--------------------+----------+-----------+
     * | Adult[1]           | 50       | 120       |
     * +--------------------+----------+-----------+
     * | Kid/Student[2]     | 20       | 80        |
     * +--------------------+----------+-----------+
     * <pre>
     */
    double[][] PRICE_LIST = {
            {30, 100},
            {50, 120},
            {20, 80}};


    public int reportAmt();

    public double reportProfit();

    //Getters and Setters implementation
    public void setPrice(double p);

    public double getPrice();

    public void setCategory(String c);

    public String getCategory();

    public void setType(String t);

    public String getType();

}

