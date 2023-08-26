package email_cimek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Email {
    
    public static List<String> generateEmail(File file){

        List<String> emailList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            String line = "";

            while (scanner.hasNextLine()){

                
                line = scanner.nextLine();
                String[] separateName = line.split(" ");
                String emailAdress = separateName[0].substring(0, 3).toUpperCase() + "_" +  separateName[1].substring(0, 2).toLowerCase() + "@webler.hu";

                if (!emailList.contains(emailAdress)){
                    emailList.add(emailAdress);
                }
                else {
                    int id = 2;

                    String[] emailSplit = emailAdress.split("@");
                    String newEmailAdress = emailSplit[0] + "_" + id + "@webler.hu";

                    while (emailList.contains(newEmailAdress)) {

                        id++;
                        newEmailAdress = emailSplit[0] + "_" + id + "@webler.hu";

                }

                emailList.add(newEmailAdress);

            }
                    
                

            }


        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }

        return emailList;

    }

}
