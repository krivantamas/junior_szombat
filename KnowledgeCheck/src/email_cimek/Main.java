package email_cimek;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        File file = new File("src\\email_cimek\\nevek.txt");
        List<String> emails = Email.generateEmail(file);

        System.out.println(emails);

        

    }
}
