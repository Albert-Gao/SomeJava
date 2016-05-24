package week09;

import java.util.*;

/**
 * A class use to sort a number sequence.
 * When the program begins, inputs will be read from Bash command line.
 * Then it will process the inputs using the predefined rule.
 * The default depth of 1 will be used,
 * if no other depth is passed when the program is run.
 *
 * @author Haoyang Gao, Patrick Dowd
 */
public class EP implements ExamPile {

    /**
     * LinkedList used to store current pile we're working on.
     * Its source is EP.piles.
     */
    private LinkedList<Integer> pile;

    /**
     * The whole input numbers.
     */
    private ArrayList<LinkedList<Integer>> piles;

    /**
     * To store the current sortedPile we work on.
     * This is the same pile but sorted.
     * So that we always know the order of the pile.
     * Its source is EP.sortedPiles.
     * A version without the sortedPile is available.
     * Although the code is more robust when using sortedPile.
     */
    private LinkedList<Integer> sortedPile;

    /**
     * The whole input numbers, but sorted.
     */
    private ArrayList<LinkedList<Integer>> sortedPiles;

    /**
     * Where the processed list will be stored in order.
     * i.e. It will look like "DDMDM".
     */
    private ArrayList<String> orders;

    /**
     * Constructor of the class.
     * New instances for each properties will be created here.
     */
    private EP() {
        this.pile = new LinkedList<>();
        this.piles = new ArrayList<>();
        this.sortedPile = new LinkedList<>();
        this.sortedPiles = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    /**
     * Use to test the class.
     * Inputs are scanned and stored in a <>List.
     * Lists are then processed one by one.
     * Finally, the processed order is printed for each pile.
     *
     * @param args The pass-in parameter from command line.
     */
    public static void main(String[] args) {
        EP test = new EP();

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            String[] pile = input.split(" ");
            test.convertArrayToPileList(pile);
        }
        scan.close();

        if (args.length == 0) {
            test.sortingSteps(1);
        } else {
            test.sortingSteps(Integer.parseInt(args[0]));
        }

        test.orders.forEach(System.out::println);
    }

    /**
     * This method will store the input to instance variable.
     * A sorted version will also be stored here.
     *
     * @param pile one line of the input numbers.
     */
    private void convertArrayToPileList(String[] pile) {
        LinkedList<Integer> tempPile = new LinkedList<>();
        for (String item : pile) {
            tempPile.addLast(Integer.parseInt(item));
        }

        this.piles.add(tempPile);

        LinkedList<Integer> tempSortedPile = new LinkedList<>(tempPile);
        Collections.sort(tempSortedPile);
        this.sortedPiles.add(tempSortedPile);
    }

    /**
     * This method implements the ExamPile interface.
     * To load the pass-in list.
     * It will store it in the instance variable pile.
     * It also stores a sorted-version as sortedPile.
     *
     * @param items the pass-in parameter
     */
    @Override
    public void load(List<Integer> items) {
        LinkedList<Integer> temp = new LinkedList<>(items);
        this.piles.add(temp);

        LinkedList<Integer> temp2 = new LinkedList<>(temp);
        Collections.sort(temp2);
        this.sortedPiles.add(temp2);

        this.pile = temp;
        this.sortedPile = new LinkedList<>(temp2);
    }

    /**
     * This method is to implement the ExamPile interface.
     * To check the first value of the pile.
     *
     * @return Return the first value.
     */
    @Override
    public int peek() {
        this.checkPileSize();
        return this.pile.peekFirst();
    }

    /**
     * This method implements the ExamPile interface.
     * To mark the corresponding value.
     * If the pass-in value we are seeking is actually there,
     * it is removed from the pile.
     * If succesful the value will be returned,
     * and return -1 if nothing matches.
     *
     * @param depth the index of the value.
     * @param value the value we are looking for.
     * @return return the value or -1 if target value not found.
     */
    @Override
    public int mark(int depth, int value) {
        this.checkPileSize();
        for (int i = 0; i < depth; i++) {
            int item = this.pile.get(i);
            if (item == value) {
                this.pile.remove(i);
                return value;
            }
        }
        return -1;
    }

    /**
     * This method implements the ExamPile interface.
     * To move some exams to the bottom.
     * The sequence of the exams remains the same.
     *
     * @param count The quantity we that will be moved.
     */
    @Override
    public void delay(int count) {
        this.checkPileSize();
        for (int i = 0; i < count; i++) {
            int first = this.pile.pollFirst();
            this.pile.addLast(first);
        }
    }

    /**
     * This method will check the size of the pile.
     * If it equals 0 we will throw an exception.
     * We can just invoke it in other methods.
     * To prevent code duplication.
     */
    private void checkPileSize() {
        try {
            if (this.pile.size() == 0) {
                throw new EmptyPileException("It is empty!");
            }
        } catch (EmptyPileException e) {
            e.printStackTrace();
        }
    }

    /**
     * To mark the exams using the predefined rule.
     * Every time we process a list,
     * Firstly, we get the start value and the end value.
     * Secondly, we store the pile and its sorted version.
     * Lastly, we use the above variables to invoke the
     * recursive method to work on it
     * TIP: We use the StringBuilder to gain performance.
     *
     * @param depth The depth we used to check.
     */
    private void sortingSteps(int depth) {
        for (int i = 0; i < this.piles.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int start = this.sortedPiles.get(i).peekFirst();
            int end = this.sortedPiles.get(i).peekLast();
            this.pile = this.piles.get(i);
            this.sortedPile = this.sortedPiles.get(i);
            this.recurseMark(sb, start, end, depth);
        }
    }

    /**
     * It's the actual method we use to loop the pile.
     * We check the numbers one by one,
     * for the following 2 scenarios:
     * (1) If we find the correct number(The one matches the start value),
     * We'll mark a 'M', and remove it,
     * And we also need to remove one from the sorted version,
     * so the next time we loop, we can get the next correct value.
     * Then we do a next recursion using the new start value.
     * (2) If we don't find the correct value, we'll delay the top section,
     * Then we mark a 'D' and then we recursive scan again.
     * (3) We use a variable named "found" to indicate if we found something.
     * Finally, if we found that start value equals end value.
     * It indicates that we have hit the end.
     * So we mark the final 'M' and quit the recursive.
     *
     * @param sb    The StringBuilder we use to store the process.
     * @param start The correct start(next) value to check.
     * @param end   The ending signal.
     * @param depth The depth we need to check the pile.
     */
    private void recurseMark(StringBuilder sb, int start, int end, int depth) {
        if (start == end) {
            sb.append('M');
            this.orders.add(sb.toString());
            return;
        }

        boolean found = false;
        if (this.mark(depth, start) == -1) {
            found = false;
        } else {
            found = true;
            sb.append('M');
            this.sortedPile.pollFirst();
        }

        if (found) {
            recurseMark(sb, this.sortedPile.peekFirst(), end, depth);
        } else {
            this.delay(depth);
            sb.append('D');
            recurseMark(sb, start, end, depth);
        }
    }
}
