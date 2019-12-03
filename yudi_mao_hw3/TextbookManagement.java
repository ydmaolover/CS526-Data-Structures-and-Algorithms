import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class TextbookManagement {

    public static void main(String[] args) throws IOException {

        /**
         * read textbook_info txt into linked list
         */
        FileInputStream fin = new FileInputStream("./textbook_info.txt");
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        LinkedList<String> list = new LinkedList<>();
        while ((strTmp = buffReader.readLine()) != null) {
            list.add(strTmp);
        }
        buffReader.close();


        /**
         * create textbooks and store them into a new linked list
         */
        LinkedList<Textbook> booklist = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] info = list.get(i).split(", ");
            Textbook t = new Textbook();
            t.setCourse(info[0]);
            t.setTitle(info[1]);
            t.setAuthor(info[2]);
            t.setAge(Integer.parseInt(info[3]));
            t.setPrice(Double.parseDouble(info[4]));
            System.out.println(t.toString());
            booklist.add(t);
        }

        /**
         * create price and age list for sorting
         */
        int n = list.size();
        double[] pricelist = new double[n];
        int[] agelist = new int[n];
        double total_price = 0.0;
        for (int i = 0; i < n; i++) {
            double pr = booklist.get(i).getPrice();
            total_price += pr;
            pricelist[i] = pr;
        }
        for (int i = 0; i < n; i++) {
            int a = booklist.get(i).getAge();
            agelist[i] = a;
        }

        /**
         * sort price list and print cheapest and most expensive textbook.
         */
        // sort price list
        for (int k = 1; k < n; k++) {
            double cur_price = pricelist[k];
            int j = k;
            while (j > 0 && pricelist[j - 1] > cur_price) {
                pricelist[j] = pricelist[j - 1];
                j--;
            }
            pricelist[j] = cur_price;
        }
        // get min price and max price
        double min_price = pricelist[0];
        double max_price = pricelist[n - 1];
        // search relevant textbooks and print
        for (int i = 0; i < n; i++) {
            if (booklist.get(i).getPrice() == min_price) {
                System.out.println("Cheapest book:");
                System.out.println(booklist.get(i).toString());
            }
        }
        for (int i = 0; i < n; i++) {
            if (booklist.get(i).getPrice() == max_price) {
                System.out.println("Most expensive book:");
                System.out.println(booklist.get(i).toString());
            }
        }

        // get & print average price
        double ave_price = total_price / n;
        System.out.println("Average price: " + ave_price + "\n");


        /**
         * sort age list and print textbook with youngest author.
         */
        // sort age list
        for (int k = 1; k < n; k++) {
            int cur_age = agelist[k];
            int j = k;
            while (j > 0 && agelist[j - 1] > cur_age) {
                agelist[j] = agelist[j - 1];
                j--;
            }
            agelist[j] = cur_age;
        }
        // print text book written by youngest age.
        for (int i = 0; i < n; i++) {
            if (booklist.get(i).getAge() == agelist[0]) {
                System.out.println("Book by youngest author:");
                System.out.println(booklist.get(i).toString());
            }
        }


    }
}
