
class Solution {
    public int minInsertions(String s) {
        int res=0;
        int cnt = 0;
        int i=0;
        int n=s.length();
        while(i<n){
            if(s.charAt(i)=='('){
                cnt++;
                i++;
            }
            else{
                if(cnt>0){
                    cnt--;
                }
                else{
                    res++;
                }
                if(i+1<n && s.charAt(i+1)==')') i+=2;
                else{
                    res++;
                    i++;
                }
            }
        }
        return res+(cnt*2);
       
        
    }
}
