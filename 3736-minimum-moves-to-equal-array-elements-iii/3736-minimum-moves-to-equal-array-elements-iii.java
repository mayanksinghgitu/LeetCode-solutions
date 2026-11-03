class Solution {
    public int minMoves(int[] nums) {
        int count=0;
        int max = nums[0];
        for (int x : nums) {
            if (x > max) {
                max = x;
            }
        }
        for(int x : nums){
            count+=max-x;
        }
        return count;
    }
}