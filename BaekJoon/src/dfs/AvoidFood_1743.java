package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

문제
코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 
그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 
이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 

이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 
참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. 

통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 
따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 

선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.

입력
첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 
그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ 10,000)이 주어진다.  
그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.

좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다.

출력
첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.

예제 입력 1 
3 4 5
3 2
2 2
3 1
2 3
1 1
예제 출력 1 
4


*/

public class AvoidFood_1743 {
	private static int N;
	private static int M;
	private static int K;
	private static int map[][];
	private static boolean visited[][];
	private static int dx[] = {0, 0, 1, -1};
	private static int dy[] = {1, -1, 0, 0};
	private static int cnt;
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X <= N && Y <= M && X > 0 && Y > 0) {
				if(!visited[X][Y] && map[X][Y] == 1) {
					cnt++;
					dfs(X, Y);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int compareCnt = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i = 1; i <= K; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			
			map[a][b] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt = 1;
					dfs(i, j);
					if(cnt > compareCnt) {
						compareCnt = cnt;
					}
					System.out.println(i + ", " + j + ", " + cnt);
				}
			}
		}
		
		System.out.println(compareCnt);
		
		br.close();
	}
}
