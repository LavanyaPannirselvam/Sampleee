package UserInterface;

import java.util.Set;

import database.DB;
import user.User;

public class DBCheck {
    public int validateUser(String username,String pwsd)
    {
        boolean status=false;
        Set<User> users=DB.user_accounts.keySet();
        for(User hs:users)
        {
            if(hs.getUserName().equals(username))
            {
                status = checkPassword(username);
               // flag=1;
            }
        }        
            return 1;
        return 0;
    }

    private static boolean checkPassword(String uname)
    {
        if(DB.user_accounts.contains(pwd))//need to check whether the password belongs to the given username
        {
               System.out.println("Success");
               return true;
        }
        else
        {
            System.out.println("Password not found! Try giving the registered password");
            return checkPassword(uname);
        }
    }
}
