package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*

숨바꼭질 4 스페셜 저지분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	11171	3928	2701	33.544%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.

입 / 출력 Hint (스페셜 저지)
두 예제 중 하나만이라도 출력하면 된다.

예제 입력 1 
5 17
예제 출력 1 
4
5 10 9 18 17
예제 입력 2 
5 17
예제 출력 2 
4
5 4 8 16 17

*/

public class HideAndSeek4_13913 {
	private static int N, K;
	private static int[] time = new int[100001];
	private static int[] move = new int[100001];
	private static int minTime = 1000000000;
	
	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		time[n] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == K) {
				minTime = time[now];
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				int next = 0;
				if(i == 0) {
					next = now + 1;
				}else if(i == 1) {
					next = now - 1;
				}else {
					next = now * 2;
				}
				
				
				if(next >= 0 && next < time.length && time[next] == 0) {
					q.add(next);
					time[next] = time[now] + 1;
					move[next] = now;
				}
				
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);
		
		// 방문 처리를 위해 bfs에서 time[n] = 1로 설정해놓았기 때문에
		// 현재는 +1이 되어있음
		System.out.println(minTime-1);
		
		Stack<Integer> movePath = new Stack<>();
		int index = K;
		movePath.push(index);
		while(index != N) {
			movePath.push(move[index]);
			index = move[index];
		}
		
		while(!movePath.isEmpty()) {
			System.out.print(movePath.pop() + " ");
		}
		
		
		br.close();
	}
}
