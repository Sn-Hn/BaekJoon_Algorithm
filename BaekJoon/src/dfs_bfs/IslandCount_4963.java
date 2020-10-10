package dfs_bfs;

import java.util.Scanner;

/*

정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 
섬의 개수를 세는 프로그램을 작성하시오.

한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 
한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 
지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.


*/


// 20/9/29 못품..
public class IslandCount_4963 {
	private static int w;
	private static int h;
	private static boolean visited[][];
	private static int map[][];
	private static int cnt;
	
	
	// 상하좌우 표현해야 함		    상     하    좌   우     ↖       ↘       ↙       ↗
	private static int[] dx = {0,  0, -1, 1, -1, 1, -1,  1};
	private static int[] dy = {-1, 1,  0, 0, -1, 1,  1, -1};
	
	public static int dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < dx.length; i++) {
			int X = dx[i] + x;
			int Y = dy[i] + y;
			
			if(X >= 0 && Y >= 0 && X < h && Y < w) {
				if(map[X][Y] == 1 && !visited[X][Y]) {
					dfs(X, Y);
				}
			}
		}
		
		return 1;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			cnt = 0;
			w = scan.nextInt();
			h = scan.nextInt();
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					map[i][j] = scan.nextInt();
				}
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						cnt += dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
			
		}
		
	}
}
