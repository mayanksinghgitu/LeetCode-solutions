class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for (int i=s.length()-1;i>=0;i--) {
            char c=s.charAt(i);
            stack.push(c);
        }
        if(stack.isEmpty()) return stack.isEmpty();
        for(int i=0;i<t.length();i++){
            if(!stack.isEmpty() && stack.peek()==t.charAt(i)){
                stack.pop();
            }
        }
        return stack.isEmpty();
        
    }
}