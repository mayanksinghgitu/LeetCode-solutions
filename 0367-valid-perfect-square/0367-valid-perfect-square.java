class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long st = 1;
        long en = num / 2;

        while (st <= en) {
            long mid = st + (en - st) / 2;

            if (mid == num / mid && num % mid == 0) {
                return true;
            } else if (mid < num / mid) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }

        return false;
    }
}