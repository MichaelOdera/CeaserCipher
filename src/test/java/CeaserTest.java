import org.junit.*;
import static org.junit.Assert.*;




public class CeaserTest {

    //create  test for an empty statement
    @Test
    public void doNotEncrypt_EmptyString(){
        Ceaser ceaser = new Ceaser();
        assertEquals(" ", ceaser.ceaserEncryptor(" ", 12));

    }

    //Create test for symbols not to be changed
    @Test
    public void doNotEncrypt_Symbols(){
        Ceaser ceaser = new Ceaser();
        assertEquals("-", ceaser.ceaserEncryptor("-", 21));
        assertEquals("!", ceaser.ceaserEncryptor("!", 17));
        assertEquals("&", ceaser.ceaserEncryptor("&", 20));
        assertEquals(".", ceaser.ceaserEncryptor(".", 24));
        String remainingSymbols = "@$^*()#%";
        assertEquals(remainingSymbols, ceaser.ceaserEncryptor(remainingSymbols, 4));
    }


    //create a test to check for the lower case letters
    @Test
    public void encryptSingleLowerCaseLetters(){
        Ceaser ceaser = new Ceaser();
        assertEquals("b", ceaser.ceaserEncryptor("b", 0));
        assertEquals("b", ceaser.ceaserEncryptor("a", 1));
        assertEquals("k", ceaser.ceaserEncryptor("i", 2));
    }

    //create test for the uppercase letters
    @Test
    public void encryptSingleUpperCaseLetters(){
        Ceaser ceaser = new Ceaser();
        assertEquals("X", ceaser.ceaserEncryptor("U", 3));
        //Check for the end of the cycle at Z
        assertEquals("C", ceaser.ceaserEncryptor("Z", 3));
        assertEquals("R", ceaser.ceaserEncryptor("M", 5));
    }

    //Check for the encryption of whole statements
    @Test
    public void encryptWholeLowerCaseWords(){
        Ceaser ceaser = new Ceaser();
        assertEquals("eager", ceaser.ceaserEncryptor("eager", 0));
        //Check for all the letters in the english alphabet in lower case
        String lowerCaseAllLetters = "the quick brown fox jumped over the lazy dogs";
        assertEquals(lowerCaseAllLetters, ceaser.ceaserEncryptor(lowerCaseAllLetters, 0));
        //Check for the shift by 23
        assertEquals("qeb nrfzh yoltk clu grjmba lsbo qeb ixwv aldp", ceaser.ceaserEncryptor(lowerCaseAllLetters, 23));
    }

    //Check for upper case whole sentences
    @Test
    public void encryptWholeUpperCaseWords(){
        Ceaser ceaser = new Ceaser();
        assertEquals("BEAVER", ceaser.ceaserEncryptor("BEAVER", 0));
        //Check for all the uppercase letters
        String upperCaseAllLetters = "THE QUICK BROWN FOX JUMPED OVER THE LAZY DOGS";
        assertEquals("QEB NRFZH YOLTK CLU GRJMBA LSBO QEB IXWV ALDP", ceaser.ceaserEncryptor(upperCaseAllLetters, 23));

    }

    //allow for decryption
    @Test
    public  void decryptEnteredEncryptedWords(){
        Ceaser ceaser = new Ceaser();
        String reverseStatementSample = "reverse";
        assertEquals("sfwfstf", ceaser.ceaserEncryptor(reverseStatementSample, 1));
        assertEquals(reverseStatementSample, ceaser.ceaserEncryptor("sfwfstf", -1));

    }


    //Check if the input statement can be retrieved
    @Test
    public void checkIfGetsSameSubmittedStatement(){
        Ceaser ceaser = new Ceaser();
        String checkStatement = ceaser.ceaserEncryptor("potter", 0);
        assertEquals(checkStatement , ceaser.getSubmittedStatement());
    }

    //Check if gets key entered
    @Test
    public void checkIfGetsEnteredKey(){
        Ceaser ceaser = new Ceaser();
        int result = 1;
        ceaser.ceaserEncryptor("power", 1);
        assertEquals(result, ceaser.getShiftBy());
    }



}