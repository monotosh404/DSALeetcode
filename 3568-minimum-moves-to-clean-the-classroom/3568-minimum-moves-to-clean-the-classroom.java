import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();

        int startR = 0, startC = 0;
        int litterCount = 0;

        int[][] litterId = new int[n][m];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;

        boolean[][][][] visited =
            new boolean[n][m][energy + 1][1 << litterCount];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startR, startC, energy, 0, 0});
        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            if (mask == allCollected) {
                return moves;
            }

            if (e == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X') {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                if (cell == 'L') {
                    newMask |= (1 << litterId[nr][nc]);
                }

                if (cell == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newEnergy][newMask]) {
                    visited[nr][nc][newEnergy][newMask] = true;

                    q.offer(new int[]{
                        nr, nc, newEnergy, newMask, moves + 1
                    });
                }
            }
        }

        return -1;
    }
}