class Solution {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        Stack<Character> stk = new Stack<>();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (visited[c - 'a']) {
                idx++;
                continue;
            }
            while (!stk.empty() && stk.peek() > c && map.get(stk.peek()) > idx) {
                char removed = stk.pop();
                visited[removed - 'a'] = false;
            }
            stk.push(c);
            visited[c - 'a'] = true;
            idx++;
        }
        while (!stk.empty()) {
            char x = stk.pop();
            sb.append(x);
        }
        return sb.reverse().toString();
    }
}