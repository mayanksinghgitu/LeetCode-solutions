class Solution {
    public int Min(int[] nums){
        int min=nums[0];
        for(int x: nums){
            min=Math.min(min,x);
        }
        return min;
    }
    public int minMoves(int[] nums) {
        int count=0;
        int min=Min(nums);
        for(int i=0;i<nums.length;i++){
            count+=nums[i]-min;
        }
        return count;
    }
}