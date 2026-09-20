class Solution {
    public int reverseDegree(String s) {
        String alp="abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=1;i<=26;i++){
            map.put(alp.charAt(26-i),i); 
        }
        int ans=0;
        int idx=1;
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                ans+=idx*map.get(c);
                idx++;
            } 
        }
        return ans;
    }
}