package com.rickmune.dsproblems;

public class PathInMaze {

    private static int findPathCount(int[][] grid) {

        int r = 4;
        int c = 4;

        if (grid[0][0] == -1) return 0;

        for (int i = 0; i < r; i++) {
            if (grid[i][0] == 0)
                grid[i][0] = 1;
            else
                break;
        }

        for (int i = 1; i < c; i++) {
            if (grid[0][i] == 0)
                grid[0][i] = 1;
            else
                break;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (grid[i][j] == -1) continue;

                if (grid[i - 1][j] > 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }

                if (grid[i][j - 1] > 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
            }
        }

        return grid[r - 1][c - 1];
    }

    // Driver code

    public static void main(String[] args) {
        int maze[][] = {
                {0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(findPathCount(maze));

    }
}
