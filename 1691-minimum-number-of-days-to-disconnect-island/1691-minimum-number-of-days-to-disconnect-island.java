class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Check if the grid is already disconnected or empty
        if (countIslands(grid) != 1) {
            return 0;
        }

        // Try changing each land cell to water and check if the grid becomes disconnected
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1; // Restore the original grid
                }
            }
        }

        // If no single change disconnects the grid, return 2
        return 2;
    }

    private int countIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }
}
