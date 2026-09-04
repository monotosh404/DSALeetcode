class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
           int min=Integer.MAX_VALUE;
            if(nums[i]>max)max=nums[i];
            for(int j=i;j<nums.length;j++){

                if(nums[j]<min) min=nums[j];
            }
            if(max-min<=k) {
                return i;
            }
        }
        return -1;
    }
}