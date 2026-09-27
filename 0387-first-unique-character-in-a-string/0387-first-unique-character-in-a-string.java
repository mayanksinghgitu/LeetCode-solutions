class Solution {
    public int firstUniqChar(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        HashSet<Character> GarBset = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(GarBset.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }
            else{
                set.add(s.charAt(i));
                GarBset.add(s.charAt(i));
            }
        }
        GarBset.clear();
        if(set.isEmpty()) return -1;
         char first = set.iterator().next();
        for (int i = 0; i < s.length(); i++) {
            if (first == s.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
