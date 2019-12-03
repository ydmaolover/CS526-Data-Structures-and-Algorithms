import java.util.Comparator;

/**
 * Yudi Mao
 * CS526 Hw2
 */

public class Person implements Comparator<Person> {
    private String name;
    private int age;

    //Override compare method by year value
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }

    public Person() {}
    public Person(String n, int a) {
        name = n; age = a;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String n) { name = n; }
    public void setAge(int a) { age = a; }

    public String toString() {
        return "Name = " + name + " Age = " + age;
    }

}
