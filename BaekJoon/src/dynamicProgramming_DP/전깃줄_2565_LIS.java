package dynamicProgramming_DP;

/*

전깃줄 출처분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
1 초   128 MB   15760   7362   5840   46.713%
문제
두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다.
합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.

예를 들어, <그림 1>과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄,
A의 3번 위치와 B의 9번 위치를 잇는 전깃줄,
A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.



전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다.
전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때,
남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다.
전깃줄의 개수는 100 이하의 자연수이다.
둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 B전봇대와 연결되는 위치의 번호가 차례로 주어진다.
위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.

출력
첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.

예제 입력 1
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
예제 출력 1
3

6
1 8
2 9
4 4
5 2
6 1
7 5

5
3 4
1 5
4 2
2 3
5 1

10
1 6
2 8
3 2
4 9
5 5
6 10
7 4
8 1
9 7
10 3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전깃줄_2565_LIS {
    private static int N;
    private static int[][] electricFlex;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        electricFlex = new int[N][2];
        dp = new int[N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                electricFlex[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(electricFlex, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        lis();

        System.out.println(N - dp[N - 1]);

        br.close();
    }

    private static void lis() {
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (electricFlex[i][1] > electricFlex[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);
    }

    private static void printDp() {
        for (int i = 0; i < N; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    private static void printFlex() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(electricFlex[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}