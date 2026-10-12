
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;
        int[] bits = new int[31];
        for (int num : nums) {
            for (int j = 0; j < 31; j++) {
                if ((num & (1 << j)) != 0) {
                    bits[j]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long x = 0;

            for (int j = 0; j < 31; j++) {
                if (bits[j] > 0) {
                    x |= (1L << j);
                    bits[j]--;
                }
            }
            ans = (ans + x * x) % MOD;
        }
        return (int) ans;
    }
}
