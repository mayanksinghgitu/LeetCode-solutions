class Solution {
    public int minMergedInteger(int[] nums) {
        int i=0;
        int j=1;
        int res=0;
        int ans=Integer.MAX_VALUE;
        while(j<nums.length){
            String tp=String.valueOf(nums[j]);
            res+=nums[i]*(int) Math.pow(10,tp.length());
            res+=nums[j];         
            ans=Math.min(res,ans);
            res=0;
            i+=2;
            j+=2;
        }
        return ans;
        
    }
}