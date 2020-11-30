package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*

숨바꼭질 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	90088	24965	15522	24.847%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1 
5 17
예제 출력 1 
4
힌트
수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

*/

// 출처 : https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88
// BFS도 많이 풀어봐야겠다

public class HideAndSeek1_1697 {
	private static int N, K;
	private static int[] check = new int[100001];
//	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N >= K) {
            System.out.println(N-K);
        } else {
            bfs(N);
        }
		
//		for(int i : check) {
//			System.out.println("i : " + i);
//		}
		
//		System.out.println("count : " + count);

		br.close();
	}
	
	// BFS 
	// 다익스트라랑 되게 비슷한듯
	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		check[num] = 1;
		q.add(num);

		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int i = 0; i < 3; i++) {
				int next = 0;

				if (i == 0) {
					next = temp + 1;
				} else if (i == 1) {
					next = temp - 1;
				} else {
					next = temp * 2;
				}

				if (next == K) {
					System.out.println(check[temp]);
//					count++;
					return;
				}

				if (next >= 0 && next < check.length && check[next] == 0) {
					q.add(next);
					check[next] = check[temp] + 1;
				}
			}
		}
	}

}
