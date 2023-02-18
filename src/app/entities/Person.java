package app.entities;

public interface Person {

    /**
     * Returns id of the person instance
     * @return numeric value that represents id of the person instance
     */
    int getId();

    /**
     * Returns the actual first name of person instance
     * @return string that represents first name
     */
    String getFirstName();

    /**
     * Sets the first name to user instance
     * @param firstName represents first name to be set
     */
    void setFirstName(String firstName);

    /**
     * Returns the actual last name of person instance
     * @return string that represents last name
     */
    String getLastName();

    /**
     * Sets the last name to user instance
     * @param lastName represents last name to be set
     */
    void setLastName(String lastName);
}
