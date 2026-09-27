class Solution {
    public String longestCommonPrefix(String[] strs) {
        int mIdx=201;
        for(String t : strs){
            mIdx=Math.min(mIdx,len(strs[0],t));
        }
        return strs[0].substring(0, mIdx);
        
    }
    public int len(String s1,String s2){
        int ans=0;
        int n=Math.min(s1.length(),s2.length());
        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i)) ans++;
            else return ans;
        }
        return ans;
    }
}