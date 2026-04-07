import java.util.*;

public class EmployeeData {
    public static void main(String[] args) {

        int[] ages = {22, 30, 18, 45, 27};

        // Convert int[] → ArrayList<Integer>
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ages.length; i++) {
            list.add(ages[i]); // auto-boxing
        }

        // Find min and max
        int youngest = Collections.min(list);
        int oldest = Collections.max(list);

        System.out.println("Youngest age = " + youngest);
        System.out.println("Oldest age = " + oldest);
    }
}