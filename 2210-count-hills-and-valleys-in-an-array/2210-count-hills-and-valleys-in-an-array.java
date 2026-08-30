class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == prev) continue;

            int j = i + 1;

            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }

            if (j < nums.length) {
                if ((nums[i] > prev && nums[i] > nums[j]) ||
                    (nums[i] < prev && nums[i] < nums[j])) {
                    count++;
                }
            }

            prev = nums[i];
        }

        return count;
    }
}