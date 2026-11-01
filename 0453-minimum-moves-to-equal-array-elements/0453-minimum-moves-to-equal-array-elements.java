class Solution {
    public int Min(int[] nums){
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
    public int minMoves(int[] nums) {
        int count=0;
        int min=Min(nums);
        for(int x : nums){
            count+=x-min;
        }
        return count;
    }
}