class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        int m = n / 2;

        int[] temp = half.clone();
        boolean possible = true;

        for (int i = 0; i < m; i++) {
            int x = target.charAt(i) - 'a';

            if (temp[x] == 0) {
                possible = false;
                break;
            }

            temp[x]--;
        }

        if (possible) {
            StringBuilder left = new StringBuilder();

            for (int i = 0; i < m; i++) {
                left.append(target.charAt(i));
            }

            StringBuilder right = new StringBuilder(left).reverse();

            String ans = left.toString()
                    + (n % 2 == 1 ? mid : "")
                    + right;

            if (ans.compareTo(target) > 0) {
                return ans;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            int[] remaining = half.clone();
            boolean valid = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (remaining[x] == 0) {
                    valid = false;
                    break;
                }

                remaining[x]--;
            }

            if (!valid) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {
                if (remaining[c] == 0) {
                    continue;
                }

                remaining[c]--;

                StringBuilder left = new StringBuilder();

                for (int j = 0; j < i; j++) {
                    left.append(target.charAt(j));
                }

                left.append((char) ('a' + c));

                for (int j = 0; j < 26; j++) {
                    while (remaining[j] > 0) {
                        left.append((char) ('a' + j));
                        remaining[j]--;
                    }
                }

                StringBuilder ans = new StringBuilder(left);

                if (n % 2 == 1) {
                    ans.append(mid);
                }

                for (int j = left.length() - 1; j >= 0; j--) {
                    ans.append(left.charAt(j));
                }

                return ans.toString();
            }
        }

        return "";
    }
}