import java.util.*;

public class Ratings {
    public static void main(String[] args) {

        int[] arr = {5, 4, 3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, null, 4));

        ArrayList<Integer> finalList = new ArrayList<>();

        for (int i : arr) finalList.add(i);
        for (Integer i : list) {
            if (i != null) finalList.add(i);
        }

        double sum = 0;
        for (int i : finalList) sum += i;

        System.out.println("Average: " + sum / finalList.size());
    }
}