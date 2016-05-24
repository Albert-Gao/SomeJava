package week03;

/**
 *  A recursive representation of digits count.
 *
 * @author Haoyang Gao
 */
public class RecursiveApp{
    /**
     * Calculate how many digits does a number get.
     * @param n pass in the actual number you want to calculate
     * @return the quantity of digits that the 'n' have
     */
    public static long digits(long n){
        long newn = Math.abs(n);
        if (newn<10){
            return 1;
        }
        return 1+digits(n/10);
    }

    /**
     * Calculate the sum of all the digits.
     * @param n pass in the actual number you want to calculate
     * @return the sum of all the digits
     */
    public static long sumOfDigits(long n){
        long lastDigit = n%10;
        long restDigit = n/10;

        if (restDigit==0){
            return n;
        } else {
            return sumOfDigits(restDigit) + lastDigit;
        }
    }
}
