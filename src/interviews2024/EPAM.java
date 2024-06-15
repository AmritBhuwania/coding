//package interviews2024;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class EPAM {
//    public static void main(String[] args) {
//
//        List<Integer> list = List.of(1, 0, 0, 1, 1, 0, 0, 1, 1);
//        int k = 5;
//
//        System.out.println(findMaxSizeOfMax1s(list, k));
//    }
//
//    private static int findMaxSizeOfMax1s(List<Integer> list, int k) {
//
//        int max = Integer.MIN_VALUE, currMax = 0;
//        int start = 0;
//        int end = 0; // 1 0 0 1 1 0 0 1 1, k = 2
//                      //  1 0 1 1 1 1 0 1 1
//                     // k = 0
//                     // start = 1
//                     // currMax =
//                     // max = 5
//                     // zeroIndexList = 2
//                     // end = 5
//        List<Integer> zeroIndexList = new ArrayList<>();
//
//        int length = list.size();
//        for (end = 0; end < length; ++end) {
//            if (list.get(end) == 1) {
//                ++currMax;
//            }
//
//            else if (k > 0 && list.get(end) == 0) {
//                --k;
//                ++currMax;
//                zeroIndexList.add(end);
//            }
//
//            else if (k == 0 && list.get(end) == 0 && zeroIndexList.size() > 0) {
//                start = zeroIndexList.get(0) + 1;
//                zeroIndexList.removeFirst();
//                currMax = (end - start) + 1;
//                zeroIndexList.add(end);
//                //k = 0;
//            }
//
//            max = Math.max(max, currMax);
//        }
//        return max;
//    }
//
//    public int longestOnes(int[] nums, int k) {
//        int start = 0, end = 0, max = 0, count = 0, curr;
//
//        for (end = 0; end < nums.length; ++end) {
//            curr = nums[end];
//            if (curr == 1) {
//                continue;
//            } else {
//                if (k > 0) {
//                    --k;
//                } else {
//                    count = end - start;
//                    max = Math.max(max, count);
//                    while(nums[start] != 0) {
//                        ++start;
//                    }
//                    ++start;
//                }
//            }
//        }
//        return Math.max(max, end - start);
//
//    }
//}
//
//
//
////        String input = "1234";
////        int k = 2;
////
////        Stack<Character> stack = new Stack<>();
////        char c;
////
////        for (int i = 0; i < input.length(); ++i) {
////            c = input.charAt(i);
////
////            if (stack.isEmpty()) {
////                stack.push(c);
////                continue;
////            }
////
////            while(!stack.isEmpty() && c < stack.peek() && k > 0) {
////                --k;
////                stack.pop();
////            }
////            stack.push(c);
////        }
////
////        while (k > 0) {
////            stack.pop();
////            --k;
////        }
////
////        StringBuilder ans = new StringBuilder();
////
////        while(!stack.isEmpty()) {
////            ans.append(stack.pop());
////        }
////
////        ans.reverse();
////
////        System.out.println(ans);