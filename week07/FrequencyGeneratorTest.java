package week07;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import java.util.*;

@Test
public class FrequencyGeneratorTest {

    public void singleWord() {
        WordGenerator wg = new FrequencyGenerator(new Random(241));
        assertEquals(wg.nextWord(10), "retserecod");
    }

    public void singleWordLengthTwenty() {
        WordGenerator wg = new FrequencyGenerator(new Random(241));
        assertEquals(wg.nextWord(20), "retserecodmtefsaaoup");
    }

    public void seedNine() {
        WordGenerator wg = new FrequencyGenerator(new Random(9));
        assertEquals(wg.nextWord(10), "rssnuhnnlt");
    }
    
    public void seedNineFiveWords() {
        WordGenerator wg = new FrequencyGenerator(new Random(9));
        assertEquals(wg.nextWord(10), "rssnuhnnlt");
        assertEquals(wg.nextWord(10), "hbkhoecica");
        assertEquals(wg.nextWord(10), "ghatdncrce");
        assertEquals(wg.nextWord(10), "sthftteitb");
        assertEquals(wg.nextWord(10), "cectnaagpd");
    }

}
