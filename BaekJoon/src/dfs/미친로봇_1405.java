package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N, 동, 서, 남, 북
public class 미친로봇_1405 {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int N;
    private static double[] directionPercent = new double[4];
    private static double totalPercent = 0;
    private static boolean[][] visited;

    private static void move(int x, int y, double currentPercent, int depth) {
        if (N == depth) {
            totalPercent += currentPercent;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (visited[X][Y]) {
                continue;
            }

            visited[X][Y] = true;
            move(X, Y, currentPercent * directionPercent[i], depth + 1);
            visited[X][Y] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[2 * N + 1][2 * N + 1];

        for (int i = 0; i < 4; i++) {
            directionPercent[i] = Double.parseDouble(st.nextToken()) / 100;
        }
        visited[N][N] = true;

        move(N, N, 1, 0);

        System.out.println(totalPercent);

        br.close();
    }
}