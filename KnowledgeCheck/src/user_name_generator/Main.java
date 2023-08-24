package user_name_generator;


public class Main {
    public static void main(String[] args) {


        String userName_1 = UserNameGenerator.generateUserName("Teszt", "Elek", 1996);
        String userName_2 = UserNameGenerator.generateUserNameV2("Teszt", "Elek", 1996);
        String userName_3 = UserNameGenerator.generateUserNameV2("Teszt", "Elek", 2006);
        System.out.println(userName_1);
        System.out.println(userName_2);
        System.out.println(userName_3);
    }
}
