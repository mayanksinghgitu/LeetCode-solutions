class Solution {
    public int sum1(int[] nums){
        int sum=0;
        for(int n : nums) sum+=n;
        return sum;
    }
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        return sum-sum1(nums);        
    }
}