class Solution {
    public int SumDight(int n){
        int sum=0;
        while(n>9){
            int val=n%10;
            sum+=val;
            n=(n-val)/10;
        }
        return sum+n;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(SumDight(nums[i])==i) return i;
        }
        return -1;
        
    }
}