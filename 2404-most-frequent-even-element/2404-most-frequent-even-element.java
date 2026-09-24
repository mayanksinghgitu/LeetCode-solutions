class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (n % 2 == 0) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        int ans = -1;
        int maxFreq = 0;
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (freq > maxFreq) {
                maxFreq = Math.max(maxFreq, freq);
                ans = num;
            } 
            else if (freq == maxFreq) {
                if (ans == -1 || num < ans) {
                    ans = num;
                }
            }
        }
        return ans;
    }
}