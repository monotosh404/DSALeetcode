class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        char maxDigit = '0';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                maxDigit = c;
                break;
            }
        }

        char minDigit = s.charAt(0);

        int max = Integer.parseInt(s.replace(maxDigit, '9'));
        int min = Integer.parseInt(s.replace(minDigit, '0'));

        return max - min;
    }
}