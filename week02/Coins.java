package week02;
import java.util.*;

/**
 * A class used to toss the coin and calculate the data.
 * @author hgao
 *
 */
public class Coins{
    /**
     * A static variables used to represent the HEADS value easily.
     * 
     * THE AUDIT SAYS LINE 10 CONTAINS TAB CHAR.
     * BUT IT SHOULD HAVE THIS TAB TO FORMAT THE CODES, RIGHT?
     * 
     * THE AUDIT SAYS LINE 21 IS WRONG SINCE THE INDETATION LEVEL
     * I'VE CHECK IT UP JUST ONE TAB, DO NOT THINK IT IS WRONG.
     * @author hgao
     *
     */
    public static final boolean HEADS = true;

    /**
     * A static variables used to represent the TAILS value easily.
     * @author hgao
     *
     */
    public static final boolean TAILS = false;

    /**
     * An instance variable used to store the result of coin toss.
     * @author hgao
     *
     */
    private boolean[] coins;

    /**
     * Constructor: using a boolean as its parameter.
     * @param coins the results of coin toss
     * @author hgao
     *
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /**
     * Constructor: using a string as its parameter.
     * @param c the results of coin toss
     * @author hgao
     *
     */
    public Coins(String c) {
        this.coins = new boolean[c.length()];

        for (int i=0; i < c.length(); i++){
            char s = c.charAt(i);
            coins[i] = ( s=='H') ? HEADS : TAILS;
        }
    }

    /**
     * Constructor: using an int as its parameter.
     * @param length it is the length of the instance variable
     *
     */
    public Coins(int length){
        this.coins = new boolean[length];
        for (int i=0; i < this.coins.length; i++){
            Random r = new Random();
            int coinToss = r.nextInt(2-1+1)+1;
            this.coins[i] = coinToss==1 ? HEADS : TAILS;
        }
    }

    /**
     * Count how many runs are there in a toss series.
     * @return the exact number of count
     * @author hgao
     *
     */
    public int countRuns(){
        String s = this.toString();
        char lastChar='X';
        int countRun=0;
        for (char c: s.toCharArray()){
            if (c != lastChar){
                countRun += 1;
            }
            lastChar = c;
        }
        return countRun;
    }

    /**
     * Count how many heads are there in a toss series.
     * @return the exact number of count
     * @author hgao
     *
     */
    public int countHeads(){
        int count=0;

        for (boolean s : this.coins){
            if (s == HEADS){
                count++;
            }
        }
        return count;
    }
    
    /**
     * Override the default toString method to fullfil the requirements.
     * @return output the string result
     * @author hgao
     *
     */    
    @Override
    public String toString(){

        String output = new String();

        for (boolean s : coins){
            if (s == HEADS){
                output+='H';
            } else if(s==TAILS){
                output+='T';
            }
        }
        return output;
    }

    /**
     * Doing some tests here to make sure our methods runs correctly.
     * @param args default parameter, to get the input from command-line 
     * @author hgao
     *
     */
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};

        Coins c = new Coins(b);
        System.out.println("count heads: " + c.countHeads());
        System.out.println("count runs: " + c.countRuns());

//      Coins c1 = new Coins("HHHTTTHHH");
//      Coins c2 = new Coins(40);
//
//      System.out.println("string constructor: " + c1.toString());
//      System.out.println("int constructor: " + c2.toString());  
    }
}
