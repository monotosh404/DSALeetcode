class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> map =new HashSet<>();
        for (int num=0;num<nums.length;num++){
            if(nums[num]%k==0){
                map.add(nums[num]/k);
            }
        }
        
        int i=1;
        while(true){
            if(!map.contains(i)) return k*i;
            else i++;
        }
    }
}