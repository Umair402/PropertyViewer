import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Rating;

/**
 * This class represents each "CommentLabel", it derives information from a comment object
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class CommentLabel extends VBox
{
    // instance variables - replace the example below with your own
    private String name;
    private String borough;
    private String type;
    private String rating;
    private String content;


    /**
     * Constructor for objects of class Comments
     */
    public CommentLabel(Comment comment) {
        this.name = comment.getName();
        this.borough = comment.getBorough();
        this.type = comment.getType();
        this.rating = comment.getRating();
        this.content = comment.getContent();
        makeLabel();
        getStylesheets().add("css/styleComments.css");
    }

    /**
     * creates the inner content of the "label"
     */
    public void makeLabel() {
        Label nameLabel = new Label(name + "\t   " + rating);
        nameLabel.setId("nameLabel");
        Label boroughLabel = new Label(borough + ",\t" +type + "\n");
        boroughLabel.setId("boroughLabel");
        Label contentLabel = new Label(content);
        contentLabel.setId("contentLabel");
        getChildren().addAll(boroughLabel, nameLabel, contentLabel, new Label("\n"));
    }
}
