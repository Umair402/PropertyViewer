
/**
 * Represents once comment as seen in the text file or review panel
 *
 * @authors Umair Qureshi (K21088867) Abdul Mallah (19033553) , Jingyi Wang (K20057806) , Zhihao Wu (K21040194)
 */
public class Comment
{
    // instance variables that consitiute the comment
    private String name;
    private String borough;
    private String propertyType;
    private String rating;
    private String commentContent;


    /**
     * Constructor for objects of class Comment
     */
    public Comment(String commentor, String propertyBorough, String type, String rating, String content)
    {
        this.name = commentor;
        this.borough = propertyBorough;
        this.propertyType = type;
        this.commentContent = content;
        this.rating = rating;
    }

    /**
     * @return    the name of comment
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return     borough of the comment
     */
    public String getBorough()
    {
        return borough;
    }

    /**
     * @return     type( description of listing) of the comment
     */
    public String getType()
    {
        return propertyType;
    }

    /**
     * @return     user submitted comment
     */
    public String getContent()
    {
        return commentContent;
    }

    /**
     * @return     rating of the comment
     */
    public String getRating(){
        return rating;
    }
    /**
     * @return    the user name of the comment
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * set the borough of the comment
     */
    public void setBorough(String newBorough)
    {
        borough = newBorough;
    }

    /**
     * set the type of the comment
     */
    public void setType(String newType)
    {
        propertyType = newType;
    }

    /**
     * set the rating of the comment
     */
    public void setRating(String newRating){
        rating = newRating;
    }

    /**
     * set the content of the comment
     */
    public void setContent(String newContent)
    {
        commentContent = newContent;
    }
}
