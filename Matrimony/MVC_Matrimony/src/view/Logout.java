package view;

import controller.CheckCurrentUser;
import controller.RemoveProfile;

public class Logout {
   public String logout() {
      if (!CheckCurrentUser.checkCurrentUser())
            return "Login yourself to logout!";
      RemoveProfile rp = new RemoveProfile();
      return rp.signOut();
   }
}
