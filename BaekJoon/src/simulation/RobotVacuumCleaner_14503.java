package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

로봇 청소기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	24457	12933	8375	51.819%
문제
로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 
각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 
지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.

로봇 청소기는 다음과 같이 작동한다.

현재 위치를 청소한다.
현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

입력
첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)

둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.

셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.

로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.

출력
로봇 청소기가 청소하는 칸의 개수를 출력한다.

예제 입력 1 
3 3
1 1 0
1 1 1
1 0 1
1 1 1
예제 출력 1 
1
예제 입력 2 
11 10
7 4 0
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 1 1 1 1 0 1
1 0 0 1 1 0 0 0 0 1
1 0 1 1 0 0 0 0 0 1
1 0 0 0 0 0 0 0 0 1
1 0 0 0 0 0 0 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 1 1 0 1
1 0 0 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1
예제 출력 2 
57



*/



// 여기서 중요한 점
// 1. a) 방향 전환을 꼬아서 낸 것 같다 d는 북 동 남 서
//    b) 돌아야 하는 방향은 왼쪽 방향 즉, 북 서 남 동
//      - 여기 a와 b에게 혼동이 되어 오래 걸렸다.
//      - for문 조건식을 잘 세워야 한다... 조건식 때문에 망함
//      - 필기 하면서 문제 풀기
// 2. 네 방향 모두 청소했거나 벽일때 후진하는 방향이 벽이라면 후진할 수 없다.
// 즉, 청소했던곳으로 후진은 가능하나 벽으론 후진 할 수 없다.

// 2020-11-16 10시 30분 ~ 12시 30분...
// 2020-11-17 9시 50분 ~ 10시 20분...
// 총 2시간 30분 걸림
// 골드문제는 적어도 2시간 걸리는듯
// 이제 문제들은 최소 실버 1부터 풀자

// 너무 실버 하위문제만 풀었던 거 같다.
public class RobotVacuumCleaner_14503 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int count = 0;
	private static int n, m;
	
	// 						순서대로 서남동북
//	private static int[] dx = {-1, 0, 1, 0};
//	private static int[] dy = {0, 1, 0, -1};
	// 							북 동 남 서
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {-1, 0, 1, 0};
	
	private static void dfs(int r, int c, int d) {
		boolean flag = true;
		if(map[r][c] == 0) {
			count++;
			map[r][c] = 2;
		}
		
		for(int i = d+4; i > d; i--) {
			int R = r + dy[(i+3)%4];
			int C = c + dx[(i+3)%4];
			
			if(R >= 0 && R < n && C >= 0 && C < m) {
				if(map[R][C] == 0) {
					flag = false;
					count++;
					map[R][C] = 2;
					dfs(R, C, (i+3)%4);
					break;
				}
			}
		}
		
		if(flag) {
			// 뒤로 한칸
			int R = r + dy[(d+2)%4];
			int C = c + dx[(d+2)%4];
			
			if(R >= 0 && R < n && C >= 0 && C < m) {
				if(map[R][C] != 1) {
					dfs(R, C, d);										
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());		// 세로
		m = Integer.parseInt(st.nextToken());		// 가로
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		// (r, c)
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 방향 : d = 0 (북), d = 1 (동), d = 2 (남), d = 3 (서)
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r, c, d);
		
		
		System.out.println(count);
		
		br.close();
	}
	
}
