class Solution {
    public String removeOuterParentheses(String s) {
        int cnt=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                if(cnt!=0) sb.append(c);
                cnt++;
            }
            else{
                cnt--;
                if(cnt!=0){
                    sb.append(c);
                }
            }

        }
        return sb.toString();
    }
}