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
        //how many rows are there
        int rowCounts = t.length;

        //create an array to store the length of each row
        int[] inRowNum = new int[rowCounts];

        //counting the array row by row and store them in inRowNum []
        for (int i = 0; i < rowCounts; i++) {
            inRowNum[i] = t[i].length;
        }

        //check if they are decreasing
        boolean mark = true;
        myLoop:
        for (int i = 0; i < inRowNum.length; i++) {
            //ensure never out of index
            if (i + 1 < inRowNum.length) {
                mark = inRowNum[i] >= inRowNum[i + 1] ? true : false;
                if (!mark) {
                    break myLoop;
                }
            }
        }
        return mark;
    }

    /**
     * check if the items in row is increasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean rowValuesIncrease(int[][] t) {
        //checking them row by row, with each row, value by value
        boolean mark = true;
        myLoop:
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (j + 1 < t[i].length) {
                    mark = t[i][j] < t[i][j + 1] ? true : false;
                    if (!mark) {
                        break myLoop;
                    }
                }
            }
        }
        return mark;
    }

    /**
     * check if the items in column is increasing.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean columnValuesIncrease(int[][] t) {
        //How many columns are there?
        int columnCounts = t[0].length;
        int rowCounts = t.length;

        //create a rectangle matrix, fill 0 when outIndex
        int[][] addZero = new int[rowCounts][columnCounts];
        for (int row = 0; row < rowCounts; row++) {
            for (int col = 0; col < t[0].length; col++) {
                try {
                    addZero[row][col] = t[row][col];
                } catch (IndexOutOfBoundsException e) {
                    addZero[row][col] = 0;
                }
            }
        }

        //Let's check the damn column!
        boolean mark = true;
        myLoop:
        for (int col = 0; col < columnCounts; col++) {
            for (int row = 0; row < rowCounts; row++) {
                if (row + 1 < rowCounts && col + 1 < columnCounts) {
                    if (addZero[row + 1][col] != 0) {
                        mark = addZero[row][col] <
                                addZero[row + 1][col] ? true : false;
                    }
                }
                if (!mark) {
                    break myLoop;
                }
            }
        }
        return mark;
    }

    /**
     * check if the set is 1toN.
     *
     * @param t a 2D array
     * @return a boolean value
     */
    public static boolean isSetOf1toN(int[][] t) {
        //how many rows are there
        int rowCounts = t.length;

        //counting the all items
        int allItemsCounts = 0;
        for (int i = 0; i < rowCounts; i++) {
            allItemsCounts += t[i].length;
        }

        //extract all the values from the 2d array
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                tempList.add(t[i][j]);
            }
        }

        //Sort the list
        Collections.sort(tempList);

        //get the last value of the list
        int last = tempList.get(tempList.size() - 1);

        //check if it is equal to allItemsCounts;
        boolean mark = last == allItemsCounts ? true : false;

        if (!mark) {
            return mark;
        }

        //check if the value is increasing;
        for (int i = 0; i < tempList.size(); i++) {
            if (i + 1 != tempList.size()) {
                mark = tempList.get(i) != tempList.get(i + 1) ? true : false;
            }
        }

        return mark;
    }
}
