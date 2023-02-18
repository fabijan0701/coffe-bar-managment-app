package app.entities;

public class User implements Person{

    private final int id;
    private String firstName;
    private String lastName;
    private String accessKey;

    /**
     * Constructor that takes 4 arguments including id
     */
    public User(int id, String firstName, String lastName, String accessKey) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setAccessKey(accessKey);
    }

    /**
     * Constructor that takes 3 arguments excluding id
     */
    public User(String firstName, String lastName, String accessKey) {
        id = -1;
        setFirstName(firstName);
        setLastName(lastName);
        setAccessKey(accessKey);
    }


    public User() {
        id = -1;
        setFirstName("Unknown");
        setLastName("Unknown");
        setAccessKey("Unknown");
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
