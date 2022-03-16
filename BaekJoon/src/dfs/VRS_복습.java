package dfs;

import java.util.Scanner;

// 9/29
public class VRS_복습 {
	private static int[][] netConn;
	private static boolean[] visited;
	private static int n;
	private static int comCnt;
	private static int cnt = 0;
	
	public static void dfs(int start) {
		// start를 방문했으므로 visited[start] = true;
		visited[start] = true;	
		
		// 0부터가 아닌 1부터이므로 i는 1부터 n+1까지
		for(int i = 1; i < n + 1; i++) {
			// start == i 이면 자기 자신이므로 넘어감
			if(start == i) continue;
			
			// dfs의 변수인 start와 i가 연결되어 있고 방문하지 않았다면!!!
			// 방문처리를 하고 dfs
			if(netConn[start][i] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs(i);
				cnt++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 컴퓨터 수
		comCnt = scan.nextInt();
		n = scan.nextInt();
		
		// 컴퓨터의 개수만큼 방문처리를 해야하므로
		// boolean 배열은 선언을 하면 default값으로 false가 들어가있음.
		visited = new boolean[comCnt+1];
		netConn = new int[comCnt+1][comCnt+1];
		
		for(int i = 0; i < n; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			// 1이 연결 되어 있는 것.
			// 연결된 것. 간선을 이차 배열로 연결 시킴.
			// 1과 2가 연결되어 있다면 netConn[1][2]와 netConn[2][1]를 1로 초기화
			netConn[a][b] = netConn[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(cnt);
		
	}
}
