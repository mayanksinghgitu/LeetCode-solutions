
class Solution {
    public int minInsertions(String s) {
        int op = 0;
        int cl = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (cl % 2 == 1) {
                    op++;
                    cl--;
                }
                cl += 2;
            } else {
                cl--;
                if (cl < 0) {
                    op++;
                    cl = 1;
                }
            }
        }

        return op + cl;
    }
}
