package week09;

import java.util.List;

/**
 * Created by camus on 24/04/2016.
 */
public interface ExamPile {
    void load(List<Integer> items);
    int peek();
    int mark(int depth, int value);
    void delay(int count);
}