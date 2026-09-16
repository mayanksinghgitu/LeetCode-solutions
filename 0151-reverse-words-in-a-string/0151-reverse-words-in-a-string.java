class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        Stack<String> stk = new Stack<>();
        int i = s.length();
        for (int n = s.length() - 1; n >= 0; n--) {
            if (s.charAt(n) == ' ') {
                if (n + 1 < i) {
                    stk.push(s.substring(n + 1, i));
                }
                i = n;
            }
        }
        if (i > 0) {
            stk.push(s.substring(0, i));
        }
        return String.join(" ", stk);
    }
}