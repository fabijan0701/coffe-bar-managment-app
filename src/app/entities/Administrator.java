package app.entities;

public class Administrator extends User{

    public Administrator() {
        super();
    }

    public Administrator(String firstName, String lastName, String accessKey){
        super(firstName, lastName, accessKey);
    }

    public Administrator(int id, String firstName, String lastName, String accessKey) {
        super(id, firstName, lastName, accessKey);
    }
}
