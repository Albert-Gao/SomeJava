package week07;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Frequency Generator.
 * @author Haoyang Gao
 */
public class DigramGenerator implements WordGenerator {
    /**
     * property of random.
     */
    private Random rn;

    /**
     * following letters.
     */
    private List<String> following;

    /**
     * first letters.
     */
    private String firstletter;

    /**
     * constructor.
     * @param r random seed.
     */
    public DigramGenerator(Random r) {
        rn = r;

        //store the following when declaring the instance
        List<String> follow = new ArrayList<>();
        String fileName = "continuations.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((string) -> {
                    follow.add(string);
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.following = follow;

        //store the first letters
        String s = new String();
        String fileName1 = "first-letters.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                s = sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.firstletter = s;
    }

    /**
     * create the new word.
     * @param n the length of the word.
     * @return the new word.
     */
    public String nextWord(int n) {
        char firstChar = readFirstLetter();
        char nextChar = nextChar(firstChar);
        return newWord(String.valueOf(firstChar), nextChar, n);
    }

    /**
     * choose the index.
     * @param ok the already-done of the word
     * @param next next char
     * @param length the length of the word
     * @return the next part of the word.
     */ 
    private String newWord(String ok, char next, int length){
        String newWords = ok + next;
        if (newWords.length() == length){
            return newWords;
        }
        return newWord( newWords, nextChar(next), length );
    }

    /**
     * choose the first letter.
     * @return the new int of new char.
     */ 
    private char readFirstLetter(){
        int randomNumber = this.rn.nextInt(firstletter.length());
        return this.firstletter.charAt(randomNumber);
    }

    /**
     * choose the index.
     * @param input the char.
     * @return the new int of new char.
     */ 
    private char nextChar(char input){
        String s = this.following.get(input-'a');
        int randomNumber = this.rn.nextInt(s.length());
        return s.charAt(randomNumber);
    }
}
