package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 
한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 
이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 
그 배추들 역시 해충으로부터 보호받을 수 있다.

(한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있다고 간주한다)

한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어놓았다. 
배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 
서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다.

예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다.

(0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.)

입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트 케이스에 대해 
첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.

출력
각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

*/


// 섬의 개수 문제와 비슷한 유형
public class OrganicCabbage_1012 {
	private static int t;
	private static int m, n, k;
	private static int cnt;
	private static int x, y;
	private static int map[][];
	private static boolean visited[][];
	
							  // 상 하 좌 우  ↖       ↘       ↙       ↗
	private static int dx[] = {0, 0, -1, 1};
	private static int dy[] = {-1, 1, 0, 0};
	private static int dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < dx.length; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if(X >= 0 && Y >= 0 && X < m && Y < n) {
				if(!visited[X][Y] && map[X][Y] == 1) {
					dfs(X, Y);
				}				
			}
		}
		
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// m은 가로길이, n은 세로길이
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[m][n];
			visited = new boolean[m][n];
			cnt = 0;
			for(int j = 0; j < k; j++) {
				StringTokenizer stn = new StringTokenizer(br.readLine());
				x = Integer.parseInt(stn.nextToken());
				y = Integer.parseInt(stn.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					if(!visited[j][k] && map[j][k] == 1) cnt += dfs(j, k);
				}
			}
			
			bw.write(String.valueOf(cnt));
			
		}
		
		br.close();
		bw.close();
		
	}
}
