package week05;

import java.util.ArrayList;
import java.util.Collections;

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
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i].length < t[i + 1].length) {
                return false;
            }
        }
        return true;
    }

    /**
     * check if the items in row is increasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean rowValuesIncrease(int[][] t) {
        //checking them row by row, with each row, value by value
        boolean foundError = true;
        myLoop:
        for (int[] row : t) {
            for (int i = 1; i < row.length; i++) {
                foundError = row[i - 1] > row[i] ? true : false;
                if (foundError) {
                    break myLoop;
                }
            }
        }
        return !foundError;
    }

    /**
     * check if the items in column is increasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean columnValuesIncrease(int[][] t) {
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = 0; j < Math.min(t[i].length, t[i + 1].length); j++) {
                if (t[i][j] > t[i + 1][j])
                    return false;
            }
        }
        return true;
    }

    /**
     * check if the set is 1toN.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean isSetOf1toN(int[][] t) {
        //extract all the values from the 2d array
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int[] row : t) {
            for (int value : row) {
                tempList.add(value);
            }
        }

        //Sort the list
        Collections.sort(tempList);

        boolean mark = true;

        //check if the value is increasing;
        for (int i = 1; i < tempList.size(); i++) {
            int result = tempList.get(i) - tempList.get(i - 1);
            mark = result == 1 ? true : false;
            if (!mark) {
                break;
            }
        }
        return mark;
    }
}
