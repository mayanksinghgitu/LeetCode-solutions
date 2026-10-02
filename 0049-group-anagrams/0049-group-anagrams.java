class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0 || strs==null) return new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s : strs){
            String ss=getFrequencyString(s);
            if(map.containsKey(ss)){
                map.get(ss).add(s);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(ss,list);
            }
        }
        return new ArrayList<>(map.values());

    }
    private static String getFrequencyString(String s) {
        int[] frq = new int[26];
        for (char c : s.toCharArray()) {
            frq[c - 'a']++;
        }
        StringBuilder st = new StringBuilder("");
        char c = 'a';
        for(int i : frq){
            if(i!=0){
                st.append(c);
                st.append(i);
            }
            c++;
        }
        return st.toString();
    }
}