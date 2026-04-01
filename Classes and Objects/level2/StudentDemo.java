class Student {
    String name;
    int rollNumber;
    int marks;

    char calculateGrade() {
        if (marks >= 90)
            return 'A';
        else if (marks >= 75)
            return 'B';
        else if (marks >= 50)
            return 'C';
        else
            return 'F';
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Aryan";
        s.rollNumber = 12;
        s.marks = 85;

        s.displayDetails();
    }
}