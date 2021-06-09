package dynamicProgramming_DP;

/*

점프 출처다국어분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
1 초   128 MB   28761   8587   6358   28.566%
문제
N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.

각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동해야 한다.
0은 더 이상 진행을 막는 종착점이며, 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다.
한 번 점프를 할 때, 방향을 바꾸면 안 된다.
즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.

가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다.
그 다음 N개 줄에는 각 칸에 적혀져 있는 수가 N개씩 주어진다.
칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수이며, 가장 오른쪽 아래 칸에는 항상 0이 주어진다.

출력
가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력한다.
경로의 개수는 263-1보다 작거나 같다.

예제 입력 1
4
2 3 3 1
1 2 1 3
1 2 3 1
3 1 1 0
예제 출력 1
3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1890
public class 점프_1890 {
    private static int N;
    private static int[][] map;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getBottomUp();

        System.out.println(dp[N][N]);

        printDp();

        br.close();
    }

    // bottom-up
    // dp[1][1] 에서 dp[i][j] 까지 가는 시간
    private static void getBottomUp() {
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == N && j == N) {
                    break;
                }
                int move = map[i][j];
                // 오른쪽
                if (j + move <= N) {
                    dp[i][j + move] += dp[i][j];
                }

                // 아래쪽
                if (i + move <= N) {
                    dp[i + move][j] += dp[i][j];
                }
            }
        }
    }

    private static void printDp() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
