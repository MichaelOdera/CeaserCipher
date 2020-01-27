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
                //Function to encrypt
                if(choice.equals("1")){
                    Ceaser ceaser = new Ceaser();
                    System.out.println("Enter the statement that you would like to encrypt");
                    String textToBeEncrypted = bufferedReader.readLine();
                    System.out.println("Enter the key the you wish to encrypt with: (between 1 to 25)");
                    int userKeyToEncrypt = Integer.parseInt(bufferedReader.readLine());
                    ceaser.ceaserEncryptor(textToBeEncrypted, userKeyToEncrypt);


                    System.out.println("Here are your results:");
                    System.out.println("Key: "+ ceaser.getShiftBy());
                    System.out.println("Your Statement: "+ ceaser.getSubmittedStatement());
                    System.out.println("Encryption: " + ceaser.ceaserEncryptor(textToBeEncrypted, userKeyToEncrypt));
                    System.out.println("Enter 'YES' to continue with encryption or 'NO' to exit");
                    String goOn = bufferedReader.readLine();
                    if(goOn.equals("YES")){
                        programRunning = true;
                    }else if(goOn.equals("NO")){
                        programRunning = false;
                    }else{
                        System.out.println("You are exited out of the program due to an invalid input");
                        programRunning = false;
                    }


                //Function to decrypt
                }else if(choice.equals("2")){
                    Ceaser ceaser = new Ceaser();
                    System.out.println("Enter the statement that you would like to be decrypted");
                    String textToBeDecrypted = bufferedReader.readLine();
                    System.out.println("Enter the key it was decrypted with: (between 1 to 25)");
                    int userKeyToDecrypt = Integer.parseInt(bufferedReader.readLine());
                    ceaser.ceaserEncryptor(textToBeDecrypted, -userKeyToDecrypt);

                    System.out.println("Here are your results:");
                    System.out.println("DecryptionKey: "+ ceaser.getShiftBy());
                    System.out.println("Your Statement: "+ ceaser.getSubmittedStatement());
                    System.out.println("Decryption: " + ceaser.ceaserEncryptor(textToBeDecrypted, -(userKeyToDecrypt)));

                    System.out.println("Enter 'YES' to continue with encryption or 'NO' to exit");
                    String goOn = bufferedReader.readLine();
                    if(goOn.equals("YES")){
                        programRunning = true;
                    }else if(goOn.equals("NO")){
                        programRunning = false;
                    }else{
                        System.out.println("You are exited out of the program due to an invalid input");
                        programRunning = false;
                    }

                 //Check if the input entered is part of what is required
                }else{
                    System.out.println("You have entered an invalid choice!");
                    programRunning = false;
                }


             //Check if there is an error and reply accordingly
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

