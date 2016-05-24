package week02;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class CoinTestNG {
    
    private static Coins true3;
    private static Coins false4;
    private static Coins mixture;

    @BeforeClass
    public static void setUpClass() throws Exception {
        boolean[] t3 = { true, true, true };
        true3 = new Coins(t3);
        boolean[] f4 = { false, false, false, false };
        false4 = new Coins(f4);
        boolean[] mix = { true, true, false, false, true, false, true };
        mixture = new Coins(mix);
    }
    
    public void countHeads_multi() {
        assertEquals(mixture.countHeads(), 4);
    }

    public void countHeads_allHeads() {
        assertEquals(true3.countHeads(), 3);
    }

    public void countHeads_allTails() {
        assertEquals(false4.countHeads(), 0);
    }
    
    public void toString_allTails() {
        assertEquals(false4.toString(), "TTTT");
    }
    
    public void toString_multi() {
        assertEquals(mixture.toString(), "HHTTHTH");
    }
    
    public void toString_allHeads() {
        assertEquals(true3.toString(), "HHH");
    }
    
    public void constructor_string() {
        Coins c = new Coins("HHTTHTH");
        assertEquals(c.toString(), mixture.toString());
    }
    
    public void constructor_length() {
        assertEquals(new Coins(5).toString().length(), 5);
    }
    
    public void countRuns_one() {
        assertEquals(false4.countRuns(), 1);
        assertEquals(true3.countRuns(), 1);
    }
    
    public void countRuns_multi() {
        assertEquals(mixture.countRuns(), 5);
    }
    
}
