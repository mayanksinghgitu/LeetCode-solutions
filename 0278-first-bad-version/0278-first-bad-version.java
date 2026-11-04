public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st = 1;
        int en = n;
        while (st < en) {
            int mid = st + (en - st) / 2;
            if (isBadVersion(mid)) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}