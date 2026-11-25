import java.util.Arrays;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n;
        int ans = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueSubarray(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean hasUniqueSubarray(int[] nums, int len) {
        int n = nums.length;
        if (len == n) return true;
        
        long base1 = 100003, mod1 = 1_000_000_007;
        long base2 = 100019, mod2 = 1_000_000_009;
        
        long hash1 = 0, hash2 = 0;
        long power1 = 1, power2 = 1;
        
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * base1 + nums[i]) % mod1;
            hash2 = (hash2 * base2 + nums[i]) % mod2;
            if (i < len - 1) {
                power1 = (power1 * base1) % mod1;
                power2 = (power2 * base2) % mod2;
            }
        }
        
        long[] hashes = new long[n - len + 1];
        hashes[0] = (hash1 << 32) | hash2;
        
        for (int i = len; i < n; i++) {
            hash1 = (hash1 - (nums[i - len] * power1) % mod1 + mod1) % mod1;
            hash1 = (hash1 * base1 + nums[i]) % mod1;
            
            hash2 = (hash2 - (nums[i - len] * power2) % mod2 + mod2) % mod2;
            hash2 = (hash2 * base2 + nums[i]) % mod2;
            
            hashes[i - len + 1] = (hash1 << 32) | hash2;
        }
        
        Arrays.sort(hashes);
        
        for (int i = 0; i < hashes.length; i++) {
            boolean isUnique = true;
            if (i > 0 && hashes[i] == hashes[i - 1]) isUnique = false;
            if (i < hashes.length - 1 && hashes[i] == hashes[i + 1]) isUnique = false;
            
            if (isUnique) return true;
        }
        
        return false;
    }
}