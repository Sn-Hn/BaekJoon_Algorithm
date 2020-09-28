package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 코드를 이쁘게 잘 짜놓은 것 같다..
// 9/29

// 9/30 코드 분석 후 다시 풀어보기

class Pairs {
	int x;
	int y;

	Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class IslandCount_다른사람풀이2 {
	static int[][] arr;
	static int[][] check;
	static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, 1, -1 };

	/* DFS */
	private static void dfs(int x, int y, int count, int w, int h) {
		check[x][y] = count;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < h && 0 <= ny && ny < w) {
				if (arr[nx][ny] == 1 && check[nx][ny] == 0)
					dfs(nx, ny, count, w, h);
			}
		}
	}

	/* BFS */
	private static void bfs(int x, int y, int count, int w, int h) {
		Queue<Pairs> queue = new LinkedList<Pairs>();
		queue.add(new Pairs(x, y));
		check[x][y] = count;
		while (!queue.isEmpty()) {
			Pairs p = queue.remove();
			x = p.x;
			y = p.y;
			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < h && 0 <= ny && ny < w) {
					if (arr[nx][ny] == 1 && check[nx][ny] == 0)
						bfs(nx, ny, count, w, h);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w == 0 && h == 0)
				break;

			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int count = 0;
			check = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && check[i][j] == 0)
						// dfs(i, j, ++count, w, h);
						bfs(i, j, ++count, w, h);
				}
			}
			System.out.println(count);
		}

		sc.close();
	}
}

// 출처 : https://developer-mac.tistory.com/66
