package service;

import java.util.Set;

import database.DBAccess;
import model.User;
//to get user 
class GetUser {
    DBAccess dba = new DBAccess();
    private Set<User> accounts = dba.giveDB();

    User getUserObj(String uname) {
        for (User u : accounts) {
            if (uname.equals(u.getUserName()))
                return u;
        }      
        return null;
    }

   
}
