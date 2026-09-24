class Solution {
    public boolean isGoodArray(int[] nums) {
        if(nums.length==1 && nums[0]==1) return true;
        int a = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int b = nums[i];

            while(b != 0) {
                int remainder = a % b;
                a = b;
                b = remainder;
            }

            if(a == 1) return true;
        }

        return false;
    }
}