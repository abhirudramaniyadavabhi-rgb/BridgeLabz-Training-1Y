
public class Marks {
    public static void main(String[] args) {

        String[] data = {"85", "95", "88", "null", "abc"};

        int sum = 0, count = 0;

        for (String s : data) {
            try {
                if (!s.equals("null")) {
                    int val = Integer.parseInt(s);
                    sum += val;
                    count++;
                }
            } catch (Exception e) {}
        }

        System.out.println("Average = " + (sum / count));
    }
}