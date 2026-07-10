class Solution {
    private int n, m;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private int dfs(int[][] mat, boolean[][] vis, int x, int y, int xd, int yd) {

        if (x == xd && y == yd) {
            return 0;
        }

        vis[x][y] = true;
        int ans = -1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && mat[nx][ny] == 1 && !vis[nx][ny]) {

                int temp = dfs(mat, vis, nx, ny, xd, yd);

                if (temp != -1) {
                    ans = Math.max(ans, 1 + temp);
                }
            }
        }

        vis[x][y] = false; // Backtrack
        return ans;
    }

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        n = mat.length;
        m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        boolean[][] vis = new boolean[n][m];
        return dfs(mat, vis, xs, ys, xd, yd);
    }
}