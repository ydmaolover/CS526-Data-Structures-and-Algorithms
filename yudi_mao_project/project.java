import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class project {


    public static void main(String[] args) throws Exception {

        /**
         *Input direct_distance.txt, spilt vertex and distance and store them into lists
         */
        List<String> vertex = new ArrayList<>();
        List<Integer> dd = new ArrayList<>();

        String Path1 = "./direct_distance.txt";
        FileInputStream fin1 = new FileInputStream(Path1);
        InputStreamReader reader1 = new InputStreamReader(fin1);
        BufferedReader buffReader1 = new BufferedReader(reader1);
        String strTmp1 = "";
        while ((strTmp1 = buffReader1.readLine()) != null) {
            int d = Integer.parseInt(strTmp1.replaceAll("[A-Z]+\\s", ""));
            String vTmp = strTmp1.replaceAll("[0-9]", "");
            String v = vTmp.replaceAll(" ", "");
            //test input
            //System.out.println(d);
            dd.add(d);
            //System.out.println(v);
            vertex.add(v);
        }
        buffReader1.close();

        /**
         *Input graph_input.txt, store weight into list
         */
        int n = dd.size(); //number of nodes
        //System.out.println(n);
        String[][] weight = new String[n + 1][n + 1];
        int index = 0;

        String Path2 = "./graph_input.txt";
        FileInputStream fin2 = new FileInputStream(Path2);
        InputStreamReader reader2 = new InputStreamReader(fin2);
        BufferedReader buffReader2 = new BufferedReader(reader2);
        String strTmp2 = "";
        while ((strTmp2 = buffReader2.readLine()) != null) {
            weight[index] = strTmp2.split("\\s+");
            index++;
        }

        //test input
        //System.out.println(vertex.get(1));
        //System.out.println(dd.get(1));
        //System.out.println(weight[11][21]);

        /**
         * User input start node
         */
        System.out.println("Type start node represented by a single uppercase letter:");
        Scanner scan = new Scanner(System.in);
        String start_node = scan.next();
        while (!vertex.contains(start_node)) {
            System.out.println("Node not found, try again:");
            Scanner scan1 = new Scanner(System.in);
            start_node = scan1.next();
        }
        //test input
        //System.out.println(start_node);

        Algorithm1.get_shortest_path(start_node, vertex, dd, weight);
        System.out.println();
        Algorithm1.get_shortest_path_2(start_node, vertex, dd, weight);
        //System.out.println(Algorithm1.get_adjacent_node_2(start_node, vertex, dd, weight));
    }
}
