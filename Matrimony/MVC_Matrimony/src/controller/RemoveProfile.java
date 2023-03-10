package controller;

import database.DBAccess;
import model.User;

public class RemoveProfile {
    DBAccess dba = new DBAccess();

    public String signOut() {
            return dba.signOut();               
    }

    public String removeProfile() {
        User u = dba.returnCurrentUser();
        return dba.remove(u);
    }
}
