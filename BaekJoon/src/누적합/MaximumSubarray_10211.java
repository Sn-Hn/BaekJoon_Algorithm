package 누적합;

/*

예제 입력 1
2
5
1 2 3 4 5
5
2 1 -2 3 -5
예제 출력 1
15
4

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarray_10211 {
    private static int TC;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < TC; i++) {
            N = Integer.parseInt(br.readLine());
            int[] prefixSum = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                prefixSum[j + 1] = Math.max(now + prefixSum[j], now);
            }

            result.append(findMax(prefixSum))
                    .append("\n");
        }

        System.out.println(result.toString().trim());

        br.close();
    }

    private static int findMax(int[] prefixSum) {
        int max = Integer.MIN_VALUE;
        for (int j = 1; j <= N; j++) {
            max = Math.max(max, prefixSum[j]);
        }

        return max;
    }
}
