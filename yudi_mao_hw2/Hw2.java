import java.util.ArrayList;
import java.util.Collections;

/**
 * Yudi Mao
 * CS526 Hw2
 */

public class Hw2 {

    public static void main(String[] args) {

        /**
         * Car part
         */
        ArrayList<Car> carList = new ArrayList<>();

        // create cars and add them to array list
        Car c1, c2, c3, c4, c5, c6, c7, c8;
        c1 = new Car();
        c1.setMake("GM");
        c1.setYear(2000);
        c1.setPrice(10000);
        carList.add(c1);
        c2 = new Car();
        c2.setMake("Honda");
        c2.setYear(2013);
        c2.setPrice(20000);
        carList.add(c2);
        c3 = new Car();
        c3.setMake("Ford");
        c3.setYear(2019);
        c3.setPrice(25000);
        carList.add(c3);
        c4 = new Car("Hyundai", 2005, 15000);
        c5 = new Car("Chevy", 2012, 20000);
        c6 = new Car("Volvo", 2009, 13000);
        c7 = new Car("Kia", 2017, 23000);
        c8 = new Car("Toyota", 2010, 17000);
        carList.add(c4);
        carList.add(c5);
        carList.add(c6);
        carList.add(c7);
        carList.add(c8);

        //Output the array
        System.out.println("All cars in the list are:" + "\n");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }

        //Sort the array with increasing year value
        Collections.sort(carList, c1);
        System.out.println("\n" + "Cars reordered by years:" + "\n");
        for (Car c : carList) {
            System.out.println("Make = " + c.getMake() + " Year = " + c.getYear() + " Price = " + c.getPrice());
        }

        //Output minimum and maximum
        System.out.println("\n" + "Oldest Car is:" + "\n");
        System.out.println(carList.get(0));
        System.out.println("\n" + "Newest Car is:" + "\n");
        System.out.println(carList.get(7));

        //Output average price
        int add = 0;
        for (int i = 0; i < carList.size(); i++) {
            add += carList.get(i).getPrice();
        }
        double ave = (double) add / (double) carList.size();
        System.out.println("\n" + "Average price is:" + ave);


        /**
         * Person part
         */
        ArrayList<Person> personList = new ArrayList<>();

        // create person doc and add them to array list
        Person p1, p2, p3, p4, p5, p6, p7;
        p1 = new Person();
        p1.setName("John");
        p1.setAge(43);
        personList.add(p1);
        p2 = new Person("Susan", 22);
        p3 = new Person("Jake", 18);
        p4 = new Person("Molly", 37);
        p5 = new Person("Kelsey", 62);
        p6 = new Person("Adam", 27);
        p7 = new Person("Lindsey", 26);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);
        personList.add(p7);

        //Output the array
        System.out.println("All persons in the list are:" + "\n");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).toString());
        }

        //Sort the array with increasing age value
        Collections.sort(personList, p1);
        System.out.println("\n" + "Persons reordered by age:" + "\n");
        for (Person p : personList) {
            System.out.println("Name = " + p.getName() + " Age = " + p.getAge());
        }

        //Output minimum and maximum
        System.out.println("\n" + "Oldest person is:" + "\n");
        System.out.println(personList.get(6));
        System.out.println("\n" + "Youngest Car is:" + "\n");
        System.out.println(personList.get(0));

        //Output average price
        int addage = 0;
        for (int i = 0; i < personList.size(); i++) {
            addage += personList.get(i).getAge();
        }
        double aveage = (double) addage / (double) personList.size();
        System.out.println("\n" + "Average age is:" + aveage);
    }

}
