package samsung_SW_Graph_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*

ABCDE 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	9546	2804	1878	28.296%
문제
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

출력
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.

예제 입력 1 
5 4
0 1
1 2
2 3
3 4
예제 출력 1 
1
예제 입력 2 
5 5
0 1
1 2
2 3
3 0
1 4
예제 출력 2 
1
예제 입력 3 
6 5
0 1
0 2
0 3
0 4
0 5
예제 출력 3 
0
예제 입력 4 
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
예제 출력 4 
1

*/

// dfs의 깊이가 4인 것을 물어봄
// 시간초과...................
// 시간초과 해결이 안돼서 찾아보니 다들 List배열을 만듬
// List배열을 만들어 푸니 성공..

public class ABCDE_13023 {
	private static int N, M;
//	private static int relation[][];
	private static boolean visited[];
	private static boolean flag = false;
	private static List<Integer>[] friends; 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		relation = new int[N][N];
		visited = new boolean[N];
		friends = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			friends[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			relation[x][y] = relation[y][x] = 1;
			
			friends[x].add(y);
			friends[y].add(x);
		}
		
		for(int i = 0; i < N; i++) {
			if(!flag) {
				friend(i, 1);
			}
		}
		
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
		
		br.close();
	}
	
	private static void friend(int index, int count) {
		if(count == 5) {
			flag = true;
			return;
		}
		visited[index] = true;
		
		for(int i : friends[index]) {
			if(visited[i]) continue;
			visited[i] = true;
			friend(i, count+1);
		}
		
//		for(int i = 0; i < N; i++) {
//			if(relation[index][i] == 1 && !visited[i] && !flag) {
//				friend(i, count+1);
//			}
//		}
		visited[index] = false;
	}

}
