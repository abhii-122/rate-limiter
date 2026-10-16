import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {
    public static int mostCommonInteger(int array_length, List<Integer> arr) {
        final int OFFSET = 10000;
        int[] freq = new int[20001];
        for (int i = 0; i < array_length; i++) {
            freq[arr.get(i) + OFFSET]++;
        }
        int best = 0;
        for (int v = 1; v < freq.length; v++) {
            if (freq[v] > freq[best]) best = v;   // strict > keeps the smaller value on ties
        }
        return best - OFFSET;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int array_length = Integer.parseInt(scan.nextLine().trim());
        List<Integer> arr = new ArrayList<>(array_length);
        for (int j = 0; j < array_length; j++) {
            arr.add(Integer.parseInt(scan.nextLine().trim()));
        }
        int result = mostCommonInteger(array_length, arr);
        System.out.println(result);
    }
}