class Solution {
    public int[] transformArray(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }
            else nums[i]=1;
        }
        
        for(int i=1;i<nums.length;i++){
            if(nums[j]>nums[i]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
            if(nums[j]==0) j++;
            
        }
        return nums;
    }
}