package uz.tigersteam.models;

/**
 * @author Nodirbek Abdukarimov Fri. 10:01 AM. 12/24/2021
 */
public class User extends Auditable {
    private String language;
    private String fullName;
    private int age;
    private String phoneNumber;
    private long chatID;
    private String role = "USER";
    private String state;

    private String login;
    private String password;
}
