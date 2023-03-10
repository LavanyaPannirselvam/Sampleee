package view.application;

import utils.Validator;
import view.ui.enums.MainMenuOptions;


public class MainMenu {
    public static void menu() {
        Authentication authentication= new Authentication();
        System.out.println("Welcome to Library");
            while (true) {
                System.out.println("Choose your option:");
                for (MainMenuOptions options : MainMenuOptions.values()) {
                    System.out.println(options.ordinal() + 1 + " . " + options.name());
                }
                int choice = Validator.getIntInRange(MainMenuOptions.values().length);
                MainMenuOptions option = MainMenuOptions.values()[choice - 1];
                switch (option) {
                    case SIGN_UP:
                        System.out.println(authentication.signIn());
                        break;
                    case LOGIN:
                        System.out.println(authentication.login());
                        break;
                    case QUIT:
                        System.exit(0);
                }
            }
        }
    }
