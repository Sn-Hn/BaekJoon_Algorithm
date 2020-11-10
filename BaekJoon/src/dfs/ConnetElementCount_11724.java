package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
(1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. 
(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

첫째 줄에 연결 요소의 개수를 출력한다.

Scanner보다 Buffer를 이용한 입출력이 훨씬 빠름.. 2배 이상

*/

public class ConnetElementCount_11724 {
	private static int n;		// 정점의 개수
	private static int m;		// 간선의 개수
	private static int map[][];
	private static boolean visited[];
	private static int cnt;
	
	// dfs()가 return 되면 연결 요소의 개수 ++
	private static int dfs(int start) {
		visited[start] = true;
		
		for(int i = 1; i <= n; i++) {
			if(map[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		n = scan.nextInt();
//		m = scan.nextInt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				cnt += dfs(i);
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		br.close();
		bw.close();
	}
}
