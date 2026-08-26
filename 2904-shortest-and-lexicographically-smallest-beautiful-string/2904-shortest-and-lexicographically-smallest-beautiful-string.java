class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String answer = "";
        int left = 0;
        int countOnes = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }

            while (countOnes > k) {
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }

            while (countOnes == k && s.charAt(left) == '0') {
                left++;
            }

            if (countOnes == k) {
                String current = s.substring(left, right + 1);

                if (answer.isEmpty()
                        || current.length() < answer.length()
                        || (current.length() == answer.length()
                        && current.compareTo(answer) < 0)) {
                    answer = current;
                }
            }
        }

        return answer;
    }
}