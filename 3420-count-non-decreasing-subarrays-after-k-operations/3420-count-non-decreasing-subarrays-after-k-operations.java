class Solution {
    public long countNonDecreasingSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;

        int left = 0;
        long maxSoFar = 0;

        for (int right = 0; right < n; right++) {
            maxSoFar = Math.max(maxSoFar, nums[right]);
            cost += maxSoFar - nums[right];
            while (cost > k) {
                left++;
                cost = 0;
                maxSoFar = 0;
                for (int i = left; i <= right; i++) {
                    maxSoFar = Math.max(maxSoFar, nums[i]);
                    cost += maxSoFar - nums[i];
                }
            }

            ans += (right - left + 1);
        }

        return ans;
    }
}
