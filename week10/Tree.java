package week10;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 *
 * @param <T> The type of values stored in the tree.
 * @author Michael Albert
 */
public class Tree<T> {
    /**
     * the root value.
     */
    private T rootValue;
    /**
     * the children of the tree.
     */
    private List<Tree<T>> children;

    /**
     * constructor.
     *
     * @param rootValue the root value
     * @param children  the children of the tree
     */
    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    /**
     * overload version of constructor.
     *
     * @param rootValue the root value
     */
    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }

    /**
     * compute the size of the tree.
     *
     * @return the number of the size
     */
    public int size() {
        return 1 + size(0);
    }

    /**
     * the helper method of size().
     *
     * @param result the result from each recursion
     * @return the final value
     */
    private int size(int result) {
        if (children != null) {
            result += children.size();
            for (Tree<T> t : children) {
                result += t.size(0);
            }
        }
        return result;
    }

    /**
     * the max counts of one of node.
     *
     * @return the result
     */
    public int maxDegree() {
        int degree = this.children.size();
        for (int i = 0; i < this.children.size(); i++) {
            if (this.children.get(i).maxDegree() > degree) {
                degree = this.children.get(i).maxDegree();
            }
        }
        return degree;
    }

    /**
     * add node.
     *
     * @param child the subtree need to add
     */
    public void add(Tree<T> child) {
        children.add(child);
    }

    /**
     * find some value in the tree.
     *
     * @param value the value need to find
     * @return the tree contains the value
     */
    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }

    /**
     * travel the tree use postOrder.
     *
     * @return the result
     */
    public List<T> postOrder() {
        ArrayList<T> nodes = new ArrayList<>();
        if (this.children.size() == 0) {
            nodes.add(this.rootValue);
        } else {
            for (int i = 0; i < this.children.size(); i++) {
                nodes.addAll(this.children.get(i).postOrder());
            }
            nodes.add(this.rootValue);
        }
        return nodes;
    }

    /**
     * overload version of default toString().
     *
     * @return the result
     */
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }

    /**
     * generate a string which use indent to show the tree.
     *
     * @return the result
     */
    public String toIndentedString() {
        StringBuilder finalString = new StringBuilder();
        LinkedList<String> orderList = new LinkedList<>();
        iHelper(0, orderList, children);
        finalString.append(levelToIndent(0) + rootValue + "\n");
        for (String s : orderList) {
            finalString.append(s);
        }
        return finalString.toString();
    }

    /**
     * the helper method of toIndentedString.
     *
     * @param lvl   the level that each node on
     * @param ilist each string will store in this list
     * @param kid   subtree
     */
    private void iHelper(int lvl, LinkedList<String> ilist, List<Tree<T>> kid) {
        if (kid != null) {
            lvl++;
            for (Tree<T> t : kid) {
                ilist.add(levelToIndent(lvl) + t.rootValue.toString() + "\n");
                if (t.children != null) {
                    iHelper(lvl, ilist, t.children);
                }
            }
        }
    }

    /**
     * convert level to spaces.
     *
     * @param level the level that the node on
     * @return the computed spaces
     */
    private String levelToIndent(int level) {
        String value = "";
        for (int i = 0; i < level; i++) {
            value += "  ";
        }
        return value;
    }

    /**
     * A helper method for testing (used by main).  Searches tree for
     * the given target and adds white space separated children to
     * the tree matching target if there is one.
     *
     * @param target   the root value to seach for.
     * @param children a white space separated list of children to add
     *                 to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /**
     * A tree instance used for testing.
     */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
