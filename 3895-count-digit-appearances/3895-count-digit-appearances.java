class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        for(int num:nums){
            while(num>0){
                if(num%10==digit)count+=1;
                num/=10;
            }
        }
        return count;
    }
}