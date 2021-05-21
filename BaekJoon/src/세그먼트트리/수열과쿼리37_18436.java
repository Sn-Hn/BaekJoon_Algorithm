package 세그먼트트리;

/*

수열과 쿼리 37 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	841	508	401	61.035%
문제
길이가 N인 수열 A1, A2, ..., AN이 있다. 이때, 다음 쿼리를 수행하는 프로그램을 작성하시오.

1 i x: Ai를 x로 바꾼다.
2 l r: l ≤ i ≤ r에 속하는 모든 Ai중에서 짝수의 개수를 출력한다.
3 l r: l ≤ i ≤ r에 속하는 모든 Ai중에서 홀수의 개수를 출력한다.
수열의 인덱스는 1부터 시작한다.

입력
첫째 줄에 수열의 크기 N (1 ≤ N ≤ 100,000)이 주어진다.

둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)

셋째 줄에는 쿼리의 개수 M (1 ≤ M ≤ 100,000)이 주어진다.

넷째 줄부터 M개의 줄에는 쿼리가 한 줄에 하나씩 주어진다. (1 ≤ i ≤ N, 1 ≤ l ≤ r ≤ N, 1 ≤ x ≤ 109)

출력
2, 3번 쿼리의 정답을 한 줄에 하나씩 출력한다.

예제 입력 1
6
1 2 3 4 5 6
4
2 2 5
3 1 4
1 5 4
2 1 6
예제 출력 1
2
2
4

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열과쿼리37_18436 {
    private static final int ERROR = -1;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    private static int N;
    private static int[] arr;
    private static int M;
    private static int[] oddTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        oddTree = new int[N * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initTree(1, N, 1);
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int resultLen = b - a + 1;

            if (query == 1) {
                if(arr[a] == b) {
                    continue;
                }
                update(1, N, 1, a, isOdd(b));
                arr[a] = b;
                continue;
            }

            if (query == 2) {
                sb.append(resultLen - countOdd(1, N, 1, a, b)).append("\n");
                continue;
            }

            if (query == 3) {
                sb.append(countOdd(1, N, 1, a, b)).append("\n");
                continue;
            }
        }

        System.out.println(sb.toString());

        br.close();
    }

    private static int isOdd(int x) {
        if (x % TWO == ONE) {
            return ONE;
        }
        return ZERO;
    }

    private static int initTree(int start, int end, int node) {
        if (start == end) {
            return oddTree[node] = isOdd(arr[start]);
        }
        int mid = (start + end) / 2;
        return oddTree[node] = initTree(start, mid, node * 2) + initTree(mid + 1, end, node * 2 + 1);
    }

    private static int countOdd(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return ZERO;
        }

        if (left <= start && right >= end) {
            return oddTree[node];
        }
        int mid = (start + end) / 2;
        return countOdd(start, mid, node * 2, left, right) + countOdd(mid + 1, end, node * 2 + 1, left, right);
    }

    private static int update(int start, int end, int node, int index, int value) {
        if (index < start || index > end) {
            return oddTree[node];
        }

        if (start == end) {
            return oddTree[node] = value;
        }

        int mid = (start + end) / 2;
        return oddTree[node] = update(start, mid, node * 2, index, value) + update(mid + 1, end, node * 2 + 1, index, value);
    }
}
