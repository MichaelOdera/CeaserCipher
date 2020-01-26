import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CeaserTest {

    //create  test for an empty statement
    @Test
    public void doNotEncrypt_EmptyString(){
        Ceaser ceaser = new Ceaser();
        assertEquals(" ", ceaser.getChangedStatement(" ", 23));

    }

    //Create test for symbols not to be changed
    @Test
    public void doNotEncrypt_Symbols(){
        Ceaser ceaser = new Ceaser();
        assertEquals("-", ceaser.getChangedStatement("-", 21));
        assertEquals("!", ceaser.getChangedStatement("!", 17));
        assertEquals("&", ceaser.getChangedStatement("&", 20));
        assertEquals(".", ceaser.getChangedStatement(".", 24));
        String remainingSymbols = "@$^*()#%";
        assertEquals(remainingSymbols, ceaser.getChangedStatement(remainingSymbols, 4));
    }

}