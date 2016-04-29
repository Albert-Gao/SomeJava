package week08;

/*

This works as follows: to add a new value, v, to a tableau we first look in the first row of the tableau.
If v can be added to the end of the row (because it’s at least as big as anything in the row),
then we do so and are done.

Otherwise, we find the first element of the row, say w, that is bigger than v.
We replace the cell containing w by one containing v (“v bumps w out of the row”) and
then proceed to try and insert w into the second row by the same means.

We always add to the end of a row if we can (in which case we’re done), or bump something into the next row.

If absolutely necessary, we can add an extra row containing the final bumped element.
*/

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(cal(2));
    }

    private static int cal(int a){
        if(a>64){
            return a;
        }
        return cal(a*a);
    }
}
