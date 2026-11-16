
class Solution {
    public String shorten(String s, int k) {
        int sum = 0;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(i != 0 && i % k == 0) {
                ans.append(sum);
                sum = 0;
            }

            sum += s.charAt(i) - '0';
        }

        ans.append(sum);
        return ans.toString();
    }

    public String digitSum(String s, int k) {
        while(s.length() > k) {
            s = shorten(s, k);
        }

        return s;
    }
}
