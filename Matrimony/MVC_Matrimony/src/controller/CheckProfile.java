package controller;

public class CheckProfile {
    public String checkSignIn(String uname, String pswd) {
        CallService cs = new CallService();
        return cs.validateDBUser(uname, pswd);
    }
}
