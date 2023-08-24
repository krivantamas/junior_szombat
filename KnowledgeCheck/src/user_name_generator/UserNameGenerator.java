package user_name_generator;

public class UserNameGenerator {

    public static String generateUserName(String lastName, String firstName, int yearOfBirth) {

        String userName = generateUserNameWithoutYear(lastName, firstName);
        userName += Integer.toString(yearOfBirth).substring(2, 4);

        return userName;
    }

    public static String generateUserNameV2(String lastName, String firstName, int yearOfBirth){

        String userName = generateUserNameWithoutYear(lastName, firstName);

        if(yearOfBirth<2000){
            userName += Integer.toString(yearOfBirth).substring(1, 4);
        }else {
            userName += Integer.toString(yearOfBirth).substring(0, 4);
        }

        return userName;
    }

    private static String generateUserNameWithoutYear(String lastName, String firstName) {
        String userName = "";

        userName += lastName.substring(0, 2).toUpperCase();
        userName += firstName.substring(0, 3).toLowerCase();
        userName += "_";
        return userName;
    }

}
