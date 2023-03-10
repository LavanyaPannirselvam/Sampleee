package service;

import database.DBAccess;
import model.User;

public class CallImpl implements CallInterface {
    DBAccess dba = new DBAccess();
    ShowDetails sd = new ShowDetails();
    GetUser gu = new GetUser();

    public String callDisplay(String uname) {
        User u = gu.getUserObj(uname);
        if (u == null)
            return "User not found";
        sd.displayAllDetails(u);
        return "";
    }

    public String callDisplay() {
        User u = dba.returnCurrentUser();
        if (u == null)
            return "Login yourself to proceed yourself";
        else {
            sd.displayAllDetails(gu.getUserObj(u.getUserName()));
            return "";
        }
    }
}
