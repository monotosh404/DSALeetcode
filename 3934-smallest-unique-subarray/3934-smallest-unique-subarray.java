import java.util.*;

class Solution {
    private static final long BASE1 = 100019;
    private static final long BASE2 = 100043;

    private static final long MOD1 = 1000000007;
    private static final long MOD2 = 1000000009;

    public int smallestUniqueSubarray(int[] nums) {
        int left = 1;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (hasUnique(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean hasUnique(int[] nums, int len) {
        int n = nums.length;

        long pow1 = 1;
        long pow2 = 1;

        for (int i = 0; i < len; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        long hash1 = 0;
        long hash2 = 0;

        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * BASE1 + nums[i]) % MOD1;
            hash2 = (hash2 * BASE2 + nums[i]) % MOD2;
        }

        HashMap<String, Integer> map = new HashMap<>();

        map.put(hash1 + "," + hash2, 1);

        for (int i = len; i < n; i++) {

            hash1 = (hash1 * BASE1 + nums[i]
                    - pow1 * nums[i - len] % MOD1 + MOD1) % MOD1;

            hash2 = (hash2 * BASE2 + nums[i]
                    - pow2 * nums[i - len] % MOD2 + MOD2) % MOD2;

            String key = hash1 + "," + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}