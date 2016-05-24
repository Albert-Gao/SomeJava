package week10;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TreeTest {

    private Tree<String> rootTree, meatTree ;

    @BeforeMethod
    public void setUp() {
        rootTree = new Tree<>("food");
        meatTree = new Tree<>("meat");
    }

    @Test
    public void sizeOne() {
        assertEquals(rootTree.size(), 1);
    }

    @Test
    public void addChild() {
        rootTree.add(new Tree<String>("meat"));
        assertEquals(rootTree.toString(), "food [meat]");
    }

    @Test
    public void addChildren() {
        rootTree.add(meatTree);
        addChildren(rootTree, "fruit vegetable");
        assertEquals(rootTree.toString(), "food [meat, fruit, vegetable]");
    }
    @Test
    public void addDeepChildren() {
        rootTree.add(meatTree);
        addChildren(rootTree, "fruit vegetable");
        meatTree.add(treeWithChildren("fish", "salmon cod tuna shark"));
        assertEquals(rootTree.toString(), "food [meat [fish [salmon, cod, " +
                "tuna, shark]], fruit, vegetable]");
    }

    private Tree<String> treeWithChildren(String name, String children) {
        Tree<String> tree = new Tree<>(name);
        return addChildren(tree, children);
    }

    private Tree<String> addChildren(Tree<String> tree, String children) {
        for (String child : children.split(" ")) {
            tree.add(new Tree<>(child));
        }
        return tree;
    }

    @Test(dependsOnMethods = {"addDeepChildren"})
    public void size() {
        addDeepChildren();
        assertEquals(rootTree.size(), 9);
    }

    @Test(dependsOnMethods = {"addDeepChildren"})
    public void maxDegree() {
        addDeepChildren();
        assertEquals(rootTree.maxDegree(), 4);
    }

    @Test(dependsOnMethods = {"addDeepChildren"})
    public void postOrder() {
        addDeepChildren();
        assertEquals(rootTree.postOrder().toString(), "[salmon, cod, tuna, " +
                "shark, fish, meat, fruit, vegetable, food]");
    }

    @Test
    public void indentedString() {
        addDeepChildren();
        assertEquals('\n' + rootTree.toIndentedString(), "\nfood\n  meat\n    " +
                "fish\n      salmon\n      cod\n      tuna\n      " +
                "shark\n  fruit\n  vegetable\n");
    }

}
