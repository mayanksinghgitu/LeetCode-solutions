class Solution {
    public int countElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        int ans = 0;
        for (int n : nums) {
            if (n > min && n < max)
                ans++;
        }
        return ans;
    }
}