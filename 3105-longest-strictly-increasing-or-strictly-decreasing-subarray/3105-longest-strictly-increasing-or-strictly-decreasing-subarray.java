class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int i=0;
        int j=1;
        int IncLen=0;
        int DecLen=0;
        while(j<nums.length){
            if(nums[j-1]<nums[j]) j++;
            else{
                IncLen=Math.max(IncLen,j-i);
                i=j;
                j+=1;
            }
        }
        IncLen=Math.max(IncLen,j-i);
        i=0;
        j=1;
        while(i<j && j<nums.length){
            if(nums[j-1]>nums[j]) j++;
            else{
                DecLen=Math.max(DecLen,j-i);
                i=j;
                j++;
            }
        }
        IncLen=Math.max(IncLen,j-i);
        return Math.max(DecLen,IncLen); 
    }
}  