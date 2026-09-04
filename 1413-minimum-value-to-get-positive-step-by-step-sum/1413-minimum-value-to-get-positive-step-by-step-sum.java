class Solution {
    public int minStartValue(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        for(int num:nums){
            min=Math.min(min,num);
        }
        return min<0? 1-min: 1;
    }
}