class Solution {
    public int[] singleNumber(int[] nums) {
       HashSet<Integer> map=new HashSet<>();
       for(int num:nums){
        if(map.contains(num)) {
            map.remove(num);
            continue;
        }
           map.add(num); 
       }
       int[] result = new int[2];

int i = 0;
for (int key : map) {
    result[i] = key;
    i++;
}

return result;
    }
}