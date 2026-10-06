class Solution {
    public int minAddToMakeValid(String s) {
        int cnt=0;
        int ph=0;
        Stack<Character> stk=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='('){
                ph++;
            }
            else if(c==')' && ph!=0){
                ph--;
            }
            else cnt++;
           
        }
        return cnt+ph;
    }
}