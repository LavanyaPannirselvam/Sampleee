package controller;

import database.*;
//util class
public class CheckCurrentUser {
    private final static DBAccess dba = new DBAccess();

    static public boolean checkCurrentUser() {
        if (dba.returnCurrentUser() != null)
            return true;
        return false;
    }
}
