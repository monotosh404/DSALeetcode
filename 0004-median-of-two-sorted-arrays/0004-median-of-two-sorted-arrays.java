class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=nums1.length,l=nums2.length,n=0;
        int nums3[]=new int[k+l];
        while(i<k&&j<l){
            if(nums1[i]<nums2[j]){
                nums3[n]=nums1[i];
                n++;
                i++;
            }
            else{
                 nums3[n]=nums2[j];
                j++;
                n++;
            }
        }
        while(i<k){
            nums3[n++]=nums1[i++];
        }
         while(j<l){
            nums3[n++]=nums2[j++];
        }
        int sum=0;
    
        if(nums3.length%2!=0){
            return nums3[(nums3.length+1)/2-1];
        }
        else
        return  (nums3[nums3.length/2-1]+nums3[nums3.length/2])/2.0;
    
    
    }
}