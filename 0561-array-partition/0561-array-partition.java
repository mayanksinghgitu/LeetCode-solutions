class Solution {
    public int arrayPairSum(int[] nums) {
        int ans=0;
        int i=0;
        Arrays.sort(nums);
        while(i<nums.length){
            ans=ans+nums[i];
            i=i+2;
        }
        return ans;
    }
}