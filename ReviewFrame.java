import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.util.ArrayList;

/**
 * ReviewFrame is a basic review frame that allows the user to submit their own reviews
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class ReviewFrame
{
    // instance variables
    @FXML
    private Label reviewLabel;

    @FXML
    private Rating ratingBar;

    @FXML
    private TextField userTextField;

    @FXML
    private TextArea commentTextArea;

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;

    private static final IOController IOController = new IOController();

    /**
     * initialises the review frame when loaded, and sets the button functionality
     */
    @FXML
    public void initialize(){
        reviewLabel.setText("Review for: "+UserInput.getUserChoice().getName());
        submitButton.setOnAction(this::commentSelection);
        cancelButton.setOnAction(e -> closeFrame());
    }

    /**
     * closes the frame
     */
    private void closeFrame(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * called with submit button, will validate the text fileds and then use IOController to write data into textfile
     * @param event
     */
    private void commentSelection(ActionEvent event){
        String rating = String.valueOf(ratingBar.getRating());
        String userText = userTextField.getText();
        String commentText =  commentTextArea.getText();
        if ((!(userText.isEmpty()) && !(commentText.isEmpty()))) {
            commentText = commentText.replace("\n", " ").replace("\r", " ");
            Comment userComment = new Comment(userText, UserInput.getUserChoice().getNeighbourhood(), UserInput.getUserChoice().getName(), rating, commentText);
            IOController.writeToFile(userComment);
            closeFrame();
        }
        else {
            Dialogs.fillBoxesError();
        }
    }
}
