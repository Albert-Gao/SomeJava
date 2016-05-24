package week03;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TowerTest {
    
    private static Tower t;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        t = new Tower().add('A').add('B').add('C').add('B').add('C');
    }

    @Test
    public void height() {
        assertEquals(t.height(), 5);
    }
    
    @Test
    public void emptyHeight() {
        assertEquals(new Tower().height(), 0);
    }
    
    @Test
    public void count() {
        assertEquals(t.count('C'), 2);
    }
    
    @Test
    public void countNone() {
        assertEquals(t.count('Z'), 0);
    }
    
    @Test
    public void countAll() {
        assertEquals(new Tower().add('B').add('B').count('B'), 2);
    }
    
//    @Test
//    public void towerToString() {
//        assertEquals(t.toString(), "[C]\n[B]\n[C]\n[B]\n[A]");
//    }
}
