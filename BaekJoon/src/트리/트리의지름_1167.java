package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1167 {
    private static int N;
    private static List<Node> tree[];
    private static int max = 0;
    private static int max_index = 0;
    private static boolean visited[];

    private static class Node {
        int index, weight;
        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            while(true) {
                int child = Integer.parseInt(st.nextToken());
                if(child == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                tree[parent].add(new Node(child, weight));
                tree[child].add(new Node(parent, weight));
            }
        }

        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N+1];
        visited[max_index] = true;
        dfs(max_index, 0);
        System.out.println(max);


        br.close();
    }

    private static void dfs(int index, int weight){
        if(max < weight) {
            max = weight;
            max_index = index;
        }

        for(Node node : tree[index]) {
            if(!visited[node.index]) {
                visited[node.index] = true;
                dfs(node.index, weight + node.weight);
            }
        }

    }
}

