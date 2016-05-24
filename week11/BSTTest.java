package week11;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class BSTTest {

    private LinkedBST<String> tree;
    private String[] eg = {"dew", "bin", "add", "aka", "boa", "cod", "fun",
                           "fab", "ear", "dog", "eye", "fee", "zoo"};
    
    @BeforeMethod
    public void setUp() {
        tree = new LinkedBST<>();
        for (String s : eg) {
            tree.add(s);
        }
    }

    public void heightEmpty() {
        assertEquals(new LinkedBST<String>().height(), 0);
    }

    public void heightLarger() {
        assertEquals(tree.height(), 4);
    }

    public void searchEmpty() {
        assertEquals(new LinkedBST<String>().search("zoo"), false);
    }

    public void searchPresent() {
        assertEquals(tree.search("aka"), true, "search 'aka'");
        assertEquals(tree.search("ear"), true, "search 'ear'");
        assertEquals(tree.search("zoo"), true, "search 'zoo'");
    }

    public void searchAbsent() {
        assertEquals(tree.search("all"), false, "search 'all'");
        assertEquals(tree.search("zebra"), false, "search 'zebra'");
    }

    public void sizeEmpty() {
        assertEquals(new LinkedBST<String>().size(), 0);
    }

    public void sizeLarger() {
        assertEquals(tree.size(), 13);
    }

    public void sizeAboveEmpty() {
        assertEquals(new LinkedBST<String>().sizeAbove("aka"), 0);
    }
    
    public void sizeAboveAll() {
        assertEquals(tree.sizeAbove("a"), 13, "sizeAbove(a)");
    }

    public void sizeAboveNone() {
        assertEquals(tree.sizeAbove("zzz"), 0, "sizeAbove(zzz)");
    }

    public void sizeAboveExample() {
        assertEquals(tree.sizeAbove("all"), 11, "sizeAbove(all)");
    }

    public void sizeBelowEmpty() {
        assertEquals(new LinkedBST<String>().sizeBelow("aka"), 0);
    }
    
    public void sizeBelowAll() {
        assertEquals(tree.sizeBelow("zzz"), 13, "sizeBelow(zzz)");
    }

    public void sizeBelowNone() {
        assertEquals(tree.sizeBelow("a"), 0, "sizeBelow(a)");
    }

    public void sizeBelowExample() {
        assertEquals(tree.sizeBelow("fee"), 10, "sizeBelow(fee)");
    }

    public void sizeBetweenEmpty() {
        assertEquals(new LinkedBST<String>().sizeBetween("aka", "fee"), 0);
    }
    
    public void sizeBetweenAll() {
        assertEquals(tree.sizeBetween("a", "zzz"), 13, "sizeBetween(a,zzz)");
    }

    public void sizeBetweenNone() {
        assertEquals(tree.sizeBetween("gun", "hun"), 0, "sizeBetween(gun,hun)");
    }

    public void sizeBetweenExample() {
        assertEquals(tree.sizeBetween("all", "fee"), 8, "sizeBetween(all,fee)");
    }
}
