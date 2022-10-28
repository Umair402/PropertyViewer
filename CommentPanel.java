import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * The 4th panel , which contains all the user created comments on a scrollpane
 * comments are added on as CommentLabel objects
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class CommentPanel extends ScrollPane {

    private static final IOController IOController = new IOController();

    /**
     * Constructor for objects of class CommentPanel
     */
    public CommentPanel() {
        buildUI();
    }

    /**
     * creates the UI of the panel: a scrollPane
     */
    private void buildUI() {

        getStylesheets().add("css/styleComments.css");
        this.addComment();
        setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    /**
     * adds comments to the scrollPane (this), will communicate with IOController to get a list of all comments
     */
    private void addComment(){
        ArrayList<Comment> commentsArr = IOController.getAllComments();
        VBox content = new VBox();

        Label commentsLabel = new Label("Comments\n");
        commentsLabel.setId("commentTitleLabel");
        content.getChildren().add(commentsLabel);

        setContent(content);
        for (Comment comment: commentsArr){
            content.getChildren().add(new CommentLabel(comment));
        }
    }


}
