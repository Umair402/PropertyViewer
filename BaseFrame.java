import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;

/**
 * This creates the main frame that the user is presented with upon startup.
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class BaseFrame extends Application {

    //create the panels the user will see
    private VBox welcomePanel = createWelcomePanel();
    private StatisticsController statsContent;
    private CommentPanel commentPanel;
    private MapPanel mapContent;
    // holds panels so that the user can iterate through the panels
    private Node[] panelList = {welcomePanel, mapContent, statsContent, commentPanel};
    private int panelPointer = 0;

    //create buttons at the bottom
    private Button backButton;
    private Button forwardButton;

    //create side buttons
    private Button homeButton;
    private Button mapButton;
    private Button statsButton;
    private Button commentsButton;
    private Button[] sideButtonsList;

    // create topbar price boxes
    private ComboBox<Integer> lowerPrice;
    private ComboBox<Integer> upperPrice;
    private HBox toolBar;
    private HBox bottomBar;
    private VBox sideBar;
    private BorderPane ContentPane;

    /**
     * The start method is the main entry point for every JavaFX application.
     * It is called after the init() method has returned and after
     * the system is ready for the application to begin running.
     *
     * @param stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        this.initialize();
        VBox root = new VBox();

        makeMenuBar(stage, root);
        makeToolBar();
        makeBottomBar();
        makeSideBar();

        ContentPane = new BorderPane(panelList[panelPointer], null, null, bottomBar, sideBar);

        VBox.setVgrow(ContentPane, Priority.ALWAYS);
        root.getChildren().addAll(toolBar, ContentPane);
        Scene scene = new Scene(root);

        scene.getStylesheets().add("css/styleBase.css");
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.setMinHeight(650);
        stage.setMinWidth(1100);

        // Show the Stage (window)
        stage.show();

    }

    /**
     * called upon startup , this create a new AirbnbDataCompute object which will create the properties listings once
     */
    private void initialize(){
        new AirbnbDataCompute();
    }

    /**
     * create a welcome panel
     * @return VBox
     */
    private VBox createWelcomePanel()
    {
        Label welcome = new Label("Welcome");
        welcome.setId("welcomeLabel");
        Label introText = new Label("Please select a price range and then use the buttons to view all of the properties in that range\nas well as various statistics about them");
        introText.setId("introLabel");
        return new VBox(welcome, introText);
    }

    /**
     * creates the bottombar that contains the forward and back buttons
     */
    private void makeBottomBar() {
        backButton = new Button("Prev");
        backButton.setMaxWidth(Double.MAX_VALUE);
        forwardButton = new Button("Next");
        forwardButton.setMaxWidth(Double.MAX_VALUE);
        bottomBar = new HBox(backButton, forwardButton);
        bottomBar.setAlignment(Pos.BOTTOM_RIGHT);
        bottomBar.setId("bottomBar");

        backButton.setDisable(true);
        forwardButton.setDisable(true);

        backButton.setOnAction(this::funcPrev);
        forwardButton.setOnAction(this::funcNext);
    }

    /**
     * button to go to previous panel, changes the centre of borderpan to panel accordingly
     * @param event
     */
    private void funcPrev(ActionEvent event) {
        panelPointer = panelPointer - 1;
        if (panelPointer == -1) {
            panelPointer = 3;
        }
        else if (panelPointer == 3){
            panelList[3] = new CommentPanel();
        }
        ContentPane.setCenter(panelList[panelPointer]);
        this.changeSideButtons();
    }

    /**
     * button to go to the next panel, changes the centre of borderpan to panel accordingly
     * @param event
     */
    private void funcNext(ActionEvent event) {
        panelPointer = panelPointer + 1;
        if (panelPointer == 4) {
            panelPointer = 0;
        }
        else if (panelPointer == 3){
            panelList[3] = new CommentPanel();
        }
        panelList[3] = new CommentPanel();
        ContentPane.setCenter(panelList[panelPointer]);
        this.changeSideButtons();
    }

    /**
     * this disables the side bar button when the user is on the current panel of it
     */
    private void changeSideButtons(){
        this.buttonsDisable(false ,homeButton,mapButton,statsButton,commentsButton);
        this.buttonsDisable(true,sideButtonsList[panelPointer]);
    }

    /**
     * creates side bar , which holds the "quick access" buttons to the panels
     */
    private void makeSideBar() {
        sideBar = new VBox();
        sideBar.setId("sideBar");
        homeButton = new Button("HOME");
        mapButton = new Button("MAP");
        statsButton = new Button("STATS");
        commentsButton = new Button("REVIEW");

        this.buttonsDisable(true,homeButton,mapButton,statsButton,commentsButton);
        sideButtonsList = new Button[]{homeButton, mapButton, statsButton, commentsButton};
        homeButton.setOnAction(e -> setSideButtons(0));
        mapButton.setOnAction(e -> setSideButtons(1));
        statsButton.setOnAction(e -> setSideButtons(2));
        commentsButton.setOnAction(e -> setSideButtons(3));
        sideBar.getChildren().addAll(homeButton, mapButton, statsButton, commentsButton);
    }

    /**
     * sets the side buttons to demonstrate the panel accordingly
     * @param n corresponds to the panel
     */
    private void setSideButtons(int n){
        panelPointer = n;
        if (panelPointer == 3){
            panelList[3] = new CommentPanel();
        }
        ContentPane.setCenter(panelList[panelPointer]);
        this.changeSideButtons();
    }

    /**
     * takes buttons and enables|disables them based on @param Boolean b provided
     * @param b
     * @param args
     */
    private void buttonsDisable(Boolean b, Button... args){
        for (Button button: args){
            button.setDisable(b);
        }
    }

    /**
     * creates top toolbar containing price choice boxes
     */
    private void makeToolBar() {
        lowerPrice = new ComboBox<>();
        upperPrice = new ComboBox<>();
        this.fillChoices();
        toolBar = new HBox(lowerPrice, upperPrice);

        toolBar.setAlignment(Pos.TOP_RIGHT);
        toolBar.setId("toolBar");

        lowerPrice.setOnAction(this::choiceSelection);
        upperPrice.setOnAction(this::choiceSelection);

    }

    /**
     * Called when an event occurs on the choice boxes
     * @param actionEvent
     */
    private void choiceSelection(ActionEvent actionEvent) {
        if (lowerPrice.getValue() != null && upperPrice.getValue() != null) {
            if (lowerPrice.getValue() < upperPrice.getValue()) {
                this.changeSideButtons();
                this.buttonsDisable(false, backButton, forwardButton);
                UserInput.setlowerPrice(lowerPrice.getValue());
                UserInput.setupperPrice(upperPrice.getValue());
                // assign each panel in the panelList
                try {
                    URL map_url = getClass().getResource("map2.fxml");
                    URL stats_url = getClass().getResource("statistics.fxml");
                    panelList[1] = FXMLLoader.load(map_url);
                    panelList[2] = FXMLLoader.load(stats_url);
                    panelList[3] = new CommentPanel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ContentPane.setCenter(panelList[panelPointer]);
            } else {
                panelPointer = 0;
                ContentPane.setCenter(panelList[panelPointer]);
                Dialogs.invalidRangeError();
                this.buttonsDisable(true, backButton, forwardButton);
                this.buttonsDisable(true,homeButton,mapButton,statsButton,commentsButton);
            }
        }
    }

    /**
     * makes the menu bar at the top of the stage
     * @param stage
     * @param parent
     */
    private void makeMenuBar(Stage stage, Pane parent) {
        MenuBar menubar = new MenuBar();
        parent.getChildren().add(menubar);
        menubar.setId("menuBar");


        Menu viewMenu = new Menu("Options");

        MenuItem mapItem = new MenuItem("Reset");
        mapItem.setOnAction(e -> restart(stage));
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.SHORTCUT_DOWN));
        quitItem.setOnAction(e -> System.exit(1));

        Menu helpMenu = new Menu("Help");

        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> Dialogs.aboutInfoDialog());
        MenuItem helpItem = new MenuItem("Help");
        helpItem.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.SHORTCUT_DOWN));
        helpItem.setOnAction(e -> Dialogs.helpInfoDialog());

        viewMenu.getItems().addAll(mapItem, quitItem);
        helpMenu.getItems().addAll(aboutItem, helpItem);

        menubar.getMenus().addAll(viewMenu, helpMenu);
    }

    /**
     * called when the menubar item "reset" is called, will reset the program
     * @param stage
     */
    private void restart(Stage stage){
        stage.close();
        cleanup(stage);
        start(stage);
    }

    /**
     * when restart method is called the program will reset any existing variables
     * @param stage
     */
    private void cleanup(Stage stage){
        panelPointer = 0;
        UserInput.reset();
        AirbnbDataCompute a = new AirbnbDataCompute();
        a.reset();
    }

    /**
     * fills the choiceboxes with prices at startup
     */
    private void fillChoices() {
        lowerPrice.setPromptText("Minimum Price");
        upperPrice.setPromptText("Maximum Price");
        lowerPrice.getItems().add(0);
        int price = 0;
        for (int i = 0; i < 16; i++) {
            price += 100;
            if (i > 9)
                price += 900;
            lowerPrice.getItems().add(price);
            upperPrice.getItems().add(price);
        }
    }
}