import java.util.*;

public class Performance {
    public static void main(String[] args) {

        int n = 1000000;

        // ArrayList
        long start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) list.add(i);

        long sum = 0;
        for (int i : list) sum += i;

        long end = System.currentTimeMillis();
        System.out.println("ArrayList time: " + (end - start));

        // Array
        start = System.currentTimeMillis();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = i;

        sum = 0;
        for (int i : arr) sum += i;

        end = System.currentTimeMillis();
        System.out.println("Array time: " + (end - start));
    }
}