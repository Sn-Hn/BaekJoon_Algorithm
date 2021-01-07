package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark_16236_bfs {
	private static int N;
	private static int map[][];
	private static int copyMap[][];
	private static boolean visited[][];
	
	private static Pair babyShark;
	
	private static int dx[] = {0, 0, 1, -1};
	private static int dy[] = {1, -1, 0, 0};
	
	private static class Pair implements Comparable<Pair> {
		int x, y, depth, size, fish;
		public Pair(int x, int y, int depth, int size, int fish) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.size = size;
			this.fish = fish;
		}
		
		@Override
		public int compareTo(Pair o) {
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copyMap = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babyShark = new Pair(i, j, 0, 2, 0);
				}
			}
		}
		
		br.close();
	}
	
	private static void move() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(babyShark);
		int size, fish;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			visited[p.x][p.y] = true;
			for(int i = 0; i < 4; i++) {
				int X = p.x + dx[i];
				int Y = p.y + dy[i];
				
				if(X >= 0 && X < N && Y >= 0 && Y < N && map[X][Y] <= p.size) {
					if(map[X][Y] < p.size && map[X][Y] > 0 && !visited[X][Y]) {
						visited[X][Y] = true;
						if(p.size <= p.fish+1) {
							q.add(new Pair(X, Y, p.depth+1, p.size+1, 0));
						}else {
							q.add(new Pair(X, Y, p.depth+1, p.size, p.fish+1));
						}
						
					}
				}
			}
		}
	}
	
	private static void copyMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}

