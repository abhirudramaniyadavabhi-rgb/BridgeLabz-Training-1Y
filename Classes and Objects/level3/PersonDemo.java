class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    // Copy Constructor
    Person(Person p) {
        name = p.name;
        age = p.age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Aryan", 20);
        Person p2 = new Person(p1);

        p1.display();
        p2.display();
    }
}