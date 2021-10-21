package 누적합;

/*

예제 입력 1
5
10 20 30 40 50
5
1 3
2 4
3 5
1 5
4 4
예제 출력 1
60
90
120
150
40
예제 입력 2
3
1 0 -1
6
1 1
2 2
3 3
1 2
2 3
1 3
예제 출력 2
1
0
-1
1
-1
0

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합구하기_누적합 {
    private static int N;
    private static int M;
    private static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        prefixSum = new int[N + 1];

        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = Integer.parseInt(st.nextToken()) + prefixSum[i];
        }

        M = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            result.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        System.out.println(result.toString().trim());

        br.close();
    }
}
