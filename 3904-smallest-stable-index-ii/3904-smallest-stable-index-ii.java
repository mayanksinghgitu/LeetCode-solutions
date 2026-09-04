class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] Min = new int[n];
        int[] Max = new int[n];

        int max = nums[0];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            Max[i] = max;
        }

        int min = nums[n - 1];

        for (int j = n - 1; j >= 0; j--) {
            min = Math.min(min, nums[j]);
            Min[j] = min;
        }

        for (int j = 0; j < n; j++) {
            if (Max[j] - Min[j] <= k) {
                return j;
            }
        }

        return -1;
    }
}