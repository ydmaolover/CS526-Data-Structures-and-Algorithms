


public class Textbook {
    private String course;
    private String title;
    private String author;
    private int age;
    private double price;

    public void TextBook() { }
    public void TextBook(String c, String t, String p, int a, double pr) {
        course = c;
        title = t;
        author = p;
        age = a;
        price = pr;
    }

    public String getCourse() { return course;}
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getAge() { return age; }
    public double getPrice() {return price; }

    public void setCourse(String c) {
        course = c;
    }
    public void setTitle(String t) {
        title = t;
    }
    public void setAuthor(String p) {
        author = p;
    }
    public void setAge(int a) {
        age = a;
    }
    public void setPrice(double pr) {
        price = pr;
    }

    public String toString() {
        return "\tCourse: " + course +
                "\n\tTitle: " + title +
                "\n\tAuthor: " + "Name = " + author + ", Age = " + age +
                "\n\tPrice: " + price + "\n";
    }
}
