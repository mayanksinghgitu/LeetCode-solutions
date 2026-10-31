class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int j = c + 1;
                if (grid[r][c] == 1) {
                    long newRight = dp[j][1];
                    long newDown = dp[j - 1][0];
                    dp[j][0] = newRight % MOD;
                    dp[j][1] = newDown % MOD;
                } else {
                    long val = (dp[j][1] + dp[j - 1][0]) % MOD;
                    dp[j][0] = val;
                    dp[j][1] = val;
                }
            }
        }
        
        return (int) dp[n][0];
    }
}