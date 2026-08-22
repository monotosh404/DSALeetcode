class Solution {
    public int reverse(int x) {
        int y = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow before updating y
            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Positive overflow
            }
            if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Negative overflow
            }

            y = y * 10 + digit;
            x /= 10;
        }
        return y;
    }
}
