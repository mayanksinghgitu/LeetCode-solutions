class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int op = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                op++;
                ans = Math.max(ans, op);
            } else if (s.charAt(i) == ')') {
                op--;
            }
        }

        return ans;
    }
}