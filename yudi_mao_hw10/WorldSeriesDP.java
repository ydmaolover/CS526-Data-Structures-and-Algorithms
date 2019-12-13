

public class WorldSeriesDP {

    /**
     * Print 2D Matrix
     */
    public static void prind2D(double mat[][]) {
        // Loop through all rows
        for (double[] row : mat) {
            // Loop through all columns of current row
            for (double x : row) {
                System.out.print(String.format("%.2f", x) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create matrix
        int len1 = 7;
        int len2 = 7;
        double Prob[][] = new double[len1][len2];

        // Solve P(0, j), P(i, 0)
        for (int i = 0; i < len1 - 1; i++) {
            Prob[i][len2 - 1] = 1;
        }
        for (int j = 0; j < len2 - 1; j++) {
            Prob[len1 - 1][j] = 0;
        }

        // Dynamic
        for (int l = 10; l >= 0; l--) {
            for (int m = 0; m < len1 - 1; m++) {
                for (int n = 0; n < len2 - 1; n++) {
                    if (m + n == l) {
                        Prob[m][n] = (Prob[m + 1][n] + Prob[m][n + 1]) / 2;
                    }
                }
            }

        }

        // Print matrix
        prind2D(Prob);

    }
}
