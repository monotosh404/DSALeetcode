class Solution {
    public int dominantIndex(int[] nums) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int index =0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > largest) {
               secondLargest = largest;
                largest = nums[i];
                 index=i;
              }
             else if (nums[i] > secondLargest && nums[i] != largest) {
                  secondLargest = nums[i];
                }
             }
             if(largest>=2*secondLargest) return index;
             else return -1;

           }
         }