class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk=new Stack<>();
        ArrayList<Character> list =new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
                stk.push(s.charAt(i));
            }
            else if (s.charAt(i)==')'){
                while(!stk.isEmpty()){
                    char c=stk.peek();
                    stk.pop();
                    if(c=='('){
                        break;
                    }
                    list.add(c);
                }
                for(char x : list){
                    stk.push(x);
                }
                list.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();        
    }
}