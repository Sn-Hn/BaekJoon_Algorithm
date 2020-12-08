package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 기준 자바 시간 최소
public class TreasureIsland_다른사람_2589{

	static class Obj {
		int y, x, cnt;

		public Obj(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Queue<Obj> q;
	private static int R;
	private static int C;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		map = new int[R][C];
		q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				switch (s.charAt(j)) {
				case 'W':
					map[i][j] = 1;
					break;
				case 'L':
					map[i][j] = 0;
					break;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new Obj(i,j,0));
					checkMap(i, j);
					int temp = findWay();
					if (max < temp)
						max = temp;
				}
			}
		}

		System.out.println(max);

	}

	public static int findWay() {
		int max = 0;
		while (!q.isEmpty()) {
			Queue<Obj> q2 = new LinkedList<>();
			Obj temp = q.poll();
			q2.add(temp);
			boolean[][] visited2 = new boolean[R][C];
			while (!q2.isEmpty()) {
				Obj cur = q2.poll();
				visited2[cur.y][cur.x] = true;
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny >= 0 && ny < R && nx >= 0 && nx < C && map[ny][nx] == 0 && !visited2[ny][nx]) {
						visited2[ny][nx] = true;
						q2.add(new Obj(ny, nx, (cur.cnt) + 1));
					}
				}
				if (q2.isEmpty()) {
					if (max < cur.cnt)
						max = cur.cnt;
				}
			}
		}
		
		return max;
	}

	public static void checkMap(int y, int x) {
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < R && nx >= 0 && nx < C && map[ny][nx] == 0 && !visited[ny][nx]) {
				visited[ny][nx] = true;
				check = true;
				checkMap(ny, nx);
			}
		}

		if (!check)
			q.add(new Obj(y, x, 0));
	}

}
