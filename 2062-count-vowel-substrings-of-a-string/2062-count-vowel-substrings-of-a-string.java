class Solution {
    public int countVowelSubstrings(String word) {
        String vovel="aeiou";
        HashSet<Character> set=new HashSet<>();
        for(char c : vovel.toCharArray()){
            set.add(c);
        }
        int ans=0;
        for(int i=0;i<word.length();i++){
            if(set.contains(word.charAt(i))){
                int count=0;
                for(int j=i;j<word.length();j++){
                    if (!set.contains(word.charAt(j))) {
                        break;
                    }
                    count = (int)word.substring(i,j+1).chars().distinct().count();
                    if(count==5) ans++;            
                }
            }
        }
        return ans;
    }
}