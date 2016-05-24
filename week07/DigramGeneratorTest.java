package week07;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import java.util.*;

@Test
public class DigramGeneratorTest {

    public void singleWord() {
        WordGenerator wg = new DigramGenerator(new Random(241));
        assertEquals(wg.nextWord(10), "seroteraus");
    }

    public void singleWordLengthTwenty() {
        WordGenerator wg = new DigramGenerator(new Random(241));
        assertEquals(wg.nextWord(20), "seroterausouisckenor");
    }

    public void seedNine() {
        WordGenerator wg = new DigramGenerator(new Random(9));
        assertEquals(wg.nextWord(10), "kiabrypeay");
    }
    
    public void seedNineFiveWords() {
        WordGenerator wg = new DigramGenerator(new Random(9));
        assertEquals(wg.nextWord(10), "kiabrypeay");
        assertEquals(wg.nextWord(10), "umeschonci");
        assertEquals(wg.nextWord(10), "alylinthon");
        assertEquals(wg.nextWord(10), "nerunonead");
        assertEquals(wg.nextWord(10), "celioshool");
    }

}
