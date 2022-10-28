import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StatisticsTest.
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class StatisticsTest
{
    Statistics stats = new Statistics();
    /**
     * Default constructor for test class StatisticsTest
     */
    public StatisticsTest()
    {
    }

    /**
     * sets prices to carry out testing
     * @param l , lowerprice
     * @param u , upperprice
     */
    private void setTestPrices(int l,int u){
        UserInput.setlowerPrice(l);
        UserInput.setupperPrice(u);
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * tests the average number of reviews
     */
    @Test
    public void test_getAverageNumberOfReviews(){
        setTestPrices(5000,7000);
        assertEquals(0.63, stats.getAverageNumberOfReviews());
        setTestPrices(900,1000);
        assertEquals(1.41, stats.getAverageNumberOfReviews());
        setTestPrices(0,7000);
        assertEquals(12.47, stats.getAverageNumberOfReviews());
        setTestPrices(0,0);
        assertEquals(0, stats.getAverageNumberOfReviews());
    }

    /**
     * tests the number of properties
     */
    @Test
    public void test_getNumberOfProperties(){
        setTestPrices(0,7000);
        assertEquals(53904, stats.getNumberOfProperties());
        setTestPrices(0,0);
        assertEquals(0, stats.getNumberOfProperties());
        setTestPrices(9000,10000);
        assertEquals(0, stats.getNumberOfProperties());
        setTestPrices(500,4500);
        assertEquals(353, stats.getNumberOfProperties());
    }

    /**
     * tests the number of entire home apartments
     */
    @Test
    public void test_numberOfEntirehomeApt(){
        setTestPrices(0,7000);
        assertEquals(27175, stats.numberOfEntirehomeApt());
        setTestPrices(0,0);
        assertEquals(0, stats.numberOfEntirehomeApt());
        setTestPrices(9000,10000);
        assertEquals(0, stats.numberOfEntirehomeApt());
        setTestPrices(450,6250);
        assertEquals(459, stats.numberOfEntirehomeApt());

    }

    /**
     * tests the most expensive borough
     */
    @Test
    public void test_getMostExpensiveBorough(){
        setTestPrices(0,7000);
        assertEquals("Westminster", stats.getMostExpensiveBorough());
        setTestPrices(0,0);
        assertEquals("None", stats.getMostExpensiveBorough());
        setTestPrices(9000,10000);
        assertEquals("None", stats.getMostExpensiveBorough());
        setTestPrices(450,6250);
        assertEquals("Camden", stats.getMostExpensiveBorough());
    }

    /**
     * tests the cheapest borough
     */
    @Test
    public void test_getCheapestBorough(){
        setTestPrices(400,6000);
        assertEquals("Hillingdon", stats.getCheapestBorough());
        setTestPrices(0,7000);
        assertEquals("Havering", stats.getCheapestBorough());
        setTestPrices(0,0);
        assertEquals("None", stats.getCheapestBorough());
        setTestPrices(9000,10000);
        assertEquals("None", stats.getCheapestBorough());
    }

    /**
     * tests the cheapest private room per night
     */
    @Test
    public void test_getCheapestPrivateRoomPerNight(){
        setTestPrices(435,6000);
        assertEquals(435, stats.getCheapestPrivateRoomPerNight());
        setTestPrices(0,7000);
        assertEquals(8, stats.getCheapestPrivateRoomPerNight());
        setTestPrices(0,0);
        assertEquals(0, stats.getCheapestPrivateRoomPerNight());
        setTestPrices(9000,10000);
        assertEquals(0, stats.getCheapestPrivateRoomPerNight());
    }

    /**
     * tests the cheaperst entire home apartment per night
     */
    @Test
    public void test_getCheapestEntirehomeAptPerNight(){
        setTestPrices(438,6000);
        assertEquals(440, stats.getCheapestEntirehomeAptPerNight());
        setTestPrices(0,7000);
        assertEquals(9, stats.getCheapestEntirehomeAptPerNight());
        setTestPrices(0,0);
        assertEquals(0, stats.getCheapestEntirehomeAptPerNight());
        setTestPrices(9000,10000);
        assertEquals(0, stats.getCheapestEntirehomeAptPerNight());
    }

    /**
     * tests the most expensive room per night
     */
    @Test
    public void test_getMostExpensiveRoomPerNight(){
        setTestPrices(450,4500);
        assertEquals(4000, stats.getMostExpensiveRoomPerNight());
        setTestPrices(0,7000);
        assertEquals(7000, stats.getMostExpensiveRoomPerNight());
        setTestPrices(0,0);
        assertEquals(0, stats.getMostExpensiveRoomPerNight());
        setTestPrices(9000,10000);
        assertEquals(0, stats.getMostExpensiveRoomPerNight());
    }
}
