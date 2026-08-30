class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        int expected = 1;

        for(int num : nums) {
            if(num == expected) {
                expected++;
            }
            else if(num > expected) {
                while(expected < num) {
                    list.add(expected);
                    expected++;
                }
                expected++;
            }
        }

        while(expected <= nums.length) {
            list.add(expected);
            expected++;
        }

        return list;
    }
}