class Solution {
    public boolean isMonotonic(int[] nums) {
        // int count1=0;
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i] <= nums[i+1]) count1+=1;
        // }
        // if(count1==nums.length-1) return true;
        
        //  int count2=0;
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i] >= nums[i+1]) count2+=1;
        // }
        // if(count2==nums.length-1) return true;
        // return false;
        // int inc=0;
        // int dec=0;
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i] <= nums[i + 1]) inc++;
        //     if(nums[i] >= nums[i + 1]) dec++;
            
        // }
        // if(inc==nums.length-1 || dec==(nums.length-1)) return true;
        // else return false;
    
        boolean increasing = true;
        boolean decreasing = true;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1])
                increasing = false;

            if(nums[i] < nums[i + 1])
                decreasing = false;
        }

        return increasing || decreasing;
    
    }
}