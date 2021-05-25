package greedy;

/*

A → B 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   512 MB   7327   3149   2514   41.616%
문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다.
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

예제 입력 1
2 162
예제 출력 1
5
2 → 4 → 8 → 81 → 162

예제 입력 2
4 42
예제 출력 2
-1
예제 입력 3
100 40021
예제 출력 3
5

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AB_16953 {
    private static long A;
    private static long B;

    private static int min = Integer.MAX_VALUE;

    private static class Pair {
        long a;
        int cnt;

        public Pair(long a, int cnt) {
            this.a = a;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Integer.parseInt(st.nextToken());

//        bfs();
        dfs(A, 0);
        if(min == Integer.MAX_VALUE) {
            min = -2;
        }

        System.out.println(min + 1);

        br.close();
    }

    // dfs에 비해 메모리와 시간을 많이 잡아먹는다.
    private static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(A, 0));

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            long a = pair.a;
            int cnt = pair.cnt;

            if(a == B) {
                min = Math.min(min, cnt);
            }

            if (a < B) {
                q.add(new Pair(a * 2, cnt + 1));
                q.add(new Pair((a * 10) + 1, cnt + 1));
            }
        }
    }

    // dfs가 좀더 빠르고 메모리도 덜 차지한다.
    private static void dfs(long a, int cnt) {
        if(a == B) {
            min = Math.min(min, cnt);
            return;
        }

        if(a < B) {
            dfs(a * 2, cnt + 1);
            dfs((a * 10) + 1, cnt + 1);
        }
    }
}
