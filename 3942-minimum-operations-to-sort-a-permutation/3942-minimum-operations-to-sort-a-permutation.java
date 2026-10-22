
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        boolean inc = true;
        boolean dec = true;

        for (int i = 1; i < n; i++) {
            int prevInc = (zero + i - 1) % n;
            int currInc = (zero + i) % n;

            if (nums[prevInc] > nums[currInc]) {
                inc = false;
            }

            int prevDec = (zero - i + 1 + n) % n;
            int currDec = (zero - i + n) % n;

            if (nums[prevDec] > nums[currDec]) {
                dec = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (inc) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        if (dec) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
