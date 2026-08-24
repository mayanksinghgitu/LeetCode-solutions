class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int prefixSum = 0;
        for (int stone : stones) {
            prefixSum += stone;
        }
        int best = prefixSum;
        for (int i = n - 2; i >= 1; i--) {
            prefixSum -= stones[i + 1];
            best = Math.max(best, prefixSum - best);
        }

        return best;
    }
}