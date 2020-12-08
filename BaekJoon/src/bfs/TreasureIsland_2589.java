package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*

https://www.acmicpc.net/problem/2589

보물섬 출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	18473	6598	4756	38.535%
문제
보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다. 
보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다. 
각 칸은 육지(L)나 바다(W)로 표시되어 있다. 
이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다. 
보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다. 
육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.



예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.



보물 지도가 주어질 때, 보물이 묻혀 있는 두 곳 간의 최단 거리로 이동하는 시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 
이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 
보물 지도의 가로, 세로의 크기는 각각 50이하이다.

출력
첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.

예제 입력 1 
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
예제 출력 1 
8

*/


// 메모리 줄이기 힘들다.. 안줄어듬
public class TreasureIsland_2589 {
	private static int N, M;
	private static int[][] map;
//	private static boolean[][] visited;
	private static List<Pair> land = new ArrayList<Pair>();
	
	private static int dx[] = {1, -1, 0, 0};
	private static int dy[] = {0, 0, 1, -1};
	
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
		int depth = 0;
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			String nextToken = br.readLine();
			for(int j = 0; j < M; j++) {
				if(nextToken.charAt(j) == 'W') {
					map[i][j] = 0;
				}else {
					map[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					depth = findTreasure(i, j);
					if(result < depth) {
						result = depth;
					}
				}
			}
		}
		
		System.out.println(result);
		
		
		br.close();
	}
	
	private static int findTreasure(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		int depth = 0;
		boolean[][] visited = new boolean[N][M];
		q.add(new Pair(x, y, 0));
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			visited[pair.x][pair.y] = true;
			
			for(int i = 0; i < 4; i++) {
				int X = pair.x + dx[i];
				int Y = pair.y + dy[i];
				
				if(X >= 0 && X < N && Y >= 0 && Y < M) {
					if(map[X][Y] == 1 && !visited[X][Y]) {
						visited[X][Y] = true;
						depth = pair.depth + 1;
						q.add(new Pair(X, Y, depth));
					}
				}
			}
			
		}
		
		return depth;
	}
	
	private static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
