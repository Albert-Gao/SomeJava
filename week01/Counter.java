/**
 * A class used to calculate the number of words and lines in a user's input.
 * The input is cached by java.util.Scanner;
 *
 * Procedure:
 * 1. read the input using Scanner;
 * 2. fecth the first line;
 * 3. loop the 1st line, count the words in it by accumulating "wordCount";
 * 4. when the loop above is end, accumulate "lineCount" to count the lines;
 * 5. loop the rest of lines if there is any till the end;
 * 6. print the results on the screen;
 *
 * Note:
 * The user can end their input with a line start with ctrl+D
 *
 * @author Haoyang Gao
 */
package week01;
import java.util.Scanner;

/**
 * A class used to calculate the number of words and lines in a user's input.
 * The input is cached by java.util.Scanner;
 * @author Haoyang Gao
 */
public class Counter {

   /**
    * To save the number of words as a class variable to use across the class.
    */
    private static int wordCount = 0;
    
   /**
    * To save the number of lines as a class variable to use across the class.
    */
    private static int lineCount = 0;

   /**
    * The main method used to construct the whole logic.
    * The comments below is well-explained the procedures here in main() method.
    * @param args follow the regular rules of java. 
    * @author Haoyang Gao
    */
    public static void main(String[] args) {

        //Step1: get the user input
        Scanner userinput = new Scanner(System.in);

        //Step2: count the words and lines inside the input
        countThemAll(userinput);

        //Step3: show the result
        showResults();
    }

   /**
    * The countThemAll method used to count the words and lines.
    * The comments below is well-explained the procedures here in this method.
    * @param userinput get the inputStream and manipulate it
    * @author Haoyang Gao
    */    
    private static void countThemAll(Scanner userinput){
        //loop by lines until hits the end of the userinput
        while(userinput.hasNextLine()){
            //fetch the current line
            Scanner currentLineScanner = new Scanner(userinput.nextLine());
            
            //loop the line to count the words
            while(currentLineScanner.hasNext()){
                //count the words
                wordCount++;
                
                //loop to the next word in order to move through the paragraph
                currentLineScanner.next();
            }
            currentLineScanner.close();

            //count the lines
            lineCount++;
        }
        userinput.close();
    }

   /**
    * The showResults method used to show the final results.
    * @author Haoyang Gao
    */  
    private static void showResults(){
        System.out.println("lines: " + lineCount);
        System.out.println("words: " + wordCount);
    }
}
