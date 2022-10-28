import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.OptionalDouble;

/**
 * This class derives all statistics used by the statistics panel
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class Statistics
{

    private static final AirbnbDataCompute data = new AirbnbDataCompute();

    private String[][] boroughPrice = {new String[]{"Kingston upon Thames", "0"},
    new String[]{"Enfield", "0"},
    new String[]{"Barnet", "0"},
    new String[]{"Haringey", "0"},
    new String[]{"Waltham Forest", "0"},
    new String[]{"Harrow", "0"},
    new String[]{"Brent", "0"},
    new String[]{"Camden", "0"},
    new String[]{"Islington", "0"},
    new String[]{"Hackney", "0"},
    new String[]{"Redbridge", "0"},
    new String[]{"Havering", "0"},
    new String[]{"Hillingdon", "0"},
    new String[]{"Ealing", "0"},
    new String[]{"Kensington and Chelsea", "0"},
    new String[]{"Westminster", "0"},
    new String[]{"Tower Hamlets", "0"},
    new String[]{"Newham", "0"},
    new String[]{"Barking and Dagenham", "0"},
    new String[]{"Hounslow", "0"},
    new String[]{"Hammersmith and Fulham", "0"},
    new String[]{"Wandsworth", "0"},
    new String[]{"City of London", "0"},
    new String[]{"Greenwich", "0"},
    new String[]{"Bexley", "0"},
    new String[]{"Richmond upon Thames", "0"},
    new String[]{"Merton", "0"},
    new String[]{"Lambeth", "0"},
    new String[]{"Southwark", "0"},
    new String[]{"Lewisham", "0"},
    new String[]{"Sutton", "0"},
    new String[]{"Croydon", "0"},
    new String[]{"Bromley", "0"}};


    /**
     * get the average number of reviews of the data within the range
     * @return average number of reviews
     */
    public double getAverageNumberOfReviews()
    {
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "All");
        OptionalDouble result = listings.stream()
                                        .mapToInt(AirbnbListing::getNumberOfReviews)
                                        .average();
        //rounds the double up
        if (result.isPresent()) {
            BigDecimal bd = new BigDecimal(Double.toString(result.getAsDouble()));
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        return 0;
    }

    /**
     * get the number of properties of the data within the range
     * @return number of valid properties
     */
    public int getNumberOfProperties()
    {
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "All");
        return listings.size();
    }

    /**
     * return the number of entire home apartments of the data within the range
     * @return size of entire home apartments
     */
    public int numberOfEntirehomeApt(){
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "Entire home/apt");
        return listings.size();
    }

    /**
     * gets the most expensive borough within the range
     * @return the most expensive borough
     */
    public String getMostExpensiveBorough(){
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "All");
        double theMostExpensivePrice = 0.0;
        String theMostExpensiveBorough = "";
        for(AirbnbListing listing: listings){
            
            for(int i = 0; i < 33; i++){
                if (listing.getNeighbourhood().equals(boroughPrice[i][0])){
                boroughPrice[i][1] = Integer.parseInt(boroughPrice[i][1] )+ listing.getPrice()*listing.getMinimumNights() + "";
                }
            }
        }
        for(int i = 0; i < 33; i++){
            double price = Double.parseDouble(boroughPrice[i][1]);
            if(price >= theMostExpensivePrice){
              theMostExpensivePrice = price;
              theMostExpensiveBorough = boroughPrice[i][0];
            }
        }
        return getNumberOfProperties()!=0 ? theMostExpensiveBorough : "None";
    }

    /**
     * gets the cheapest borough within the range
     * @return the cheapest borough
     */
    public String getCheapestBorough(){
        data.getValidProperties();
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "All");
        String theCheapestBorough = "";
        for(AirbnbListing listing: listings){
            for(int i = 0; i < 33; i++){
                if (listing.getNeighbourhood().equals(boroughPrice[i][0])){
                boroughPrice[i][1] = Integer.parseInt(boroughPrice[i][1] )+ listing.getPrice()*listing.getMinimumNights() + "";
            }
        }
        }
        double theCheapestPrice =  Double.parseDouble(boroughPrice[0][1]);
        for(int i = 0; i < 33; i++){
            double price = Double.parseDouble(boroughPrice[i][1]);
            String area = boroughPrice[i][0];
            if((price <= theCheapestPrice) && (data.getnumOfProperties(area)) != 0){
              theCheapestPrice = price;
              theCheapestBorough = boroughPrice[i][0];
            }
        }
        return getNumberOfProperties()!=0 ? theCheapestBorough : "None";
    }

    /**
     * gets the cheapest private room of the data within the price range
     * @return the cheapest private room
     */
    public int getCheapestPrivateRoomPerNight(){
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "Private room");
        OptionalInt result = listings.stream()
                                        .mapToInt(AirbnbListing::getPrice)
                                        .min();
        return result.isPresent() ? result.getAsInt() : 0;
    }

    /**
     * gets the cheapest entire home apartment within the price range
     * @return cheapest entire home apartment
     */
    public int getCheapestEntirehomeAptPerNight(){
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "Entire home/apt");
        OptionalInt result = listings.stream()
                                        .mapToInt(AirbnbListing::getPrice)
                                        .min();
        return result.isPresent() ? result.getAsInt() : 0;
    }

    /**
     * get the most expensive room per night within the price range
     * @return most expensive room per night
     */
    public int getMostExpensiveRoomPerNight(){
        ArrayList<AirbnbListing> listings = data.getMapListing(UserInput.getlowerPrice(), UserInput.getupperPrice(), "All");
        OptionalInt result = listings.stream()
                                        .mapToInt(AirbnbListing::getPrice)
                                        .max();
        return result.isPresent() ? result.getAsInt() : 0;

    }
}


