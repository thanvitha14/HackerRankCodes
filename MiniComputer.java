



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1 > i2) {
                return -1;
            } else if (i1 < i2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Queue<Integer> minHeap = new PriorityQueue<>(n/2+1, new MinComparator());
        Queue<Integer> maxHeap = new PriorityQueue<>(n/2+1, new MaxComparator());

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (!maxHeap.isEmpty() && num > maxHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }

            double median = 0.0;
            if (minHeap.size() == maxHeap.size()) {
                median = 0.5 * (minHeap.peek() + maxHeap.peek());
            } else {
                median = (minHeap.size() > maxHeap.size()) ? minHeap.peek() : maxHeap.peek();
            }

            System.out.println(String.format("%1.1f", median));
        }
    }

}

