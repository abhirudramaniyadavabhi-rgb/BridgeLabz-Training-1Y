class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }
}

class PostgraduateStudent extends Student {
    void displayDetails() {
        System.out.println("Roll: " + rollNumber);
        System.out.println("Name: " + name); // protected accessible
        System.out.println("CGPA: " + getCGPA());
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent();
        pg.rollNumber = 101;
        pg.name = "Aryan";
        pg.setCGPA(8.5);

        pg.displayDetails();
    }
}