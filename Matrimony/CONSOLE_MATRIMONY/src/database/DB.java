package database;
import user.User;
import java.util.Hashtable;

public class DB {
    public static Hashtable<User,String> user_accounts=new Hashtable<>();
    public static void addUsers(User u,String pswd)
    {
    user_accounts.put(u,pswd);
    }
}
