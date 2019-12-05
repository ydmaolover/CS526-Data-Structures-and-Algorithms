import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    /**
     * Insertion sort, non decreasing.
     */
    public static void insertionSort(int[] data) {

        int n = data.length;

        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1]; //shift number lager than cur one rightward
                j--;
            }
            data[j] = cur; //insert cur
        }
    }

    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    public static void merge(int[] S1, int[] S2, int[] S) {

        int i = 0, j = 0;

        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i] - S2[j] < 0)) {
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }

    /**
     * Merge-sort contents of array S.
     */
    public static void mergeSort(int[] S) {

        int n = S.length;
        if (n < 2) return; //array is trivially divided

        //divide
        int mid = n / 2;
        int[] S1 = Arrays.copyOfRange(S, 0, mid);
        int[] S2 = Arrays.copyOfRange(S, mid, n);

        //conquer (with recursion)
        mergeSort(S1);
        mergeSort(S2);

        //merge results
        merge(S1, S2, S);
    }

    /**
     * Quick-sort the subarray S[a..b] inclusive
     * quickSortInPlace(S, 0, S.length-1)
     */
    public static void quickSortInPlace(int[] S, int a, int b) {

        if (a >= b) return; //subarray is trivially sorted
        int left = a;
        int right = b;
        int mid = a + (b - a) / 2;
        int tmp;
        if (S[left] > S[right]) {
            tmp = S[left];
            S[left] = S[right];
            S[right] = tmp;
        }
        if (S[mid] > S[right]) {
            tmp = S[mid];
            S[mid] = S[right];
            S[right] = tmp;
        }
        if (S[left] > S[mid]) {
            tmp = S[left];
            S[left] = S[mid];
            S[mid] = tmp;
        }
        int pivot = S[mid];
        int temp; // temp object used for swapping

        while (left <= right) {
            //scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && S[left] - pivot < 0) {
                left++;
            }
            //scan until reaching value equal or smaller than pivot (or left marker)
            while (left <= right && S[right] - pivot > 0) {
                right--;
            }
            if (left <= right) { //indices did not strictly cross
                //swap values and shrink range
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }

        // put pivot into its final place (currently marked by left index)
        temp = S[left];
        S[left] = S[mid]; //which is pivot
        S[mid] = temp;

        // make recursive calls
        quickSortInPlace(S, a, left - 1);
        quickSortInPlace(S, left + 1, b);

    }


    /**
     * Heap-sort
     * refer: https://www.geeksforgeeks.org/heap-sort/
     */
    public static void heapify(int[] S, int n, int i) {

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // swap the largest one in a "triangle" to parent position
        // If left child is larger than loot
        if (l < n && S[l] > S[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && S[r] > S[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int temp = S[i];
            S[i] = S[largest];
            S[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(S, n, largest);
        }
    }

    public static void heapSort(int[] S) {

        int n = S.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) { // all non-leaf
            heapify(S, n, i);
        }

        // One-by-one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = S[0];
            S[0] = S[i];
            S[i] = temp;

            // call max heapify on the reduced map
            heapify(S, i, 0);
        }
    }


    /**
     * Calculate the elapsed time of four sorts with array of n elements
     */
    public static void elapsed(int n) {

        // generate random array
        int[] random_array = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            random_array[i] = r.nextInt(1000000) + 1;
            //System.out.println(random_array[i]);
        }

        // calculate elapsed time and print
        int[] S = random_array;
        long startTime = System.currentTimeMillis();
        insertionSort(S);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time of insertion sort of length " + Integer.toString(n) + " random array is:" + elapsedTime);

        S = random_array;
        startTime = System.currentTimeMillis();
        mergeSort(S);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Elapsed time of merge sort of length " + Integer.toString(n) + " random array is:" + elapsedTime);


        S = random_array;
        startTime = System.currentTimeMillis();
        quickSortInPlace(S, 0, S.length - 1);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Elapsed time of quick sort of length " + Integer.toString(n) + " random array is:" + elapsedTime);
        //for (int i = 0; i < S.length; i++) {
        //    System.out.println(S[i]);
        //}


        S = random_array;
        startTime = System.currentTimeMillis();
        heapSort(S);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Elapsed time of heap sort of length " + Integer.toString(n) + " random array is:" + elapsedTime);
    }


    /**
     * Main
     * Gather elapsed time of four sorts of array with length 10000, 20000, 30000, ... , 1000000
     */
    public static void main(String[] args) {
        elapsed(10000);
        elapsed(20000);
        elapsed(30000);
        elapsed(40000);
        elapsed(50000);
        elapsed(60000);
        elapsed(70000);
        elapsed(80000);
        elapsed(90000);
        elapsed(100000);
    }


}

