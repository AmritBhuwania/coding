package interviews2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TelusInternational {
    public static void main(String[] args) {


////        54, 546, 548, 60] → 6054854654
//        [60, 548, 546, 54]
//
////                [1, 34, 3, 98, 9, 76, 45, 4] → 998764543431
//        98, 9,  76,45, 4, 34, 3 , 1

        List<String> input = new ArrayList<>(Arrays.asList("1", "34", "3", "98", "9", "76", "45", "4"));

        Collections.sort(input, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        StringBuilder builder = new StringBuilder(100);
        for (int i = 0; i < input.size(); ++i) {
            builder.append(input.get(i));
        }

        System.out.println(input);
        System.out.println(builder);
    }
}


//    int arr[] = new int[] {2,1};
//    int len = arr.length;
//    int zeroes = 0, twoes = len -1, start = 0;
//        while (start <= twoes) {
//
//        if (arr[start] == 2) {
//            swap(arr, start, twoes);
//            --twoes; // start = 2, zeroes = 1
//            if (arr[start] == 0 && arr[zeroes] == 1) {
//                swap(arr, start, zeroes);
//                ++zeroes;
//                ++start;
//            }
//        }
//
//        else if (arr[start] == 0 && arr[zeroes] == 1) {
//            swap(arr, start, zeroes);
//            ++zeroes;
//            ++start;
//        } else if (arr[start] == 0) {
//            ++start;
//            ++zeroes;
//        } else {
//            ++start;
//        }
//    }
//
//        for (int i = 0; i < len; i++) {
//        System.out.print(arr[i] + ",");
//    }
//
//}
//
//private static void swap(int[] arr, int start, int end) {
//    int temp = arr[start];
//    arr[start] = arr[end];
//    arr[end] = temp;
//}




