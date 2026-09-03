class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        for (int x : nums1) {
            mn = Math.min(mn, x);
        }
        if(mn%2==1)
            return true;
        for (int x : nums1) {
            if (x % 2 == 1) return false;
        }
        return true;
    }
}