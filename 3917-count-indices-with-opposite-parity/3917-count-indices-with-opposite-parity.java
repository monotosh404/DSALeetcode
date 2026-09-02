class Solution {
    public int[] countOppositeParity(int[] nums) {
        if(nums.length==1) return new int[] {0};
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]-nums[j])%2 != 0) count+=1;
            }
            nums[i]=count;
        }
        return nums;
    }
}