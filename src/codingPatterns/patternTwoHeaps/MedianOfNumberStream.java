package codingPatterns.patternTwoHeaps;

import java.util.PriorityQueue;

/**
 * Design a class to calculate the median of a number stream. The class should have the following two methods:
 *
 * insertNum(int num): stores the number in the class
 * findMedian(): returns the median of all numbers inserted in the class
 * If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
 */
public class MedianOfNumberStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b-a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a-b));

    public static void main(String[] args) {
        MedianOfNumberStream medianOfNumberStream = new MedianOfNumberStream();
        medianOfNumberStream.insertNum(1);
        System.out.println(medianOfNumberStream.findMedian());
        medianOfNumberStream.insertNum(2);
        System.out.println(medianOfNumberStream.findMedian());
        medianOfNumberStream.insertNum(3);
        System.out.println(medianOfNumberStream.findMedian());
        medianOfNumberStream.insertNum(4);
        System.out.println(medianOfNumberStream.findMedian());
        medianOfNumberStream.insertNum(5);
        System.out.println(medianOfNumberStream.findMedian());
    }

    private void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num ) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    private double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}
