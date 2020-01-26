import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App{
    public static void main(String[] args) {
        boolean programRunning = true;

        while(programRunning){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Welcome to the Ceaser Cipher Application");
            System.out.println("Enter '1' to Encrypt or '2' to decrypt");

            try {
                String choice = bufferedReader.readLine();
                if(choice.equals("1")){
                    Ceaser ceaser = new Ceaser();
                    System.out.println("Enter the statement that you would like to encrypt");
                    String textToBeEncrypted = bufferedReader.readLine();
                    System.out.println("Enter the key the you wish to encrypt with: (between 1 to 25)");
                    int userKeyToEncrypt = Integer.parseInt(bufferedReader.readLine());

                    System.out.println("Here are your results:");
                    System.out.println("Key: "+ ceaser.getShiftBy());
                    System.out.println("Your Statement: "+ ceaser.getSubmittedStatement());
                    System.out.println("Encryption: " + ceaser.ceaserEncryptor(textToBeEncrypted, userKeyToEncrypt));


                }else if(choice.equals("2")){
                    Ceaser ceaser = new Ceaser();
                    System.out.println("Enter the statement that you would like to be decrypted");
                    String textToBeDecrypted = bufferedReader.readLine();
                    System.out.println("Enter the key the you wish to decrypt with: (between 1 to 25)");
                    int userKeyToDecrypt = Integer.parseInt(bufferedReader.readLine());

                    System.out.println("Here are your results:");
                    System.out.println("Key: "+ ceaser.getShiftBy());
                    System.out.println("Your Statement: "+ ceaser.getSubmittedStatement());
                    System.out.println("Encryption: " + ceaser.ceaserEncryptor(textToBeDecrypted, -userKeyToDecrypt));

                 //Check if the input entered is part of what is required
                }else{
                    System.out.println("You have entered an invalid choice");
                    programRunning = false;
                }


             //Check if there is an error and reply accordingly
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

