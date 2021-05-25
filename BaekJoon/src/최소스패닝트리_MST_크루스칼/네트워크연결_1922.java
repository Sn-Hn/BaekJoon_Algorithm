package 최소스패닝트리_MST_크루스칼;

/*

네트워크 연결 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   256 MB   20073   11910   7038   58.499%
문제
도현이는 컴퓨터와 컴퓨터를 모두 연결하는 네트워크를 구축하려 한다.
하지만 아쉽게도 허브가 있지 않아 컴퓨터와 컴퓨터를 직접 연결하여야 한다.
그런데 모두가 자료를 공유하기 위해서는 모든 컴퓨터가 연결이 되어 있어야 한다.
(a와 b가 연결이 되어 있다는 말은 a에서 b로의 경로가 존재한다는 것을 의미한다. a에서 b를 연결하는 선이 있고, b와 c를 연결하는 선이 있으면 a와 c는 연결이 되어 있다.)

그런데 이왕이면 컴퓨터를 연결하는 비용을 최소로 하여야 컴퓨터를 연결하는 비용 외에 다른 곳에 돈을 더 쓸 수 있을 것이다.
이제 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 최소비용을 출력하라.
모든 컴퓨터를 연결할 수 없는 경우는 없다.

입력
첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000)가 주어진다.

둘째 줄에는 연결할 수 있는 선의 수 M (1 ≤ M ≤ 100,000)가 주어진다.

셋째 줄부터 M+2번째 줄까지 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다.
이 비용의 정보는 세 개의 정수로 주어지는데, 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다.
a와 b는 같을 수도 있다.

출력
모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력한다.

예제 입력 1
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
예제 출력 1
23

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 네트워크연결_1922 {
    private static int N;
    private static int M;
    private static int[] parent;
    private static List<Node> tree = new ArrayList<>();

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        initParent();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree.add(new Node(a, b, cost));
        }

        Collections.sort(tree);

        System.out.println(getMST());

        br.close();
    }

    private static int getMST() {
        int minCost = 0;
        int count = 0;
        for (Node node : tree) {
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            if (isCycle(x, y)) {
                continue;
            }

            union(x, y);
            minCost += cost;

            if (++count == N - 1) {
                break;
            }
        }

        return minCost;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static boolean isCycle(int a, int b) {
        return find(a) == find(b);
    }

    private static void initParent() {
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
    }
}