class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(s.length()<=1)  return true;
        boolean ans=false;
        int i=0;
        int j=s.length()-1;
        while(j>i){
            if(s.charAt(j)==s.charAt(i)){
                ans=true;
            }
            else{
                return false;
            }
            i++;
            j--;
        }
        return ans;       
    }
}