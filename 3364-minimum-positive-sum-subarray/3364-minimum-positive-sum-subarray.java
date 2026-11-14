class Solution {
    public int SumChek(List<Integer> nums){
        int sum=0;
        for(int n : nums){
            sum+=n;
        }
        if(sum<1) return Integer.MAX_VALUE;
        return sum;
    }
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=i;j < i+r;j++){
                if(j>=nums.size()) break;
                temp.add(nums.get(j));
                if(temp.size()>=l && temp.size()<=r){
                    ans=Math.min(ans,SumChek(temp));
                }
            }
        }
        if(ans==0 || ans==Integer.MAX_VALUE) return -1;
        return ans;
        
    }
}