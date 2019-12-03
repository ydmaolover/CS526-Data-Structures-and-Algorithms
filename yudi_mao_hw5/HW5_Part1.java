

public class HW5_Part1 {


    static void rearrange(int[] a) {
        // implement this method
        // O(n)
        int p_begin = 0;
        int p_end = a.length - 1;
        while (p_begin < p_end) {
            if (a[p_begin] % 2 != 0) {
                p_begin++;
            } else if (a[p_end] % 2 == 0) {
                p_end--;
            }
            // swap even num at begin and odd num at end
            else {
                int temp = a[p_begin];
                a[p_begin] = a[p_end];
                a[p_end] = temp;
            }
        }
        // estimated running time O(n)
    }

    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n]; // array of size n

        // n random integers between 0 and 100
        // 0 included but 100 excluded
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        System.out.println("Before rearrange");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "  ");
        }

        rearrange(a);

        System.out.println("\nAfter rearrange");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "  ");
        }


    }
}


