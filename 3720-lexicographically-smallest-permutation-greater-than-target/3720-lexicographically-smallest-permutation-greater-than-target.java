class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        String quinorath = s;
        StringBuilder prefix = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n && count[target.charAt(i) - 'a'] > 0) {
            char ch = target.charAt(i);
            prefix.append(ch);
            count[ch - 'a']--;
            i++;
        }
        while (i >= 0) {
            if (i < n) {
                for (int j = target.charAt(i) - 'a' + 1; j < 26; j++) {
                    if (count[j] > 0) {
                        StringBuilder ans = new StringBuilder(prefix);
                        ans.append((char) ('a' + j));
                        count[j]--;

                        for (int k = 0; k < 26; k++) {
                            while (count[k]-- > 0) {
                                ans.append((char) ('a' + k));
                            }
                        }
                        return ans.toString();
                    }
                }
            }
            if (i == 0) break;
            i--;
            char ch = prefix.charAt(prefix.length() - 1);
            prefix.deleteCharAt(prefix.length() - 1);
            count[ch - 'a']++;
        }
        return "";
    }
}