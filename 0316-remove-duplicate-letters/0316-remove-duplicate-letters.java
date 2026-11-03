class Solution {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        Stack<Character> stk = new Stack<>();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (stk.contains(c)) {
                idx++;
                continue;
            }

            while (!stk.empty() && stk.peek() > c && map.get(stk.peek()) > idx) {
                stk.pop();
            }

            stk.push(c);
            idx++;
        }
        while (!stk.empty()) {
            char x = stk.pop();
            sb.append(x);
        }
        return sb.reverse().toString();
    }
}