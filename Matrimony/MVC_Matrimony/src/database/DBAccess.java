package database;

import java.util.Set;

import model.User;

public class DBAccess {

    private DB getDB() {
        return DB.getDB();
    }

    public String dbAddUsers(User u) {
        return getDB().addUser(u);
    }

    public Set<User> giveDB() {
        return getDB().giveDB();
    }

    public User returnCurrentUser() {
        return getDB().getCurrentUser();
    }

    public void callSetCurrentUser(User u) {
        getDB().setCurrentUser(u);
    }

    public String signOut() {
        getDB().setCurrentUser(null);
        return "Logged out successfully!!";
    }

    public String remove(User u) {
        return getDB().removeUser(u);
    }
}
