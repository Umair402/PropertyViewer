import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Controls the 3rd panel, which is the statistics.
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class StatisticsController extends Node
{
    private Statistics stat = new Statistics();
    ArrayList<String> list= new ArrayList<String>();
    ArrayList<String> list2= new ArrayList<String>();
    @FXML private Label label1;
    
    @FXML private Label label2;
    
    @FXML private Label label3;
    
    @FXML private Label label4;

    //stores all the statistics
    private String statistics1 = "Average number of reviews" +"\n"+"per property:" + "\n" + stat.getAverageNumberOfReviews();
    private String statistics2 = "Total number "+"\n"+"of available properties:" + "\n" + stat.getNumberOfProperties();
    private String statistics3 = "The number of entire home"+"\n"+"and apartments:" + "\n" + stat.numberOfEntirehomeApt();
    private String statistics4 = "The most expensive borough:" + "\n" + stat.getMostExpensiveBorough();
    private String statistics5 = "The cheapest borough:" + "\n" + stat.getCheapestBorough();
    private String statistics6 = "The price of "+"\n"+" cheapest private room per night:" + "\n" + stat.getCheapestPrivateRoomPerNight();
    private String statistics7 = "The price of "+"\n"+"cheapest Entire home/apt per night:" + "\n" + stat.getCheapestEntirehomeAptPerNight();
    private String statistics8 = "The price of "+"\n"+"most expensive room per night:" + "\n" + stat.getMostExpensiveRoomPerNight();
    
    @FXML
    private void initialize(){
        label1.setText(statistics1);
        label2.setText(statistics2);
        label3.setText(statistics3);
        label4.setText(statistics4);
        list.add(statistics5);
        list.add(statistics6);
        list.add(statistics7);
        list.add(statistics8);
        list.add(statistics1);
        list.add(statistics2);
        list.add(statistics3);
        list.add(statistics4);
        list2.add(statistics8);
        list2.add(statistics7);
        list2.add(statistics6);
        list2.add(statistics5);
        list2.add(statistics4);
        list2.add(statistics3);
        list2.add(statistics2);
        list2.add(statistics1);
        
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void nextStatisticButtonAction1(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text2 != list.get(0) && text3 != list.get(0) && text4 != list.get(0)){
            String theOne = list.get(0);
            label1.setText(list.get(0));
            list.remove(0);
            list.add(theOne);
        }
        else if(text2 != list.get(1) && text3 != list.get(1) && text4 != list.get(1)){
            String theOne = list.get(1);
            label1.setText(list.get(1));
            list.remove(1);
            list.add(theOne);
        }
        else if(text2 != list.get(2) && text3 != list.get(2) && text4 != list.get(2)){
            String theOne = list.get(2);
            label1.setText(list.get(2));
            list.remove(2);
            list.add(theOne);
        }
        else if(text2 != list.get(3) && text3 != list.get(3) && text4 != list.get(3)){
            String theOne = list.get(3);
            label1.setText(list.get(3));
            list.remove(3);
            list.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void nextStatisticButtonAction2(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text1 != list.get(0) && text3 != list.get(0) && text4 != list.get(0)){
            String theOne = list.get(0);
            label2.setText(list.get(0));
            list.remove(0);
            list.add(theOne);
        }
        else if(text1 != list.get(1) && text3 != list.get(1) && text4 != list.get(1)){
            String theOne = list.get(1);
            label2.setText(list.get(1));
            list.remove(1);
            list.add(theOne);
        }
        else if(text1 != list.get(2) && text3 != list.get(2) && text4 != list.get(2)){
            String theOne = list.get(2);
            label2.setText(list.get(2));
            list.remove(2);
            list.add(theOne);
        }
        else if(text1 != list.get(3) && text3 != list.get(3) && text4 != list.get(3)){
            String theOne = list.get(3);
            label2.setText(list.get(3));
            list.remove(3);
            list.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void nextStatisticButtonAction3(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text1 != list.get(0) && text2 != list.get(0) && text4 != list.get(0)){
            String theOne = list.get(0);
            label3.setText(list.get(0));
            list.remove(0);
            list.add(theOne);
        }
        else if(text1 != list.get(1) && text2 != list.get(1) && text4 != list.get(1)){
            String theOne = list.get(1);
            label3.setText(list.get(1));
            list.remove(1);
            list.add(theOne);
        }
        else if(text1 != list.get(2) && text2 != list.get(2) && text4 != list.get(2)){
            String theOne = list.get(2);
            label3.setText(list.get(2));
            list.remove(2);
            list.add(theOne);
        }
        else if(text1 != list.get(3) && text2 != list.get(3) && text4 != list.get(3)){
            String theOne = list.get(3);
            label3.setText(list.get(3));
            list.remove(3);
            list.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void nextStatisticButtonAction4(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text1 != list.get(0) && text2 != list.get(0) && text3 != list.get(0)){
            String theOne = list.get(0);
            label4.setText(list.get(0));
            list.remove(0);
            list.add(theOne);
        }
        else if(text1 != list.get(1) && text2 != list.get(1) && text3 != list.get(1)){
            String theOne = list.get(1);
            label4.setText(list.get(1));
            list.remove(1);
            list.add(theOne);
        }
        else if(text1 != list.get(2) && text2 != list.get(2) && text3 != list.get(2)){
            String theOne = list.get(2);
            label4.setText(list.get(2));
            list.remove(2);
            list.add(theOne);
        }
        else if(text1 != list.get(3) && text2 != list.get(3) && text3 != list.get(3)){
            String theOne = list.get(3);
            label4.setText(list.get(3));
            list.remove(3);
            list.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void backStatisticButtonAction1(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text2 != list2.get(0) && text3 != list2.get(0) && text4 != list2.get(0)){
            String theOne = list2.get(0);
            label1.setText(list2.get(0));
            list2.remove(0);
            list2.add(theOne);
        }
        else if(text2 != list2.get(1) && text3 != list2.get(1) && text4 != list2.get(1)){
            String theOne = list2.get(1);
            label1.setText(list2.get(1));
            list2.remove(1);
            list2.add(theOne);
        }
        else if(text2 != list2.get(2) && text3 != list2.get(2) && text4 != list2.get(2)){
            String theOne = list2.get(2);
            label1.setText(list2.get(2));
            list2.remove(2);
            list2.add(theOne);
        }
        else if(text2 != list2.get(3) && text3 != list2.get(3) && text4 != list2.get(3)){
            String theOne = list2.get(3);
            label1.setText(list2.get(3));
            list2.remove(3);
            list2.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void backStatisticButtonAction2(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text1 != list2.get(0) && text3 != list2.get(0) && text4 != list2.get(0)){
            String theOne = list2.get(0);
            label2.setText(list2.get(0));
            list2.remove(0);
            list2.add(theOne);
        }
        else if(text1 != list2.get(1) && text3 != list2.get(1) && text4 != list2.get(1)){
            String theOne = list2.get(1);
            label2.setText(list2.get(1));
            list2.remove(1);
            list2.add(theOne);
        }
        else if(text1 != list2.get(2) && text3 != list2.get(2) && text4 != list2.get(2)){
            String theOne = list2.get(2);
            label2.setText(list2.get(2));
            list2.remove(2);
            list2.add(theOne);
        }
        else if(text2 != list2.get(3) && text3 != list2.get(3) && text4 != list2.get(3)){
            String theOne = list2.get(3);
            label2.setText(list2.get(3));
            list2.remove(3);
            list2.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void backStatisticButtonAction3(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text2 != list2.get(0) && text1 != list2.get(0) && text4 != list2.get(0)){
            String theOne = list2.get(0);
            label3.setText(list2.get(0));
            list2.remove(0);
            list2.add(theOne);
        }
        else if(text2 != list2.get(1) && text1 != list2.get(1) && text4 != list2.get(1)){
            String theOne = list2.get(1);
            label3.setText(list2.get(1));
            list2.remove(1);
            list2.add(theOne);
        }
        else if(text2 != list2.get(2) && text1 != list2.get(2) && text4 != list2.get(2)){
            String theOne = list2.get(2);
            label3.setText(list2.get(2));
            list2.remove(2);
            list2.add(theOne);
        }
        else if(text2 != list2.get(3) && text1 != list2.get(3) && text4 != list2.get(3)){
            String theOne = list2.get(3);
            label3.setText(list2.get(3));
            list2.remove(3);
            list2.add(theOne);
        }
    }

    /**
     * controls the buttons on the side of each quadrant
     */
    @FXML
    public void backStatisticButtonAction4(ActionEvent event) throws Exception{
        String text1 = label1.getText();
        String text2 = label2.getText();
        String text3 = label3.getText();
        String text4 = label4.getText();
        if(text2 != list2.get(0) && text3 != list2.get(0) && text1 != list2.get(0)){
            String theOne = list2.get(0);
            label4.setText(list2.get(0));
            list2.remove(0);
            list2.add(theOne);
        }
        else if(text2 != list2.get(1) && text3 != list2.get(1) && text1 != list2.get(1)){
            String theOne = list2.get(1);
            label4.setText(list2.get(1));
            list2.remove(1);
            list2.add(theOne);
        }
        else if(text2 != list2.get(2) && text3 != list2.get(2) && text1 != list2.get(2)){
            String theOne = list2.get(2);
            label4.setText(list2.get(2));
            list2.remove(2);
            list2.add(theOne);
        }
        else if(text2 != list2.get(3) && text3 != list2.get(3) && text1 != list2.get(3)){
            String theOne = list2.get(3);
            label4.setText(list2.get(3));
            list2.remove(3);
            list2.add(theOne);
        }
    }

}

