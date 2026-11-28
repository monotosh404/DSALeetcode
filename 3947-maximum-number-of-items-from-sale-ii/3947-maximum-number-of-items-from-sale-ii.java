
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        // Find maximum factor and minimum price
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count frequency of each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Count how many item types each factor can unlock
        int[] gain = new int[maxFactor + 1];

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--; // Exclude the item itself
        }

        // Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget;
        long answer = 0;

        // Buy items that provide an additional free item
        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            // Not beneficial compared with buying two cheapest items
            if (price >= 2L * minPrice) {
                break;
            }

            int freeItems = gain[factor];

            if (freeItems <= 0) {
                continue;
            }

            long take = Math.min(freeItems, remaining / price);

            answer += take * 2;
            remaining -= take * price;
        }

        // Spend remaining budget on the cheapest item
        answer += remaining / minPrice;

        return (int) answer;
    }
}
