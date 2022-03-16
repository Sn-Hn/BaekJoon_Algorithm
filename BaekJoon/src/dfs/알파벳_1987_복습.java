package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987_복습 {
  private static final int[] dx = {1, -1, 0, 0};
  private static final int[] dy = {0, 0, 1, -1};
  private static final int ALPHABET_COUNT = 26;

  private static int R;
  private static int C;
  private static char[][] map;
  private static boolean[] alphbetIndex;
  private static int result = 0;

  private static void moveHorse(int x, int y, int moveCount) {
    result = moveCount > result ? moveCount : result;

    for (int i = 0; i < dx.length; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];

      if (!verifyOut(X, Y)) {
        continue;
      }

      alphbetIndex[parseInt(map[X][Y])] = true;
      moveHorse(X, Y, moveCount + 1);
      alphbetIndex[parseInt(map[X][Y])] = false;
    }
  }

  private static boolean verifyOut(int x, int y) {
    if (x >= 0 && x < R && y >= 0 && y < C && !alphbetIndex[parseInt(map[x][y])]) {
      return true;
    }

    return false;
  }

  private static int parseInt(char alphabet) {
    return alphabet - 'A';
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R][C];
    alphbetIndex = new boolean[ALPHABET_COUNT];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();
    }

    alphbetIndex[parseInt(map[0][0])] = true;
    moveHorse(0, 0, 1);
    System.out.println(result);

    br.close();
  }

  private static void printMap() {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }
}
