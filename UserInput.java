
/**
 * Contains all the user inputed data to use for processing.
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class UserInput
{
    // instance variables - replace the example below with your own
    private static int lowerPrice;
    private static int upperPrice;
    private static String area;
    private static AirbnbListing userChoice;

    /**
     * set area name from when map button is clicked
     */
    public static void setAreaName(String a){
        area = a;
    }
    /**
     * set lower price from combobox selection
     */
    public static void setlowerPrice(int x){
        lowerPrice = x;
    }
    /**
     * set upper price from combobox selection
     */
    public static void setupperPrice(int x){
        upperPrice = x;
    }
    /**
     * get lower price from combobox selection
     */
    public static int getlowerPrice(){
        return lowerPrice;
    }
    /**
     * get lower price from combobox selection
     */
    public static int getupperPrice(){
        return upperPrice;
    }
    /**
     * get area name from when map button is clicked
     */
    public static String getAreaName(){
        return area;
    }

    /**
     * set user choice when tableview is clicked once or twice
     */
    public static void setUserChoice(AirbnbListing a){
        userChoice = a;
    }
    /**
     * get user choice when tableview is clicked once or twice
     */
    public static AirbnbListing getUserChoice() {
        return userChoice;
    }

    /**
     * reset all variables when reset menu item is called
     */
    public static void reset(){
        lowerPrice = 0;
        upperPrice = 0;
        area = null;
        userChoice = null;
    }
}
