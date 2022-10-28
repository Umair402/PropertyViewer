import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.nio.file.*;
import java.io.FileNotFoundException;

/**
 * Controls File IO used to store and read comments
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class IOController {
    private final String filename = "comments.txt";

    /**
     * Constructor will check if the files exists or will create a new one
     */
    public IOController() {
        try {
            File commentsFile = new File(filename);
            if (commentsFile.createNewFile()) {
                System.out.println("File created: " + commentsFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * writes a comment to the file
     * @param comment
     */
    public void writeToFile(Comment comment) {
        try (FileWriter myWriter = new FileWriter(filename, true)) {
            myWriter.write(comment.getName() + "/" + comment.getBorough() + "/" + comment.getType() + "/" + comment.getRating() + "/" + comment.getContent());
            myWriter.write("\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * gets all comments in the file
     * @return arraylist of comments
     */
    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> allComments =  new ArrayList<>();
        Path path = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while (line != null) {
                allComments.add(new Comment(line.split("/")[0], line.split("/")[1], line.split("/")[2], line.split("/")[3], line.split("/")[4]));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file " + filename);
        } catch (IOException e) {
            System.out.println("Error occured reading the file " + filename);
        }

        return allComments;
    }
}
