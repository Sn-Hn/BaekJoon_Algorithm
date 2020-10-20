package dfs_bfs;

import java.util.Scanner;

/*

신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 
한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
1번 컴퓨터가 웜 바이러스에 걸리면 
웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 
2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.



어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

첫째 줄에는 컴퓨터의 수가 주어진다. 
컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

1번 컴퓨터가 웜 바이러스에 걸렸을 때, 
1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

dfs를 이용 (깊이 우선 탐색)

*/

// 9/27
public class Virus_2606 {
	// 방문 처리를 위한 visited
	private static boolean[] visited;
	
	private static int[][] netConnect;
	private static int n, m;
	private static int cnt;
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for(int i = 1; i < n+1; i++) {
			if(netConnect[start][i] == 1 && visited[i] == false) {
				dfs(i);
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		// 컴퓨터 1부터 n까지 표현하기 위해 배열을 n+1까지 선언 (방문 처리)
		visited = new boolean[n+1];
		m = scan.nextInt();
		netConnect = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			// a컴퓨터와 b컴퓨터가 서로 연결되어있다.
			netConnect[a][b] = netConnect[b][a] = 1; 
		}
		
		dfs(1);
		System.out.println(cnt);
		
	}
}