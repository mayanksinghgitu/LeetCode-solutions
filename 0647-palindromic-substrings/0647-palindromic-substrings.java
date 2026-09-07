class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(IsPD(s,i,j)) count++;
            }
        }
        return count;
    }
    public boolean IsPD(String s,int strt,int finish){
        int st=strt;
        int end=finish;
        boolean Ispd=true;
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)) return !Ispd;
            st++;
            end--;
        }
        return Ispd;
    }
}