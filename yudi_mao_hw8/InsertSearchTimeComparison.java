import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;


/**
 * This program is just to test
 * DON'T run it unless it's necessary cuz its very
 * TIME CONSUMING!!!!!!!!!!!
 * DON'T laugh at it
 */
public class InsertSearchTimeComparison {

    public static void main(String[] args) {

        /**
         * Create empty HashMap
         * ArrayList
         * LinkedList
         * An array to store keys
         * An array to store values
         */
        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        int[] keys = new int[100000];
        int[] values = new int[100000];


        long myMapInsertT = 0;
        long myALInsertT = 0;
        long myLLInsertT = 0;
        long myMapSearchT = 0;
        long myALSearchT = 0;
        long myLLSearchT = 0;
        // Loop 10 times
        for (int i = 0; i < 10; i++) {

            // Generate random keys
            Random r = new Random(System.currentTimeMillis());
            for (int j = 0; j < 100000; j++) {
                keys[j] = r.nextInt(1000000) + 1;
            }

            // Generate random values
            r.setSeed(System.currentTimeMillis());
            for (int k = 0; k < 100000; k++) {
                values[k] = r.nextInt(2000000) + 1;
            }


            // Insert keys one at a time but measure only the total time (not individual insert time)
            // Use put method for HashMap
            // Use add method for ArrayList and Linked List

            long startTime, endTime, elapsedTime;

            // insert all keys in keys[ ] into myMap and measure the total insert time
            startTime = System.currentTimeMillis();
            for (int l1 = 0; l1 < 100000; l1++) {
                myMap.put(keys[l1], null);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            myMapInsertT += elapsedTime;

            // insert all keys in keys[ ] into myArrayList and measure the total insert time
            startTime = System.currentTimeMillis();
            for (int l2 = 0; l2 < 100000; l2++) {
                myArrayList.add(keys[l2]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            myALInsertT += elapsedTime;

            // insert all keys in keys[ ] into myLinkedList and measure the total insert time
            startTime = System.currentTimeMillis();
            for (int l3 = 0; l3 < 100000; l3++) {
                myLinkedList.add(keys[l3]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            myLLInsertT += elapsedTime;


            // Search keys one at a time but measure only total time (not individual search time)
            // Use containsKey method for HashMap
            // Use contains method for ArrayList and Linked List

            // search myMap for all keys in keys[ ] and measure the total search time
            startTime = System.currentTimeMillis();
            for (int l4 = 0; l4 < 100000; l4++) {
                myMap.containsKey(values[l4]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            myMapSearchT += elapsedTime;

            // search myArrayList for all keys in keys[ ] and measure the total search time
            startTime = System.currentTimeMillis();
            for (int l5 = 0; l5 < 100000; l5++) {
                myArrayList.contains(values[l5]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            myALSearchT += elapsedTime;

            // search myLinkedList for all keys in keys[ ] and measure the total search time
            startTime = System.currentTimeMillis();
            for (int l6 = 0; l6 < 100000; l6++) {
                myLinkedList.contains(keys[l6]);
            }
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            myLLSearchT += elapsedTime;
        }

        System.out.println("Number of keys = " + keys.length);
        System.out.println();
        System.out.println("HashMap average total insert time = " + myMapInsertT / 10);
        System.out.println("ArrayList average total insert time = " + myALInsertT / 10);
        System.out.println("LinkedList average total insert time = " + myLLInsertT / 10);
        System.out.println();
        System.out.println("HashMap average total search time = " + myMapSearchT / 10);
        System.out.println("ArrayList average total search time = " + myALSearchT / 10);
        System.out.println("LinkedList average total search time = " + myLLSearchT / 10);
        System.out.println();
    }
}
