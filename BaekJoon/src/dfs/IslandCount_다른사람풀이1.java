package dfs;

import java.util.Scanner;

// 9/29 코드 분석
public class IslandCount_다른사람풀이1 {
	static int[][] map;				// 섬의 배열
	static boolean[][] visit;		// 방문처리를 위한 배열
	static int w, h;				// 섬의 크기
	
	// x좌표의 상하좌우를 나타내기 위한 배열
	private static int[] dx = { 0, 0, 1, -1, -1, 1, -1, 1 };
	// y좌표의 상하좌우를 나타내기 위한 배열
	private static int[] dy = { 1, -1, 0, 0, -1, 1, 1, -1 };
	// 즉,	dx[0] dy[0] :  0   1 	: 아래 1칸 (이차 배열로 볼 때 아래로 갈 수록 ++)
	//		dx[1] dy[1] :  0  -1 	: 위 한칸 (이차 배열로 볼 때 위로 갈 수록 ++)
	//		dx[2] dy[2] :  1   0	: 오른쪽 한칸
	//		dx[3] dy[3] : -1   0	: 왼쪽 한칸
	//		dx[4] dy[4] : -1  -1	: 왼쪽 위 대각선 한칸		↖
	//		dx[5] dy[5] :  1   1	: 오른쪽 아래 대각선 한칸		↘
	//		dx[6] dy[6] : -1   1	: 왼쪽 아래 대각선 한칸		↙
	//		dx[7] dy[7] :  1  -1	: 오른쪽 위 대각선 한칸		↗
	
	// dfs()
	private static int dfs(int x, int y) {
		// dfs에 들어왔으므로 방문처리
		visit[x][y] = true;
		
		// 상하좌우를 표현한 배열의 크기가 8이므로 for문을 8까지 돌림
		for (int i = 0; i < 8; i++) {
			// 위 설명
			int xx = dx[i] + x;
			int yy = dy[i] + y;
			
			// xx와 yy가 0보다 크고 섬의 크기보다 작아야 섬 안에 있으므로 !!
			if (xx > 0 && yy > 0 && xx <= h && yy <= w) {
				// 상하좌우로 움직였을 때 섬이고 방문하지 않았다면!!
				// 그 위치로 다시 dfs 재귀호출
				if (map[xx][yy] == 1 && !visit[xx][yy])
					dfs(xx, yy);
			}
		}
		// 재귀가 끝났다는 것은 걸어서 갈 수 있는 섬이 끝났다는 것이니
		// 섬 한개를 찾아냄
		// 이것을 main함수의 cnt에 더해준다.....
		return 1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 0 0 입력이 들어와야 로직이 종료되므로 무한루프
		while (true) {
			// 개수를 세기 위한 cnt 변수
			int cnt = 0;
			// w, h는 섬의 크기 (weight, height)
			w = scan.nextInt();
			h = scan.nextInt();
			// 0 0 입력이 들어왔으므로 종료
			if (w == 0 && h == 0)
				break;
			
			// map은 전역변수
			// 섬을 1부터 h, w까지 나타내기 위하여 각 변수에 +1을 한 후 이차 배열 선언
			map = new int[h + 1][w + 1];
			
			// visit은 전역변수
			// 방문처리를 1부터 h, w까지 나타내기 위하여 각 변수에 +1을 한 후 이차 배열 선언
			visit = new boolean[h + 1][w + 1];
			
			// 섬의 정보 입력받기
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++)
					map[i][j] = scan.nextInt();
			}
			
			// 섬의 전체를 완전탐색 (이중 for문)
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					// 바다가 아닌 섬이고 방문하지 않았다면 !!! (dfs의 중요한 조건식)
					if (map[i][j] == 1 && !visit[i][j])
						// dfs를 int형으로 선언하여 dfs가 끝날때마다 cnt에 더해줌
						// 즉, dfs가 끝난다는 것은 더 이상 걸어서 갈 수 없는 곳이기에 하나의 섬이 ++된다.
						cnt += dfs(i, j);
				}
			}
			System.out.println(cnt);
		}
	}
}

// 출처 : https://geehye.github.io/baekjoon-4963/#
