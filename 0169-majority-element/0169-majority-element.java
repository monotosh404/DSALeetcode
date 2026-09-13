class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int x : nums) {
          int count = map.getOrDefault(x, 0) + 1;
            map.put(x, count);
            if (count > nums.length / 2) {
                return x;
            }
        }


return -1;
    }
}