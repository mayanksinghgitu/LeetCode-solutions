class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean findFirst) {
        int st = 0;
        int en = nums.length - 1;
        int ans = -1;

        while (st <= en) {
            int mid = st + (en - st) / 2;

            if (nums[mid] == target) {
                ans = mid;

                if (findFirst) {
                    en = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }

        return ans;
    }
}