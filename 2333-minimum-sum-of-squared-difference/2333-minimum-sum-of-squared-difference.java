
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long K = (long) k1 + k2;
        int[] diff = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long low = 0, high = max;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= K) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long threshold = low;
        long ans = 0;
        long remaining = K;

        for (int d : diff) {
            if (d > threshold) {
                remaining -= d - threshold;
                ans += threshold * threshold;
            } else {
                ans += (long) d * d;
            }
        }
        long count = 0;

        for (int d : diff) {
            if (d >= threshold && threshold > 0) {
                count++;
            }
        }

        long reductions = Math.min(remaining, count);

        ans -= reductions * (2 * threshold - 1);

        return ans;
    }
}