package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치즈_2638_복습 {
  private static final int[] dx = {1, -1, 0, 0};
  private static final int[] dy = {0, 0, 1, -1};

  private static int N;
  private static int M;
  private static int[][] map;
  private static int[][] cheeseCount;
  private static boolean[][] visitedAir;
  private static Queue<Pos> airMap = new LinkedList<>();

  private static class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static void findAir(int x, int y) {
    for (int i = 0; i < dx.length; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];

      if (!verify(X, Y)) {
        continue;
      }

      if (map[X][Y] != 0) {
        if (++cheeseCount[X][Y] == 2) {
          airMap.add(new Pos(X, Y));
        }
        continue;
      }

      visitedAir[X][Y] = true;
      findAir(X, Y);
    }
  }

  private static boolean verify(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M && !visitedAir[x][y];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visitedAir = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    airMap.add(new Pos(0, 0));
    visitedAir[0][0] = true;
    cheeseCount = new int[N][M];
    int time = 0;
    while (true) {
      int size = airMap.size();
      while (size-- > 0) {
        Pos air = airMap.poll();
        findAir(air.x, air.y);
      }

      if (airMap.isEmpty()) {
        break;
      }

      time ++;
    }

    System.out.println(time);

    br.close();
  }

  private static void printMap() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }
}
