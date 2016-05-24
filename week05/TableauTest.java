package week05;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import java.util.Arrays;

@Test
public class TableauTest {

    private int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
    private int[][] badRowLengths = {{1, 4, 5, 8, 10, 11}, {2, 6}, {3, 9, 12}, {7}};
    private int[][] badRowValues = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 12, 9}, {7}};
    private int[][] badColumnValues = {{1, 4, 5, 8, 11}, {2, 6, 12}, {3, 9, 10}, {7}};
    private int[][] notSetDup = {{1, 4, 5, 10, 12}, {2, 5, 8}, {3, 9, 12}, {7}};
    private int[][] notSetSkip = {{1, 4, 5, 10, 13}, {2, 6, 8}, {3, 9, 12}, {7}};
    
    public void isTableau() {
        assertEquals(TableauApp.isTableau(badRowLengths), false,
                     Arrays.deepToString(badRowLengths));
        assertEquals(TableauApp.isTableau(badRowValues), false,
                     Arrays.deepToString(badRowValues));
        assertEquals(TableauApp.isTableau(badColumnValues), false,
                     Arrays.deepToString(badColumnValues));
        assertEquals(TableauApp.isTableau(notSetDup), false,
                     Arrays.deepToString(notSetDup));
        assertEquals(TableauApp.isTableau(notSetSkip), false,
                     Arrays.deepToString(notSetSkip));
        assertEquals(TableauApp.isTableau(valid), true,
                     Arrays.deepToString(valid));
    }

    public void rowLengthsDecrease() {
        assertEquals(TableauApp.rowLengthsDecrease(badRowLengths), false,
                     Arrays.deepToString(badRowLengths));
        assertEquals(TableauApp.rowLengthsDecrease(valid), true,
                     Arrays.deepToString(valid));
    }

    public void rowValuesIncrease() {
        assertEquals(TableauApp.rowValuesIncrease(badRowValues), false,
                     Arrays.deepToString(badRowValues));
        assertEquals(TableauApp.rowValuesIncrease(valid), true,
                     Arrays.deepToString(valid));
    }

    public void columnValuesIncrease() {
        assertEquals(TableauApp.columnValuesIncrease(badColumnValues), false,
                     Arrays.deepToString(badColumnValues));
        assertEquals(TableauApp.columnValuesIncrease(valid), true,
                     Arrays.deepToString(valid));
    }

    public void isSetOf1toN() {
        assertEquals(TableauApp.isSetOf1toN(notSetDup), false,
                     Arrays.deepToString(notSetDup));
        assertEquals(TableauApp.isSetOf1toN(notSetSkip), false,
                     Arrays.deepToString(notSetSkip));
        assertEquals(TableauApp.isSetOf1toN(valid), true,
                     Arrays.deepToString(valid));
    }   
}
