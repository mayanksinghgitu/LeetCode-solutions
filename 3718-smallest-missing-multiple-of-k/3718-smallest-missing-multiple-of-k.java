class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set =new HashSet<>();
        for(int n : nums){
            if(n%k==0) set.add(n);
        }
        for(int i=1; i<=set.size();i++){
            if(!set.contains(k*i)){
                return k*i;
            }
        }
        return k*(set.size()+1);
    }
}