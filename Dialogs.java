import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

/**
 * Creates very basic dialogs
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class Dialogs
{
    // instance variables - replace the example below with your own

    /**
     * gets all param information and creates a basicDialog
      * @param alertType
     * @param title
     * @param text
     */
    private static void basicDialog(Alert.AlertType alertType, String title, String text) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(text);
        alert.showAndWait();
    }

    /**
     * invalid range error dialog called when user inputs a range where the lowerRange > upperRange
     */
    public static void invalidRangeError() {
        String title = "Price range error";
        String text = "Please select a valid price range";

        basicDialog(Alert.AlertType.ERROR, title, text);
    }

    /**
     * about info dialog called when user wnats to see information about Airbnb london
     */
    public static void aboutInfoDialog(){
        String title = "About";
        String text = "London Property Marketplace\n\nVersion 1.0";

        basicDialog(Alert.AlertType.INFORMATION, title, text);
    }

    /**
     * help dialog will show when user wants to see help about airbnb london
     */
    public static void helpInfoDialog(){
        String title = "Help";
        String text = "London property marketplace is a GUI for exploring properties that are available for temporary rental " +
                "in London. You can view properties, see statistics regarding boroughs, check comments and more.";

        basicDialog(Alert.AlertType.INFORMATION, title, text);
    }

    /**
     * fill boxes error called when boxes are not fill in the review frame
     */
    public static void fillBoxesError(){
        String title = "Fill required boxes";
        String text = "Please fill all the boxes";

        basicDialog(Alert.AlertType.ERROR, title, text);

    }
}
