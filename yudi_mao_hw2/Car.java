import java.util.Comparator;

/**
 * Yudi Mao
 * CS526 Hw2
 */

public class Car implements Comparator<Car> {
    private String make;
    private int year;
    private int price;

    //Override compare method by year value
    public int compare(Car o1, Car o2) {
        if (o1.getYear() > o2.getYear()) {
            return 1;
        } else {
            return -1;
        }
    }

    public Car() {}
    public Car(String m, int y, int p) {
        make = m; year = y; price = p;
    }

    public String getMake() { return make; }
    public int getYear() { return year; }
    public int getPrice() { return price; }

    public void setMake(String m) { make = m; }
    public void setYear(int y) { year = y; }
    public void setPrice(int p) { price = p; }

    public String toString() {
        return "Make = " + make + " Year = " + year + " Price = " + price;
    }

}
