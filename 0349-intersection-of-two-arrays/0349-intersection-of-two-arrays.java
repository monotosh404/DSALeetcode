class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map1 =new HashSet<>();
         HashSet<Integer> map2 =new HashSet<>();
        for(int num:nums1){
            map1.add(num);
        }
        for(int num:nums2){
            if(map1.contains(num)){
                map2.add(num);
            }
        }
        int[] ans = new int[map2.size()];

        int i = 0;
        for (int num : map2) {
            ans[i] = num;
            i++;
        }

        return ans;
    }
}