import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        ArrayDeque<Integer>[] stacks = new ArrayDeque[26];

        for (int i = 0; i < 26; i++) {
            stacks[i] = new ArrayDeque<>();
        }

        int[] ans = new int[n];

        int[] dfs = new int[2 * n];
        int top = 0;

        dfs[top++] = 0;

        while (top > 0) {

            int event = dfs[--top];

            int node = event / 2;
            int state = event % 2;

            int ch = s.charAt(node) - 'a';

            if (state == 0) {

                ans[node] = 1;

                stacks[ch].push(node);

                dfs[top++] = 2 * node + 1;

                for (int child : tree[node]) {
                    dfs[top++] = 2 * child;
                }

            } else {

                stacks[ch].pop();

                int newParent;

                if (!stacks[ch].isEmpty()) {
                    newParent = stacks[ch].peek();
                } else {
                    newParent = parent[node];
                }

                if (newParent != -1) {
                    ans[newParent] += ans[node];
                }
            }
        }

        return ans;
    }
}