package service;

import java.util.Set;

import database.DBAccess;
import model.User;

public class CheckUser {
    DBAccess dba = new DBAccess();
    private Set<User> accounts = dba.giveDB();

    public String validateUser(String uname, String pswd) {
        for (User u : accounts) {
            if (uname.equals(u.getUserName()) && pswd.equals(u.getPassword())) {
                dba.callSetCurrentUser(u);
                return "Login success! You can proceed further";
            }
        }
        return "User not found!!Click 1 in the main menu to register yourself";
    }
}
