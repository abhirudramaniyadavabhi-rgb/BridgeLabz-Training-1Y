public class Game {

    public static void main(String[] args) {

        Integer[] scores = {10, null, 20, null, 30};

        int count = 0, sum = 0;

        for (Integer s : scores) {
            if (s == null)
                count++;
            else
                sum += s;
        }

        System.out.println("Not played: " + count);
        System.out.println("Total score: " + sum);
    }
}