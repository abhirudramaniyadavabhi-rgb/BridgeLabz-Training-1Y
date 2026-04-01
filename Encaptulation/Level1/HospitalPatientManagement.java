import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Encapsulation
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getMedicalHistory() { return medicalHistory; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    // Abstract method for billing
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("\nPatient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Bill: " + calculateBill());
        System.out.println("---------------------------");
    }

    // Implement MedicalRecord
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + name + ":");
        for (String r : medicalHistory) {
            System.out.println("- " + r);
        }
    }
}

// InPatient subclass
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String id, String name, int age, int daysAdmitted, double dailyRate) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
}

// OutPatient subclass
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main Hospital Patient Management System
public class HospitalPatientManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nPatient " + (i + 1));
            System.out.print("Enter Patient ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Type (1=InPatient, 2=OutPatient): ");
            int type = sc.nextInt();
            sc.nextLine();

            Patient p;
            if (type == 1) {
                System.out.print("Enter Days Admitted: ");
                int days = sc.nextInt();
                System.out.print("Enter Daily Rate: ");
                double rate = sc.nextDouble();
                sc.nextLine();
                p = new InPatient(id, name, age, days, rate);
            } else {
                System.out.print("Enter Consultation Fee: ");
                double fee = sc.nextDouble();
                sc.nextLine();
                p = new OutPatient(id, name, age, fee);
            }

            System.out.print("Enter number of medical records to add: ");
            int recCount = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < recCount; j++) {
                System.out.print("Enter record " + (j + 1) + ": ");
                String record = sc.nextLine();
                p.addRecord(record);
            }

            patients.add(p);
        }

        System.out.println("\n===== Patient Details & Bills =====");
        for (Patient p : patients) {
            p.getPatientDetails();
            p.viewRecords();
        }

        sc.close();
    }
}
