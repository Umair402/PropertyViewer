import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * The mapPanel is the 2 panel which shows the interactive map
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class MapPanel extends Node
{
    private static final AirbnbDataCompute compute = new AirbnbDataCompute();

    @FXML
    private Button ENFI, BARN, HRGY, WALT, HRRW, BREN, CAMD, ISLI,
    HACK, REDB, HAVE, HILL, EALI, KENS, WSTM, TOWH, NEWH, BARK, HOUN,
    HAMM, WAND, CITY ,GWCH, BEXL, RICH, MERT, LAMB, STWH, LEWS, KING,
    SUTT, CROY, BROM;

    @FXML
    private BorderPane mapBPane;

    /**
     * initliased when created, will compute valid properties and created a side label
     */
    @FXML
    public void initialize(){
        mapBPane.setRight(new Label("\t\t\t\t\t\t\t\t"));
        compute.getValidProperties();

        this.setButtons();
    }

    /**
     * initialises the opens a table frame when a map button is clicked
     * @param areaName, will show the table data for the areaname chosen
     */
    private void initTableFrame(String areaName){
        Parent root;
        UserInput.setAreaName(areaName);
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("table.fxml")));
            Stage stage = new Stage();
            stage.setTitle(areaName + " property listings");
            Scene tableScene = new Scene(root);
            stage.setScene(tableScene);
            stage.setMinHeight(560);
            stage.setMinWidth(791);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * will show a right side label displaying the number of properties and full name of the borough
     * @param area to be seen on side label
     * @return vbox of the right side label
     */
    private Node setButtonInfoLabel(String area){
        Label areaSideLabel = new Label(area);
        areaSideLabel.setStyle("-fx-font: 18px 'Arial'");
        Label propertiesSideLabel = new Label("Number of properties: " + compute.getnumOfProperties(area));
        propertiesSideLabel.setStyle("-fx-font: 16px 'Arial'");
        return new VBox(new Label("\t\t\t\t\t\t\t\t"),areaSideLabel, propertiesSideLabel);
    }

    /**
     * sets the states of all the buttons. states include the colour of the button and whether it's disabled
     */
    private void setButtonState(String area, Button button) {
        button.setDisable(false);
        button.setOnMouseEntered(e -> mapBPane.setRight(setButtonInfoLabel(area)));
        int numOfProp = compute.getnumOfProperties(area);
        if (numOfProp == 0) {
            button.setDisable(true);
        } else if (numOfProp < 20) {
            button.setStyle("-fx-background-color: rgba(194,255,174,0.3)");
        } else if (numOfProp < 50) {
            button.setStyle("-fx-background-color: rgba(175,255,149,0.3)");
        } else if (numOfProp < 100) {
            button.setStyle("-fx-background-color: rgba(138,255,101,0.3)");
        } else if (numOfProp < 200) {
            button.setStyle("-fx-background-color: rgba(106,255,57,0.3)");
        } else if (numOfProp < 500) {
            button.setStyle("-fx-background-color: rgba(71,255,12,0.3)");
        } else {
            button.setStyle("-fx-background-color: rgba(0,255,128,0.3)");
        }
    }

    /**
     * sets functionailty of the buttons to open the appropiate tableview when clicked, also calls to set the state of the button
     */
    @FXML
    private void setButtons(){
        this.setButtonState(BoroughName.get(Borough.BARK), BARK);
        BARK.setOnAction(e -> initTableFrame(BoroughName.get(Borough.BARK)));

        this.setButtonState(BoroughName.get(Borough.BARN), BARN);
        BARN.setOnAction(e -> initTableFrame(BoroughName.get(Borough.BARN)));

        this.setButtonState(BoroughName.get(Borough.BEXL), BEXL);
        BEXL.setOnAction(e -> initTableFrame(BoroughName.get(Borough.BEXL)));

        this.setButtonState(BoroughName.get(Borough.BREN), BREN);
        BREN.setOnAction(e -> initTableFrame(BoroughName.get(Borough.BREN)));

        this.setButtonState(BoroughName.get(Borough.BROM), BROM);
        BROM.setOnAction(e -> initTableFrame(BoroughName.get(Borough.BROM)));

        this.setButtonState(BoroughName.get(Borough.CAMD), CAMD);
        CAMD.setOnAction(e -> initTableFrame(BoroughName.get(Borough.CAMD)));

        this.setButtonState(BoroughName.get(Borough.CITY), CITY);
        CITY.setOnAction(e -> initTableFrame(BoroughName.get(Borough.CITY)));

        this.setButtonState(BoroughName.get(Borough.CROY), CROY);
        CROY.setOnAction(e -> initTableFrame(BoroughName.get(Borough.CROY)));

        this.setButtonState(BoroughName.get(Borough.EALI), EALI);
        EALI.setOnAction(e -> initTableFrame(BoroughName.get(Borough.EALI)));

        this.setButtonState(BoroughName.get(Borough.ENFI), ENFI);
        ENFI.setOnAction(e -> initTableFrame(BoroughName.get(Borough.ENFI)));

        this.setButtonState(BoroughName.get(Borough.GWCH), GWCH);
        GWCH.setOnAction(e -> initTableFrame(BoroughName.get(Borough.GWCH)));

        this.setButtonState(BoroughName.get(Borough.HACK), HACK);
        HACK.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HACK)));

        this.setButtonState(BoroughName.get(Borough.HAMM), HAMM);
        HAMM.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HAMM)));

        this.setButtonState(BoroughName.get(Borough.HRGY), HRGY);
        HRGY.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HRGY)));

        this.setButtonState(BoroughName.get(Borough.HRRW), HRRW);
        HRRW.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HRRW)));

        this.setButtonState(BoroughName.get(Borough.HAVE), HAVE);
        HAVE.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HAVE)));

        this.setButtonState(BoroughName.get(Borough.HILL), HILL);
        HILL.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HILL)));

        this.setButtonState(BoroughName.get(Borough.HOUN), HOUN);
        HOUN.setOnAction(e -> initTableFrame(BoroughName.get(Borough.HOUN)));

        this.setButtonState(BoroughName.get(Borough.ISLI), ISLI);
        ISLI.setOnAction(e -> initTableFrame(BoroughName.get(Borough.ISLI)));

        this.setButtonState(BoroughName.get(Borough.KENS), KENS);
        KENS.setOnAction(e -> initTableFrame(BoroughName.get(Borough.KENS)));

        this.setButtonState(BoroughName.get(Borough.KING), KING);
        KING.setOnAction(e -> initTableFrame(BoroughName.get(Borough.KING)));

        this.setButtonState(BoroughName.get(Borough.LAMB), LAMB);
        LAMB.setOnAction(e -> initTableFrame(BoroughName.get(Borough.LAMB)));

        this.setButtonState(BoroughName.get(Borough.LEWS), LEWS);
        LEWS.setOnAction(e -> initTableFrame(BoroughName.get(Borough.LEWS)));

        this.setButtonState(BoroughName.get(Borough.MERT), MERT);
        MERT.setOnAction(e -> initTableFrame(BoroughName.get(Borough.MERT)));

        this.setButtonState(BoroughName.get(Borough.NEWH), NEWH);
        NEWH.setOnAction(e -> initTableFrame(BoroughName.get(Borough.NEWH)));

        this.setButtonState(BoroughName.get(Borough.REDB), REDB);
        REDB.setOnAction(e -> initTableFrame(BoroughName.get(Borough.REDB)));

        this.setButtonState(BoroughName.get(Borough.RICH), RICH);
        RICH.setOnAction(e -> initTableFrame(BoroughName.get(Borough.RICH)));

        this.setButtonState(BoroughName.get(Borough.STWH), STWH);
        STWH.setOnAction(e -> initTableFrame(BoroughName.get(Borough.STWH)));

        this.setButtonState(BoroughName.get(Borough.SUTT), SUTT);
        SUTT.setOnAction(e -> initTableFrame(BoroughName.get(Borough.SUTT)));

        this.setButtonState(BoroughName.get(Borough.TOWH), TOWH);
        TOWH.setOnAction(e -> initTableFrame(BoroughName.get(Borough.TOWH)));

        this.setButtonState(BoroughName.get(Borough.WALT), WALT);
        WALT.setOnAction(e -> initTableFrame(BoroughName.get(Borough.WALT)));

        this.setButtonState(BoroughName.get(Borough.WAND), WAND);
        WAND.setOnAction(e -> initTableFrame(BoroughName.get(Borough.WAND)));

        this.setButtonState(BoroughName.get(Borough.WSTM), WSTM);
        WSTM.setOnAction(e -> initTableFrame(BoroughName.get(Borough.WSTM)));

    }
}
