class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long ans = 0;

        SegmentTree st = new SegmentTree(n);
        int[] last = new int[100001];

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];

            st.update(prev, i, 1);
            ans = (ans + st.querySquareSum()) % MOD;

            last[x] = i + 1;
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum, sq, lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long v) {
            long len = r - l + 1L;

            sq[node] = (sq[node] + 2 * v * sum[node]
                    + len * v % MOD * v) % MOD;

            sum[node] = (sum[node] + len * v) % MOD;
            lazy[node] = (lazy[node] + v) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        void update(int ql, int qr, int v) {
            if (ql > qr) return;
            update(1, 0, n - 1, ql, qr, v);
        }

        void update(int node, int l, int r,
                    int ql, int qr, long v) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, v);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            if (ql <= mid)
                update(node * 2, l, mid, ql, qr, v);

            if (qr > mid)
                update(node * 2 + 1, mid + 1, r, ql, qr, v);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        }

        long querySquareSum() {
            return sq[1];
        }
    }
}