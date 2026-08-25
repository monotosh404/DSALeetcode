class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (true) {

            if (n == 1) {
                return true;
            }

            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            int sum = 0;

            while (n > 0) {
                int rem = n % 10;
                n /= 10;

                sum += rem * rem;
            }

            n = sum;
        }
    }
}