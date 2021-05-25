package 최소스패닝트리_MST_크루스칼;

/*

최소 스패닝 트리 분류
시간 제한   메모리 제한   제출   정답   맞은 사람   정답 비율
2 초   128 MB   33399   14422   7846   40.014%
문제
그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.

최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.

입력
첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다.
다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.

그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다.
최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.

출력
첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.

예제 입력 1
3 3
1 2 1
2 3 2
1 3 3
예제 출력 1
3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소 스패닝 트리는 그래프의 모든 정점을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
public class 최소스패닝트리_1197 {
    private static int V;
    private static int E;
    private static int[] parent;
    private static List<Node> tree = new ArrayList<>();

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        initParent();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            tree.add(new Node(a, b, value));
        }

        Collections.sort(tree);

        System.out.println(getMST());

        br.close();
    }

    private static int getMST() {
        int minValue = 0;
        int count = 0;
        for (Node node : tree) {
            int x = node.x;
            int y = node.y;
            int value = node.value;

            if (isCycle(x, y)) {
                continue;
            }
            count++;
            union(x, y);
            minValue += value;
            if(count == V - 1) {
                break;
            }
        }

        return minValue;
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
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
    }
}