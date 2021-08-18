package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자_1194 {
	private static final int dx[] = {1, -1, 0, 0};
	private static final int dy[] = {0, 0, 1, -1};
	private static final int FAIL = -1;
	
	private static int N;
	private static int M;
	private static char[][] map;
	private static boolean[][] visited;
	private static Pos startPos;
	
	private static class Pos {
		int x;
		int y;
		int moveCount;
		int[] keys = new int[6];
		boolean[][] visit = new boolean[N][M];
		
		public Pos(int x, int y, int moveCount) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.moveCount = moveCount;
		}
		
		public Pos(int x, int y, int moveCount, int[] k, boolean[][] v) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.moveCount = moveCount;
			this.keys = k.clone();
			copyVisit(v);
		}
		
		public void addKey(char key) {
			keys[ctoi(key)] ++;
		}
		
		public void initVisit() {
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], false);
			}
		}
		
		public void copyVisit(boolean[][] v) {
			for (int i = 0; i < v.length; i++) {
				for (int j = 0; j < v[0].length; j++) {
					visit[i][j] = v[i][j];
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					startPos = new Pos(i, j, 0);
				}
			}
		}
		
		System.out.println(escapeMaze());
		
		
		br.close();
	}
	
	private static int escapeMaze() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(startPos);
		int index = 0;
		
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			
			for (int i = 0; i < dx.length; i++) {
				int X = x + dx[i];
				int Y = y + dy[i];
				int[] keys = pos.keys.clone();
				
				if (!isValid(X, Y)) {
					continue;
				}
				
				if (pos.visit[X][Y]) {
					continue;
				}
				
				
				if (map[X][Y] >= 'A' && map[X][Y] <= 'F' && !openDoor(keys, map[X][Y])) {
					continue;
				}
				
				if (map[X][Y] >= 'a' && map[X][Y] <= 'f') {
					keys[ctoi(map[X][Y])]++;
					pos.initVisit();
					System.out.println(index++ + ": " + X + ", " + Y + ", " + map[X][Y] + ", " + Arrays.toString(pos.keys) + ", " + (pos.moveCount + 1));
				}
				
				pos.visit[X][Y] = true;
//				System.out.println(index++ + ": " + X + ", " + Y + ", " + map[X][Y] + ", " + Arrays.toString(pos.keys));
				
				if (map[X][Y] == '1') {
					return pos.moveCount + 1;
				}
				
				pos.copyVisit(pos.visit);
				q.add(new Pos(X, Y, pos.moveCount + 1, keys, pos.visit));
			}
		}
		
		return FAIL;
	}
	
	private static boolean openDoor(int[] keys, char key) {
		if (keys[CTOI(key)] != 0) {
			return true;
		}
		
		return false;
	}
	
	public void addKey(int[] keys, char key) {
		keys[ctoi(key)] ++;
	}
	
	private static boolean isValid(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && map[x][y] != '#') {
			return true;
		}
		
		return false;
	}
	
	private static int ctoi(char ch) {
		return ch - 'a';
	}
	
	private static int CTOI(char ch) {
		return ch - 'A';
	}
}
