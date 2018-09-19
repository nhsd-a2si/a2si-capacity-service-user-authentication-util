package net.nhs.a2si.cd.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Random;

public class App
{
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DEMARCATION = "------------------------------------------------------------------------------------------------------------------------------------------";


    public static void main( String[] args )
    {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String username = App.randomStringWithFixedSizeOf(40);
        final String password = App.randomStringWithFixedSizeOf(60);
        final String saltedPassword = passwordEncoder.encode(username);

        System.out.println();
        System.out.println();
        System.out.println( "Capacity API basic authentication keys generator." );
        System.out.println();
        System.out.println("Issue these keys to the client");
        System.out.println(DEMARCATION);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println(DEMARCATION);

        System.out.println();
        System.out.println("Store these values in the authentication database.");

        System.out.println(DEMARCATION);
        System.out.println("DO NOT ISSUE THE 'SALTED_PASSWORD' TO THE CLIENT!");
        System.out.println();
        System.out.println("USERNAME: " + username);
        System.out.println("SALTED_PASSWORD: " + saltedPassword);
        System.out.println("CLIENT_NAME: <name of client>");
        System.out.println(DEMARCATION);


    }


    public static int zeroBasedRandomNumber(int i) {
        return new Random().nextInt(i+1);
    }

    public static String randomStringWithFixedSizeOf(int l) {
        String result = "";
        for(int i = 0; i < l; i++){
            switch(Type.random()){
                case NUMBER:
                    result += App.zeroBasedRandomNumber(9);
                    break;
                case UPPER_LETTER:
                    result += randomAlpha();
                    break;
                case LOWER_LETTER:
                    result += Character.toLowerCase(randomAlpha());
                    break;
            }
        }
        return result;
    }

    private static char randomAlpha() {
        return App.ALPHABET.charAt(App.zeroBasedRandomNumber(25));
    }

    public enum Type {
        NUMBER, UPPER_LETTER, LOWER_LETTER;
        public static Type random(){
            return App.Type.values()[App.zeroBasedRandomNumber(Type.values().length-1)];
        }
    }
}
