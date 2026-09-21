class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            next[num % k]++;

            for (int j = 0; j < k; j++) {
                if (dp[j] > 0) {
                    next[(int)((j * (long)num) % k)] += dp[j];
                }
            }

            for (int j = 0; j < k; j++) {
                ans[j] += next[j];
            }

            dp = next;
        }

        return ans;
    }
}