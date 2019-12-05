import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Modified from SinglyLinkedList
 * Manages searchable cars
 */

public class CarLinkedList {
    //---------------- nested Node class ----------------

    /**
     * This node stores only a SearchableCar object
     */

    private static class Node {

        /**
         * The element stored at this node
         */
        private SearchableCar element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node next;         // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(SearchableCar e, Node n) {
            element = e;
            next = n;
        }

        // Accessor methods
        /**
         * Returns the element stored at the node.
         */
        public SearchableCar getElement() { return element; }

        /**
         * Returns the node that follows this one.
         */
        public Node getNext() { return next; }

        // Modifier methods
        /**
         * Sets the node's next reference to point to Node n.
         */
        public void setNext(Node n) { next = n; }
    } //----------- end of nested Node class -----------

    // instance variables of CarLinkedList
    /**
     * The head node of the list
     */
    private Node head = null;               // head node of the list (or null if empty)

    /**
     * The last node of the list
     */
    private Node tail = null;               // last node of the list (or null if empty)

    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public CarLinkedList() { }              // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     */
    public int size() { return size; }

    /**
     * Tests whether the linked list is empty.
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns (but does not remove) the first element of the list
     */
    public SearchableCar first() {             // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return head.getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     */
    public SearchableCar last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     */
    public void addFirst(SearchableCar e) {                // adds element e to the front of the list
        head = new Node(e, head);              // create and link a new node
        if (size == 0)
            tail = head;                           // special case: new node becomes tail also
        size++;
    }

    /**
     * Adds an element to the end of the list.
     */
    public void addLast(SearchableCar e) {                 // adds element e to the end of the list
        Node newest = new Node(e, null);    // node will eventually be the tail
        if (isEmpty())
            head = newest;                         // special case: previously empty list
        else
            tail.setNext(newest);                  // new node after existing tail
        tail = newest;                           // new node becomes the tail
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     */
    public SearchableCar removeFirst() {                   // removes and returns the first element
        if (isEmpty()) return null;              // nothing to remove
        SearchableCar answer = head.getElement();
        head = head.getNext();                   // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null;                           // special case as list is now empty
        return answer;
    }

    // You are required to implement the following remove method

    /**
     * Removes and returns the car with given VIN.
     * Returns null if the list is empty
     * Returns null if the car with the VIN does not exist.
     */
    public SearchableCar remove(String vin) {

        // implement this method
        //record orinial size of carList
        int ori_size = size;
        //Returns null if the list is empty
        if (isEmpty()) return null;
        //Removes and returns the car with given VIN.
        //check head
        if (head.getElement().getVIN().equals(vin)) {
            head = head.next;
            size--;
        }
        //check next
        Node p = head;
        Node t = p.next;
        //the loop
        while (t != null) {
            if (t.getElement().getVIN().equals(vin)) {
                p.next = t.next;
                t = t.next;
                size--;
            } else {
                p = t;
                t = t.next;
            }
        }
        //Returns null if the car with the VIN does not exist.
        if (size == ori_size) {
            return null;
        } else
            return tail.getElement();
    }


    // Reads cars from an input file and stores them in a CarLinkedList
    public static void readSearchableCars(CarLinkedList carList) throws FileNotFoundException {

        Scanner carListScanner = new Scanner(new File("./searchable_car_info.txt"));
        String aSearchableCar;
        String VIN;
        String make;
        int year;
        int price;

        while (carListScanner.hasNext()) {
            aSearchableCar = carListScanner.nextLine();
            Scanner carScanner = new Scanner(aSearchableCar);
            VIN = carScanner.next();
            make = carScanner.next();
            year = carScanner.nextInt();
            price = carScanner.nextInt();

            SearchableCar c = new SearchableCar(VIN, make, year, price);
            carList.addLast(c);
        }
    }

    // print all cars in the list
    public static void printAllCars(CarLinkedList carList) {
        Node current = carList.head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
        System.out.println();
    }

    // Test your remove method with the main method
    public static void main(String[] args) {

        CarLinkedList carList = new CarLinkedList();
        try {
            readSearchableCars(carList);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }

        System.out.println("Print all cars");
        System.out.println("The number of cars in the list = " + carList.size());
        printAllCars(carList);
        System.out.println();

        // Test remove method

        SearchableCar removedCar;
        String VIN = "ABC123";
        removedCar = carList.remove(VIN);
        if (removedCar == null) {
            System.out.println("The car does not exist");
        } else {
            System.out.println("Print all cars after removing a car VIN = " + VIN);
            System.out.println("The number of cars in the list = " + carList.size());
            printAllCars(carList);
        }
        System.out.println();

        VIN = "JKL111";
        removedCar = carList.remove(VIN);
        if (removedCar == null) {
            System.out.println("The car does not exist");
        } else {
            System.out.println("Print all cars after removing a car VIN = " + VIN);
            System.out.println("The number of cars in the list = " + carList.size());
            printAllCars(carList);
        }
        System.out.println();

        VIN = "STU444";
        removedCar = carList.remove(VIN);
        if (removedCar == null) {
            System.out.println("The car does not exist");
        } else {
            System.out.println("Print all cars after removing a car VIN = " + VIN);
            System.out.println("The number of cars in the list = " + carList.size());
            printAllCars(carList);
        }
        System.out.println();

        VIN = "XYZ999";
        removedCar = carList.remove(VIN);
        if (removedCar == null) {
            System.out.println("The car does not exist");
        } else {
            System.out.println("Print all cars after removing a car VIN = " + VIN);
            System.out.println("The number of cars in the list = " + carList.size());
            printAllCars(carList);
        }
        System.out.println();
    }

}

