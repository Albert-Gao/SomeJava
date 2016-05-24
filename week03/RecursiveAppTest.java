package week03;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

@Test
public class RecursiveAppTest {

    public void digits() {
        long num = 1234567L;
        assertEquals(RecursiveApp.digits(num), 7);
    }
    
    public void sumOfDigits() {
        long num = 123456L;
        assertEquals(RecursiveApp.sumOfDigits(num), 21);
    }
    
    public void sumOfDigitsNegative() {
        long num = -12345678L;
        assertEquals(RecursiveApp.sumOfDigits(num), -36);
    }

}
