class Solution {
    public boolean validPalindrome(String s) {
        int st=0;
        int en=s.length()-1;
        boolean chek=true;
        while(st<en){
            if(s.charAt(st)==s.charAt(en)){
                st++;
                en--;
            }
            else{
                return CheekPalindrome(st+1,en,s) || CheekPalindrome(st,en-1,s);
            } 
        }
        return true;
    }
    public static boolean CheekPalindrome(int st,int en,String s) {
        while(st<en){
            if(s.charAt(st)!=s.charAt(en)) return false;
            st++;
            en--;
        }
        return true;
    }
}