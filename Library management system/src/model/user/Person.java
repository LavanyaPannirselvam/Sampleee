package model.user;

public abstract class Person {
    public final String name;
    private final String password;
    public final String userID;

     Person(String name, String password, String userID) {
        this.name = name;
        this.password = password;
        this.userID = userID;
    }
}
