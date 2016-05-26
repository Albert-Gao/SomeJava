package week05;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {
    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
         /*int[][] valid = {{1, 4, 5, 10, 11},{2, 6, 8}, {3, 9, 12}, {7}};
         System.out.println(TableauApp.toString(valid));
         System.out.println(TableauApp.rowLengthsDecrease(valid));
         System.out.println(TableauApp.rowValuesIncrease(valid));
         System.out.println(TableauApp.columnValuesIncrease(valid));
         System.out.println(TableauApp.isSetOf1toN(valid));*/
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t) {
        return rowLengthsDecrease(t) & rowValuesIncrease(t) &
                columnValuesIncrease(t) & isSetOf1toN(t);
    }

    /**
     * Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * .
     * check if the length of row is decreasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean rowLengthsDecrease(int[][] t) {

        return true;
    }

    /**
     * check if the items in row is increasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean rowValuesIncrease(int[][] t) {

        return true;
    }

    /**
     * check if the items in column is increasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean columnValuesIncrease(int[][] t) {

        return true;
    }

    /**
     * check if the set is 1toN.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean isSetOf1toN(int[][] t) {
        return true;
    }
}
