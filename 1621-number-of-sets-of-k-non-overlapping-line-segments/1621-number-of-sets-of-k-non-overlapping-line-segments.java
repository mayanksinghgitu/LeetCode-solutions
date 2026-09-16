class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1000000007;
        int total = n + k - 1;
        int m = 2 * k;
        long[][] dp = new long[total + 1][m + 1];
        
        for (int i = 0; i <= total; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, m); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        
        return (int) dp[total][m];
    }
}