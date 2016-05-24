package week07;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;
import java.io.IOException;

/**
 * Frequency Generator.
 * @author Haoyang Gao
 */
public class FrequencyGenerator implements WordGenerator {
    /**
     * property of random.
     */
    private Random n;

    /**
     * constructor.
     * @param r random seed.
     */
    public FrequencyGenerator(Random r) {
        n = r;
    }
    
    /**
     * create the new word.
     * @param n the length of the word.
     * @return the new word.
     */
    public String nextWord(int n) {
        int[] randomIndex = new int[n];
        for (int i=0; i < n; i++){
            randomIndex[i]=chooseIndex();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<randomIndex.length; i++){
            sb.append((char)('a'+randomIndex[i]));
        }
        
        return sb.toString();
    }

    /**
     * choose the index.
     * @return the new char.
     */  
    private int chooseIndex() {
        List<Double> w = this.getFrequency();
        int i = 0;
        double r = n.nextDouble();
        while (r > w.get(i)) {
            r = r - w.get(i);
            i = i + 1;
        }
        return i;
    }
    
    /**
     * get the Frequency.
     * @return the frequency.
     */ 
    private List<Double> getFrequency() {
        List<Double> fre = new ArrayList<>();
        String fileName = "letter-frequencies.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((string) -> {
                    fre.add(Double.parseDouble(string));
                });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fre;
    }
}
