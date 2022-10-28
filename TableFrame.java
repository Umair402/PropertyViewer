import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Objects;


/**
 * This controls the table frame which is openeed when a user clicks on a clickable button on the map panel
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class TableFrame
{

    //contains the listings to be shown on the table
    private ArrayList<AirbnbListing> listings;

    private static final AirbnbDataCompute compute = new AirbnbDataCompute();

    //holds table columns
    TableColumn name;
    TableColumn hostName;
    TableColumn price;
    TableColumn minNights;
    TableColumn noOfReviews;

    @FXML
    private ComboBox<String> filterBox;

    @FXML
    private Button mapButton;

    @FXML
    private TableView<AirbnbListing> table;


    /**
     * intiliases the table frame on load, gets the listings of valid properties, and sets GUI, with functionality of buttons
     */
    @FXML
    public void initialize() {
        compute.getValidProperties();

        this.listings = compute.getAreaProperties(UserInput.getAreaName());


        this.setButton();
        this.fillBoxes();
        this.setTableCol();
        this.populateTable();

        filterBox.setOnAction(this::sortTable);
        table.setEditable(false);
        //creates functionality to double and single click on each table row
        table.setRowFactory(e -> {
            TableRow<AirbnbListing> row = new TableRow<>();
            row.setOnMouseClicked(new EventHandler<>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 1 && (!row.isEmpty())) {
                        UserInput.setUserChoice(row.getItem());
                    }
                    if (event.getClickCount() == 2 && (!row.isEmpty())) {
                        UserInput.setUserChoice(row.getItem());
                        initDescFrame();
                    }
                }
            });
            return row;
        });

    }

    /**
     * sets the map button
     */
    private void setButton(){
        mapButton.setOnAction(e -> {
            try {
                mapButton(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    /**
     * opens google maps url in browser with lat and long pointing to listing
     * @param actionEvent
     * @throws Exception
     */
    private void mapButton(ActionEvent actionEvent) throws Exception {
        if (UserInput.getUserChoice() != null) {
            double latitude = UserInput.getUserChoice().getLatitude();
            double longitude = UserInput.getUserChoice().getLongitude();

            URI uri = new URI("https://www.google.com/maps/place/" + latitude + "," + longitude);
            java.awt.Desktop.getDesktop().browse(uri);
        }

    }

    /**
     * loads the description frame when a user double clicks on a property
     */
    private void initDescFrame(){
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("description.fxml")));
            Stage stage = new Stage();
            stage.setTitle(UserInput.getAreaName() + " property listings");
            Scene tableScene = new Scene(root, 600, 400);
            stage.setScene(tableScene);
            stage.setMinHeight(400);
            stage.setMinWidth(600);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * fills the boxes of the filer box
     */
    @FXML
    private void fillBoxes() {
        filterBox.setPromptText("Filter");
        filterBox.getItems().add("Number of reviews");
        filterBox.getItems().add("By Price");
        filterBox.getItems().add("By host name");
    }

    /**
     * called when filter combobox is set a value, will filter the table accordingly
     * @param e
     */
    private void sortTable(ActionEvent e) {
        if (filterBox.getValue() != null) {
            if (filterBox.getValue().equals("Number of reviews")) {
                this.sortColumn(noOfReviews, this.getSortType(noOfReviews));
            } else if (filterBox.getValue().equals("By Price")) {
                this.sortColumn(price, this.getSortType(price));
            } else if (filterBox.getValue().equals("By host name")) {
                this.sortColumn(hostName, this.getSortType(hostName));
            }
        }
    }

    /**
     * this allows that when a filter choiec is selected twice it will alternative between sorting types
     * @param col to be filters
     * @return
     */
    private TableColumn.SortType getSortType(TableColumn col){
        if (col.getSortType() == TableColumn.SortType.DESCENDING) {
            return TableColumn.SortType.ASCENDING;
        }
        return TableColumn.SortType.DESCENDING;
    }

    /**
     * sorts the tableview column
     * @param column to sort
     * @param sortType
     */
    private void sortColumn(TableColumn column, TableColumn.SortType sortType){
        table.getSortOrder().clear();
        column.setSortType(sortType);
        table.getSortOrder().add(column);
        table.sort();
    }

    /**
     * sets the table view columns with corresponding airbnb listing fields
     */
    private void setTableCol(){
        name = new TableColumn<>("Description");
        hostName = new TableColumn<>("Host Name");
        price = new TableColumn<>("Price");
        minNights = new TableColumn<>("Minimum Nights");
        noOfReviews = new TableColumn<>("Number of Reviews");

        table.getColumns().addAll(name, hostName, price, minNights, noOfReviews);
    }

    /**
     * populates the tableview table with data derived from arraylist, listings , which contains all valid properties
     */
    private void populateTable(){

        ObservableList<AirbnbListing> data = FXCollections.<AirbnbListing>observableArrayList(this.listings);

        name.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("name"));
        hostName.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("host_name"));
        price.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("price"));
        //you'll have to use camelcase, instead of underscore like in csv, but not for host_name??
        minNights.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("minimumNights"));
        noOfReviews.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("numberOfReviews"));

        table.setItems(data);

    }


}
