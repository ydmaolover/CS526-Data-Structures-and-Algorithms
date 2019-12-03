//package net.datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class HW5_Part2 {
    public static int evaluate(String expression) {

        char[] tokens = expression.toCharArray();

        //stack for operands and operators
        LinkedStack<Integer> Operand = new LinkedStack<>();
        LinkedStack<Character> Operator = new LinkedStack<>();


        for (int i = 0; i < tokens.length; i++) {
            //skip space and left parenthesis
            if (tokens[i] == ' ' || tokens[i] == '(') {
                continue;
            }

            // If token is an operand, push it to the operand stack
            else if (tokens[i] >= '0' && tokens[i] <= '9') {
                // a operand may contain multiple digits
                StringBuffer sbuf = new StringBuffer();
                while (tokens[i] >= '0' && tokens[i] <= '9') {
                    sbuf.append(tokens[i++]);

                }
                Operand.push(Integer.parseInt(sbuf.toString()));

            }
            // If token is an operator, push it to the operator stack
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                Operator.push(tokens[i]);

            }
            // If token is a right parenthesis, pop 2 operands, 1 operator from relevant stacks and apply it to operands
            // and push result back to operand stack
            else if (tokens[i] == ')') {
                Operand.push(applyOp(Operator.pop(), Operand.pop(), Operand.pop()));
            }
        }
        return Operand.top();
    }

    /* Calculation method
     */
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            // no need to throw exception cuz all operands assumed positive integers
        }
        return 0;
    }

    // Test main method
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("./infix_expressions.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                System.out.println("The result is " + evaluate(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
