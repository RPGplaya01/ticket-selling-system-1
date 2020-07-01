package com.moelester.ticketsellingsystem;

public class Yearly implements Ticket{

    /**
     * <pre>
     * Indicates the type of ticket:
     * ONLY USE "Yearly" or "Daily"
     * Failure to do so results in exceptions in determinePrice()
     * <pre>
     */
    private String type = "undefined";
     /**
     * <pre>
     * Indicates the category of ticket:
     * ONLY USE "Senior", "Adult" or "Kid/Student"
     * Failure to do so results in exceptions in determinePrice()
     * <pre>
     */
    private String category = "null";
     /**
     * <pre>
     * Indicates the price of ticket:
     * It is automatically determined with determinePrice()
     * <pre>
     */
    private double price = 0;
    
     /**
     * Constructor for ticket subtypes
     * @param type "Yearly" or "Daily"
     * @param category "Senior", "Adult" or "Kid/Student"
     */
    public Yearly(String t, String c){
        //TODO implement try catch / if else for input validation
        this.type = t;
        this.category = c;
        determinePrice(t, c);
    }
    
    @Override
    public int reportAmt() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public double reportProfit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Attributes
    private String idNum;
    private String name;
    private String addr;
    private String gender;

    //Getter & Setters
    @Override
    public void setPrice(double p){
        price = p;
    }
    
    @Override
    public double getPrice(){
        return price;
    }
    
    @Override
    public void setCategory(String c){
        category = c;
    }
    
    @Override
    public String getCategory(){
        return category;
    }
    
    @Override
    public void setType(String t){
        type = t;
    }
    
    @Override
    public String getType() {
        return type;
    }

    public void setIdNum(String idNum) {

        if (idNum.matches("[0-9]+")) {
            this.idNum = idNum;
        } else {
            System.out.print("Invalid input. Please input numbers only.");
            this.idNum = "null";
        }
    }

    public String getIdNum() {
        return idNum;
    }
    
    public void setName(String name) {

        if (name.matches("[a-zA-Z]+")) {
            this.name = name;
        } else {
            System.out.print("Invalid input. Please enter again.");
            this.name = "null";
        }
    }

    public String getName() {
        return name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    public String getAddr() {
        return addr;
    }

    public void setGender(String gender) {

        if (gender == "m" || gender =="M" || gender =="f" || gender =="F") {
            this.gender = gender;
        } else {
            System.out.print("Invalid input. Please enter 'F' or 'M' only.");
            this.gender = "null";
        }
    }

    public String getGender() {
        return gender;
    }

    //Switch case for price table 
    private void determinePrice(String t, String c){
        switch(t){
            case "Daily":
                switch(c){
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
                switch(c){
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
    
}
