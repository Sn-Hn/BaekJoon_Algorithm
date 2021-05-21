package 세그먼트트리;

/*

수열과 쿼리 16 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   512 MB   1450   745   637   55.440%
문제
길이가 N인 수열 A1, A2, ..., AN이 주어진다. 이때, 다음 쿼리를 수행하는 프로그램을 작성하시오.

1 i v : Ai를 v로 바꾼다. (1 ≤ i ≤ N, 1 ≤ v ≤ 109)
2 i j : Ai, Ai+1, ..., Aj에서 크기가 가장 작은 값의 인덱스를 출력한다. 그러한 값이 여러개인 경우에는 인덱스가 작은 것을 출력한다. (1 ≤ i ≤ j ≤ N, 1 ≤ v ≤ 109)
수열의 인덱스는 1부터 시작한다.
입력
첫째 줄에 수열의 크기 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)

셋째 줄에는 쿼리의 개수 M이 주어진다. (1 ≤ M ≤ 100,000)

넷째 줄부터 M개의 줄에는 쿼리가 주어진다.

출력
2번 쿼리에 대해서 정답을 한 줄에 하나씩 순서대로 출력한다.

예제 입력 1
5
5 4 3 2 1
6
2 1 3
2 1 4
1 5 3
2 3 5
1 4 3
2 3 5
예제 출력 1
3
4
4
3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열과쿼리16_14428 {
    private static final int ERROR = -1;

    private static int N;
    private static int[] arr;
    private static int M;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[N * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initTree(1, N, 1);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (query == 1) {
                arr[a] = b;
                update(1, N, 1, a, b);
                continue;
            }
            sb.append(min(1, N, 1, a, b)).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    private static int minIndex(int x, int y) {
        if(x == ERROR) {
            return y;
        }

        if(y == ERROR) {
            return x;
        }

        if (arr[x] == arr[y]) {
            return x < y ? x : y;
        }
        return arr[x] < arr[y] ? x : y;
    }

    private static int initTree(int start, int end, int node) {
        if (start == end) {
            return tree[node] = start;
        }

        int mid = (start + end) / 2;
        return tree[node] = minIndex(initTree(start, mid, node * 2), initTree(mid + 1, end, node * 2 + 1));
    }

    private static int min(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return ERROR;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return minIndex(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
    }

    private static int update(int start, int end, int node, int index, int value) {
        if (index < start || index > end || start == end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return tree[node] = minIndex(update(start, mid, node * 2, index, value), update(mid + 1, end, node * 2 + 1, index, value));
    }

    private static void printTree() {
        System.out.println();
        for (int i = 1; i <= N; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}