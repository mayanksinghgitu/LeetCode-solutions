class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int score=0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                if (v == 0) {
                    score = 1;
                } else {
                    score = 2 * v;
                }
                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
    }
}