package user_name_generator;

public class UserNameGenerator {

    public static String generateUserName(String lastName, String firstName, int yearOfBirth) {

        String userName = "";

        userName += lastName.substring(0, 3).toUpperCase();
        userName += firstName.substring(1, 3).toLowerCase();
        userName += "-";
        userName += Integer.toString(yearOfBirth).substring(1, 4);

        return userName;

    }


}
