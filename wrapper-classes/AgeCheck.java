public class AgeCheck {

    public static boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 18;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidAge("20"));
        System.out.println(isValidAge("abc"));
    }
}