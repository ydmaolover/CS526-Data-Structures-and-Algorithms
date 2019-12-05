
// you may change the import statement if needed

import net.datastructures.DefaultComparator;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

import java.util.Comparator;
import java.util.Random;

// generic binary search tree
public class MyBST<E> extends LinkedBinaryTree<E> {

    private Comparator<E> comp;
    private int size = 0;

    public MyBST(Comparator<E> c) {comp = c;}

    public MyBST() { this(new DefaultComparator<E>()); }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    public Position<E> add(Position<E> p, E e) {
        // implement this method
        if (p == null) { // this is an empty tree (t.root == null)
            addRoot(e);
            size++;
            return root;
        }

        Position<E> x = p; // x = t.root
        Position<E> y = x; //initialize y

        while (x != null) { // t.root != null
            Node<E> xNode = validate(x);
            if (comp.compare(xNode.getElement(), e) == 0) {
                return null;
            } else if (comp.compare(xNode.getElement(), e) > 0) {
                y = x;
                x = left(y);
            } else {
                y = x;
                x = right(y);
            }
        }

        Node<E> temp = createNode(e, null, null, null);
        Node<E> yNode = validate(y);
        temp.setParent(yNode);
        if (comp.compare(yNode.getElement(), e) > 0) {
            addLeft(y, e);
        } else {
            addRight(y, e);
        }
        size++;
        return temp;
    }


    // print a binary tree horizontally using indentation
    public void print(Position<E> p, int depth) {

        Node<E> n = validate(p);
        int i;

        for (i = 1; i <= depth; i++)
            System.out.print("    ");
        System.out.println(n.getElement());

        if (n.getLeft() != null)
            print(n.getLeft(), depth + 1);
        else if (n.getRight() != null) {
            for (i = 1; i <= depth + 1; i++)
                System.out.print("    ");
            System.out.println("--");
        }

        if (n.getRight() != null)
            print(n.getRight(), depth + 1);
        else if (n.getLeft() != null) {
            for (i = 1; i <= depth + 1; i++)
                System.out.print("    ");
            System.out.println("--");
        }
    }

    // print a binary tree using inorder tree traversal
    public void inorderPrint(Position<E> p) {
        if (p == null) return;
        Node<E> n = validate(p);
        inorderPrint(n.getLeft());
        System.out.print(n.getElement() + "  ");
        inorderPrint(n.getRight());
    }


    // calculate tree height
    public int BinaryTreeHeight(Position<E> p) {
        if (p == null) {
            return 0;
        } else {
            int left_h = BinaryTreeHeight(left(p));
            int right_h = BinaryTreeHeight(right(p));
            return Math.max(left_h, right_h) + 1;
        }
    }

    public static void main(String[] args) {

        // binary search tree stroing integers
        MyBST<Integer> t = new MyBST<>();

        // test add method
        //t.add(t.root, 100);
        //test if root exists now
        //System.out.println(t.root == null);
        //t.add(t.root, 50);
        //t.add(t.root, 150);
        //t.add(t.root, 70);
        //t.add(t.root, 30);
        //t.add(t.root, 130);
        //t.add(t.root, 140);
        //t.add(t.root, 120);

        //test result in pdf
        t.add(t.root, 90);
        t.add(t.root, 42);
        t.add(t.root, 92);
        t.add(t.root, 24);
        t.add(t.root, 73);
        t.add(t.root, 97);
        t.add(t.root, 66);
        t.add(t.root, 78);
        //add 70
        t.add(t.root, 70);

        int height = t.BinaryTreeHeight(t.root);


        System.out.println("Number of nodes is: " + t.size);
        System.out.println("Height of BST is " + height);

        System.out.println("Print tree horizontally using indentation: ");
        t.print(t.root, 0);
        System.out.println("\n");

        System.out.println("Print tree by inorder traversal: ");
        t.inorderPrint(t.root);

        System.out.println("\n");


        // average height experiment
        int total_h = 0;
        // generate 10 trees
        for (int i = 0; i < 100; i++) {
            // initiallize BST
            MyBST<Integer> exp = new MyBST<>();
            //generate random int, add into BST
            while (exp.size < 1000) {
                int e;
                Random r = new Random();
                r.setSeed(System.currentTimeMillis());
                e = r.nextInt(1000000);
                exp.add(exp.root, e);
            }
            int h = exp.height(exp.root);
            System.out.println("Height = " + h + ", Size = " + exp.size);
            total_h += h;
        }
        double ave_h = total_h / 100.0;
        System.out.println("Average height = " + ave_h);
    }

}
