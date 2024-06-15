package arrays;

import java.util.List;

public class LongestFreeSpace {

    public static void main(String[] args) {

        List<String> input = List.of("Taken", "Free", "Free", "Free","Taken", "Free", "Free", "Free", "Free", "Taken");
        //input = List.of("Taken", "Taken", "Taken", "Free");
        // input = List.of("Free", "Taken", "Taken", "Taken");
        input = List.of("Taken", "Taken", "Taken", "Taken");

        int end;
        int maxSize = 0, currSize = 0, endIndex = -2;

        for (end = 0; end < input.size(); ++end) {
            if (input.get(end).equals("Free")) {
                ++currSize;
            }

            if (currSize > maxSize) {
                endIndex = end;
                maxSize = currSize;
            }

            if (input.get(end).equals("Taken")) {
                currSize = 0;
            }
        }

        System.out.println("Maxsize: " + maxSize);

        System.out.println("startIndex: " + (endIndex - maxSize + 1));

    }
}
