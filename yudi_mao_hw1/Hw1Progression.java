
/**
 * CS526 Hw1
 * Name: Yudi Mao
 * BU ID: U39319244
 */

/**
 * Hw1Progression is inherited from Progression.java.
 */

public class Hw1Progression extends Progression {
    /**
     * Constructs progression starts with 1, 2, 3, 7, 8, ...
     */
    public Hw1Progression() {
        this(1);
    }

    /**
     * Constructs progression with arbitrary start
     */
    public Hw1Progression(long start) {
        super(start);
    }

    /**
     * To determine advance logic
     */
    protected void advance() {
        if (current % 2 == 0) {
            current = 2 * current - 1;
        } else if (current % 3 == 0 && current % 2 != 0) {
            current = 3 * current - 2;
        } else {
            current++;
        }
    }
}


