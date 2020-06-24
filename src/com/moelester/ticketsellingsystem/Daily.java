package com.moelester.ticketsellingsystem;

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
     * @param type "Yearly" or "Daily"
     * @param category "Senior", "Adult" or "Kid/Student"
     */
    public Daily(String t, String c){
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
    public String getType(){
        return type;
    }
        
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
