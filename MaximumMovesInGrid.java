import java.util.Scanner;

public class MaximumMovesInGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows (m): ");
        int m = sc.nextInt();

        System.out.print("Enter the number of columns (n): ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter the elements of the grid:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = maximumMoves(grid);
        System.out.println("Maximum number of moves: " + result);

        sc.close();
    }

    public static int maximumMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        int maxMoves = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[i][j] = 1;

                if (i > 0 && grid[i][j] > grid[i - 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (i < m - 1 && grid[i][j] > grid[i + 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }
                if (grid[i][j] > grid[i][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }

                maxMoves = Math.max(maxMoves, dp[i][j]);
            }
        }

        return maxMoves;
    }
}
