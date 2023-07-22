package codingPatterns.fastSlowPointers;

/**
 * <a href="https://leetcode.com/problems/happy-number/submissions/">...</a>
 */
public class HappyNumber {

    public boolean isHappy(int n) {

        int slow = n, fast = n;
        do {
            slow = calDigitsSquareSum(slow);
            fast = calDigitsSquareSum(calDigitsSquareSum(fast));
        } while (fast != slow);

        return slow == 1;
    }

    private int calDigitsSquareSum(int num) {
        int digit, sum = 0;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(12));
        System.out.println(new HappyNumber().isHappy(19));

    }
}
