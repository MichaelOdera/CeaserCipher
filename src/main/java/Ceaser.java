import java.lang.String;

import static java.lang.Character.*;

public class Ceaser {
    private String statement;
    private int shiftBy;
    private static int lengthOfAlphabet;

    //Create a constructor to define the properties of ceaserEncryptor
    public String ceaserEncryptor(String statement, int  shiftBy){
        this.statement = statement;
        this.shiftBy = shiftBy;
        this.lengthOfAlphabet = 26;
        //Call function to execute change
        return getChangedStatement(this.statement, this.shiftBy);
    }


    //create a function to return a string after shifting of statements
    public String getChangedStatement(String statement, int shiftBy){
        //Transform the string to an array
        char[] statementChars = statement.toCharArray();
        //Call function to execute the change for the whole string
        shiftAlphabets(statementChars, this.shiftBy);
        return new String(statementChars);
    }

    //Create a function to shift the alphabets according to the shift key provided
    private void shiftAlphabets(char[] statementChars, int shiftBy) {
        for(int index = 0; index<statementChars.length; ++index){
            //Check if the character is lower case and then change appropriately
            if(isLowerCase(statementChars[index])){
                statementChars[index] = shiftByCharacter(statementChars[index], shiftBy, 'a', 'z');
            }else if(isUpperCase(statementChars[index])){
                //Check for uppercase letters and commit change
                statementChars[index] = shiftByCharacter(statementChars[index], shiftBy, 'A', 'Z');
            }
            //else if(isWhitespace(statementChars[index])){
//                //Check for a space in between the words
//                statementChars[index] = shiftByCharacter(statementChars[index], shiftBy, ' ', ' ');
//            }
        }
    }



    //The interchange of characters depending on the length of alphabetical letters
    private char shiftByCharacter(char individualCharacter, int shiftBy, char firstLetter, char lastLetter) {
        individualCharacter += shiftBy;
        if(individualCharacter < firstLetter){
            return (char)(individualCharacter + lengthOfAlphabet);
        }
        if(individualCharacter > lastLetter){
            return  (char)(individualCharacter - lengthOfAlphabet);
        }
        if(individualCharacter == ' '){
            return (' ');
        }
        return  individualCharacter;

    }


    //Create a getter to obtain the entered statement
    public String getSubmittedStatement(){
        return this.statement;
    }


    //create a getter to obtain the amount of shiftBy integer desired
    public int getShiftBy(){
        return this.shiftBy;
    }



}
