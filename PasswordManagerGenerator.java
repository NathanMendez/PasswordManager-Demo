import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PasswordManagerGenerator {
    public static String generate(int code,int length){
        String password = "";

        for (int i = 0; i < length; i++) {

            Random r = new Random();

            if(code == 0){
                password = password + (char)(r.nextInt(26)+'a');
            }

            else if(code == 1){
                int choice = ThreadLocalRandom.current().nextInt(0,2);

                if(choice==0 ){
                    password = password + (char)(r.nextInt(26)+'a');
                }

                else {
                    password = password + ThreadLocalRandom.current().nextInt(0, 10);
                }
            }
        }
        return password;
    }

}
