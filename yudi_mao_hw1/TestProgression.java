
/**
 * CS526 Hw1
 * Name: Yudi Mao
 * BU ID: U39319244
 */

/**
 * Test our Hw1Progression
 */

public class TestProgression {
    public static void main(String[] args) {
        Progression prog;
        //test with default start (1)
        System.out.print("Hw1Progression with default start: ");
        prog = new Hw1Progression();
        prog.printProgression(10);
        //test with 5 as the start value
        System.out.print("Hw1Progression with 5 as the start value: ");
        prog = new Hw1Progression(5);
        prog.printProgression(10);
    }
}
