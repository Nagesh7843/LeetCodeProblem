
class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];

        SegmentTree st = new SegmentTree(n);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            int prev = last[x];
            st.update(prev, i, 1);
            last[x] = i + 1;
            ans = (ans + st.query(0, i)) % MOD;
        }

        return (int) ans;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] sumSq;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;

            sumSq[node] = (
                sumSq[node]
                + 2L * val % MOD * sum[node] % MOD
                + len % MOD * val % MOD * val % MOD
            ) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) {
                return;
            }

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            lazy[node] = 0;
        }

        void pull(int node) {
            sum[node] = (
                sum[node * 2] + sum[node * 2 + 1]
            ) % MOD;

            sumSq[node] = (
                sumSq[node * 2] + sumSq[node * 2 + 1]
            ) % MOD;
        }

        void update(int ql, int qr, long val) {
            if (ql > qr) return;
            update(1, 0, n - 1, ql, qr, val);
        }

        void update(int node, int l, int r,
                    int ql, int qr, long val) {
            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            if (ql <= mid) {
                update(node * 2, l, mid, ql, qr, val);
            }

            if (qr > mid) {
                update(node * 2 + 1, mid + 1, r,
                       ql, qr, val);
            }

            pull(node);
        }

        long query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        long query(int node, int l, int r,
                   int ql, int qr) {
            if (ql <= l && r <= qr) {
                return sumSq[node];
            }

            push(node, l, r);
            int mid = (l + r) / 2;
            long result = 0;

            if (ql <= mid) {
                result += query(node * 2, l, mid,
                                ql, qr);
            }

            if (qr > mid) {
                result += query(node * 2 + 1, mid + 1, r,
                                ql, qr);
            }

            return result % MOD;
        }
    }
}
