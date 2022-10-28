import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The description frame is a basic frame that contains information of a property when clicked in the TableView
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class DescriptionFrame
{
    // instance variables - replace the example below with your own
    @FXML
    private Label nameLabel;
    @FXML
    private Label hostNameLabel;
    @FXML
    private Label roomTypeLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label noOfReviewsLabel;
    @FXML
    private Label availabilityLabel;
    @FXML
    private Button reviewButton;

    //gets the currentchoice of the user when clicked
    private AirbnbListing listing = UserInput.getUserChoice();
    /**
     * Called when created, will create the labels that store the information , and functionailty to the button which launches the review panel
     */
    @FXML
    public void initialize() {
        this.setLabels();
        reviewButton.setOnAction(this::initReviewFrame);
    }

    /**
     * creates the review frame, when the button is called
     * @param event
     */
    private void initReviewFrame(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("comments.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Add Review");
            Scene ReviewScene = new Scene(root);
            stage.setScene(ReviewScene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sets labels of description frame with values from listing
     */
    private void setLabels() {
        nameLabel.setText(listing.getName());
        hostNameLabel.setText("Host Name:\t" + listing.getHost_name());
        roomTypeLabel.setText("Room Type:\t" + listing.getRoom_type());
        priceLabel.setText("Price:\t£ " + listing.getPrice());
        availabilityLabel.setText("Availability:\t" + listing.getAvailability365());
        noOfReviewsLabel.setText("Number of Reviews:\t" + listing.getNumberOfReviews());

    }
}
