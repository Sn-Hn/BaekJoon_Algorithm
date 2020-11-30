package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

숨바꼭질 2 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	12184	3291	2282	25.655%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고, 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
2

*/

public class HideAndSeek2_12851 {
	private static int N, K;
	private static int check[] = new int[100001];
	private static int count = 0;
	private static int minTime = 1000000000;
	
	private static void bfs(int n) { 
		Queue<Integer> q = new LinkedList<Integer>();
		check[n] = 1;
		q.add(n);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(minTime < check[now]) {
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				int next = 0;
				
				if(i == 0) {		// 앞으로 한칸
					next = now + 1;
				}else if(i == 1) {	// 뒤로 한칸
					next = now - 1;
				}else {				// 현재 위치에서 * 2 (순간이동)					
					next = now * 2;
				}
				
				// next는 0보다 크고 100000보다 작아야 한다.
				if(next < 0 || next >= check.length) {
					continue;
				}
				
				if(next == K) {
					minTime = check[now];
					count ++;
				}
				
				// 이미 방문했더라도 경우의 수 카운팅을 위해 큐에 넣어줌
				if(check[next] == 0 || check[next] == check[now] + 1) {
					q.add(next);
					check[next] = check[now] + 1;
				}
				
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// N이 더 클 경우도 계산
		if(N >= K) {
			System.out.println(N-K);
			System.out.println(1);
			return;
		}else {
			bfs(N);			
		}
		
		
		System.out.println(minTime);
		System.out.println(count);
		
		br.close();
	}
}
