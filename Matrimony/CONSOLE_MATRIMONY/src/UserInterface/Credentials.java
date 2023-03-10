package UserInterface;

import database.DB;
import user.User;

public class Credentials {
    public void setCredentials(User u,String pswd)
        {
          DB.addUsers(u,pswd);
        }
}
