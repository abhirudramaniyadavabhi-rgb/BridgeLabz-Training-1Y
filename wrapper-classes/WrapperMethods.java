public class WrapperMethods {
    public static void main(String[] args) {

        int a = Integer.parseInt("123");
        double b = Double.parseDouble("3.14");
        boolean c = Boolean.parseBoolean("true");
        String d = Integer.toBinaryString(10);
        boolean e = Character.isDigit('5');
        char f = Character.toUpperCase('a');

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}