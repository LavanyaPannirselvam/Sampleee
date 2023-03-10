package model.user;

public class Customer extends Person{
    static int count=0;
    public Customer(String name, String password, String userID) {
        super(name, password, userID+ (++count));
    }


}
