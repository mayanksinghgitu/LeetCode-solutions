class Solution {
    public int Cheek(int n){
        if(n<1) return Integer.MAX_VALUE;
        return n;
    }
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            int track=0;
            int size=0;
            for(int j=i;j < i+r;j++){
                if(j>=nums.size()) break;
                track+=nums.get(j);
                size++;
                if(size>=l && size<=r){
                    ans=Math.min(ans,Cheek(track));
                }
            }
        }
        if(ans==0 || ans==Integer.MAX_VALUE) return -1;
        return ans;
        
    }
}