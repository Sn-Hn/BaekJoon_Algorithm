package 스터디_복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge {
  private static int N;
  private static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    init();

    for (int i = 0; i < N - 2; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      union(a, b);
    }

    System.out.println(constructBridge());

    br.close();
  }

  private static String constructBridge() {
    StringBuilder result = new StringBuilder("1").append(" ");
    for (int i = 2; i <= N; i++) {
      if (parent[i] == i) {
        result.append(i);
        break;
      }
    }

    return result.toString();
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a > b) {
      parent[a] = b;
    } else {
      parent[b] = a;
    }
  }

  private static int find(int x) {
    if (parent[x] == x) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  private static void init() {
    parent = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      parent[i] = i;
    }
  }
}