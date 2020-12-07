package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

https://www.acmicpc.net/problem/2178

미로 탐색 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	192 MB	78697	30061	19104	36.965%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1 
4 6
101111
101010
101011
111011
예제 출력 1 
15
예제 입력 2 
4 6
110110
110110
111111
111101
예제 출력 2 
9
예제 입력 3 
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3 
38
예제 입력 4 
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4 
13

*/

// (1, 1)에서 (N, M)까지의 최소 거리
// BFS
public class MazeExploration {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int depth = 0;
	private static boolean flag = false;

	private static int dx[] = { 1, -1, 0, 0 };
	private static int dy[] = { 0, 0, 1, -1 };

	private static class Pair {
		int x, y, depth;

		public Pair(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String nextToken = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(nextToken.charAt(j));
			}
		}
		if (map[0][0] == 1) {
			bfs(0, 0, 1);
		} else {
			System.out.println(0);
		}

		// 문제 푸는데 이상은 없지만
		// 만약 길이 끊어져 있다면 예외로 생각해봄
		if (!flag) {
			System.out.println("가는길 없음");
		}

		br.close();
	}

	private static void bfs(int x, int y, int depth) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x, y, depth));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			visited[p.x][p.y] = true;

			for (int i = 0; i < 4; i++) {
				int X = p.x + dx[i];
				int Y = p.y + dy[i];

				if (X >= 0 && X < N && Y >= 0 && Y < M) {
					if (map[X][Y] == 1 && !visited[X][Y]) {
						visited[X][Y] = true;
						q.add(new Pair(X, Y, p.depth + 1));
					}
				}
			}

			if (p.x == N - 1 && p.y == M - 1) {
				flag = true;
				System.out.println(p.depth);
			} else {
				flag = false;
			}
		}

	}
}
