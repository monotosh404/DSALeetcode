import java.util.*;

class Solution {

    static class State {
        long score;
        int[] ids;

        State(long score, int[] ids) {
            this.score = score;
            this.ids = ids;
        }
    }

    int n;
    int[][] a;
    State[][] memo;
    boolean[][] seen;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by starting point
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0])
                return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        memo = new State[n][5];
        seen = new boolean[n][5];

        State ans = solve(0, 4);

        return ans.ids;
    }

    private State solve(int i, int k) {

        if (i == n || k == 0) {
            return new State(0, new int[0]);
        }

        if (seen[i][k])
            return memo[i][k];

        seen[i][k] = true;

        // Don't take current interval
        State skip = solve(i + 1, k);

        // Take current interval
        int next = findNext(i);

        State nextState = solve(next, k - 1);

        int[] takeIds = new int[nextState.ids.length + 1];

        takeIds[0] = a[i][3];

        for (int j = 0; j < nextState.ids.length; j++) {
            takeIds[j + 1] = nextState.ids[j];
        }

        Arrays.sort(takeIds);

        State take = new State(
            (long) a[i][2] + nextState.score,
            takeIds
        );

        memo[i][k] = better(take, skip);

        return memo[i][k];
    }

    private int findNext(int i) {

        int left = i + 1;
        int right = n;

        int end = a[i][1];

        while (left < right) {

            int mid = (left + right) >>> 1;

            if (a[mid][0] > end)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private State better(State a, State b) {

        // Higher score is better
        if (a.score != b.score)
            return a.score > b.score ? a : b;

        // Same score -> lexicographically smaller indices
        int len = Math.min(a.ids.length, b.ids.length);

        for (int i = 0; i < len; i++) {

            if (a.ids[i] != b.ids[i])
                return a.ids[i] < b.ids[i] ? a : b;
        }

      
        return a.ids.length <= b.ids.length ? a : b;
    }
}