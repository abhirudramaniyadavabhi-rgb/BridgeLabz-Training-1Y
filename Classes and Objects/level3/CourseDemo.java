class Course {
    String courseName;
    int duration;
    double fee;

    static String instituteName = "ABC Institute";

    Course(String name, int duration, double fee) {
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration);
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class CourseDemo {
    public static void main(String[] args) {
        Course c1 = new Course("Java", 3, 15000);
        c1.displayCourseDetails();

        Course.updateInstituteName("XYZ Institute");
        System.out.println("\nAfter Update:");
        c1.displayCourseDetails();
    }
}