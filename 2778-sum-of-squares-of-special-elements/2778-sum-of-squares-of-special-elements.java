class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        int sum=0;
        int i=1;
        for(int x : nums){
            if(n%i==0) sum+=x*x;
            i++;
        }
        if(sum!=0) return sum;
        else{
            return -1;
        }
        
    }
}