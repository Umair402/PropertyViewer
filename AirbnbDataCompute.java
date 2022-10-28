import java.util.ArrayList;

/**
 * This class will compute and manipulate the Airbnb properties list for necessary data
 * required for the map panel and statistics panel
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class AirbnbDataCompute {
    // instance variables - replace the example below with your own
    private ArrayList<AirbnbListing> validProperties;

    //static final so we do not have to load a new properties arraylist
    //everytime we access this class, only once on startup.
    private static AirbnbDataLoader loader = new AirbnbDataLoader();
    private static ArrayList<AirbnbListing> properties = loader.load();

    /**
     * Constructor for objects of class AirbnbDataCompute
     */
    public AirbnbDataCompute() {

    }

    /**
     * get valid properties that is validated if such listings fall inbetween the price range,
     * stores in validProperties list
     */
    public void getValidProperties() {
        validProperties = new ArrayList<>();
        for (AirbnbListing a : properties) {
            //removed conditional to check if availabilty365 != 0 because it conflicted with stats panel
            if ((a.getPrice() >= UserInput.getlowerPrice()) && (a.getPrice() <= UserInput.getupperPrice())) {
                validProperties.add(a);
            }
        }
    }

    /**
     * Gets the valid properties in each area
     * @param area, name of area to get valid properties
     * @return ArrayList<AirbnbListing> of valid properties
     */
    public ArrayList<AirbnbListing> getAreaProperties(String area){
        ArrayList<AirbnbListing> newList = new ArrayList<>();
        for (AirbnbListing a: validProperties){
            if (a.getNeighbourhood().equals(area)){
                newList.add(a);
            }
        }
        return newList;
    }

    /**
     * will get the size of the valid properties in param area
     * @param area, name of area to get size of valid properties
     * @return int number of valid properties in area
     */
    public int getnumOfProperties(String area){
        return this.getAreaProperties(area).size();
    }


    /**
     * Returns the list of all the properties in the neighbourhood after checking for the given conditions
     * @param neighbourhood the neighbourhood which the user has selectied
     * @param minPrice the minimum price of the property
     * @param maxPrice the maximum price of the property
     * @return the list of all the properties satisfying the given conditions
     */
    public ArrayList<AirbnbListing> getNeighbourhoodListing(String neighbourhood, int minPrice, int maxPrice){
        ArrayList<AirbnbListing> list = new ArrayList<>();
        for(AirbnbListing listing: properties) {
            if (listing.getNeighbourhood().equals(neighbourhood) && 
            listing.getPrice() >= minPrice && (listing.getPrice() < maxPrice || maxPrice == -1)){
                list.add(listing);
            }
        }
        return list;
    }

    /**
     * gets map listing of properties defined by conditional
     * @param minPrice
     * @param maxPrice
     * @param type
     * @return
     */
    public ArrayList<AirbnbListing> getMapListing(int minPrice, int maxPrice, String type){
        ArrayList<AirbnbListing> list = new ArrayList<>();
        for(AirbnbListing listing : properties){
            if(listing.getPrice() >= minPrice && listing.getPrice() <= maxPrice && (type.equals("All") || listing.getRoom_type().equals(type))){
                list.add(listing);
            }
        }
        return list;
    }

    /**
     * sets properties to null as a reset. will reload properties listing on reset
     */
    public void reset(){
        properties = null;
    }
}
