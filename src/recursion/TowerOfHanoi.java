package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int s = 1, h = 2, d = 3, n = 15, count = 0;
        count = towerOfHanoi(n, s, d, h, count);
        System.out.println("Count: " + ++count);
    }

    private static int towerOfHanoi(int n, int s, int d, int h, int count) {

        if (n == 1) {
            System.out.println(String.format("Moving %d from %d to %d", n, s, d));
            return count;
        }

        count = towerOfHanoi(n-1, s, h, d, ++count);
        System.out.println(String.format("Moving %d from %d to %d", n, s, d));
        count = towerOfHanoi(n-1, h, d, s, ++count);
        return count;

        }

}
