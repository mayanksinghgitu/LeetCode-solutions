class Solution {
    public int minAddToMakeValid(String s) {
        int cnt=0;
        Stack<Character> stk=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='('){
                stk.push(c);
            }
            else if(c==')' && !stk.isEmpty()){
                stk.pop();
            }
            else cnt++;
           
        }
        return cnt+stk.size();
    }
}