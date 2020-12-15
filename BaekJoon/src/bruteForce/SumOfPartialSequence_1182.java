package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

부분수열의 합 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	30137	13856	8769	44.223%
문제
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. 
(1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 
주어지는 정수의 절댓값은 100,000을 넘지 않는다.

출력
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.

예제 입력 1 
5 0
-7 -3 -2 5 8
예제 출력 1 
1

*/

// 백트래킹
public class SumOfPartialSequence_1182 {
	private static int[] arr;
	private static int n, s, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		// 처음부터 sum이 0으로 주어지기 때문에 0일 때 cnt를 1 줄여준다.
		System.out.print(s == 0 ? --cnt : cnt);

		br.close();
	}

	private static void dfs(int index, int sum) {
		// index가 배열의 끝까지 갔을 때
		if (index == n) {
			// sum이 s와 같다면 (즉, 원소끼리의 합이 입력해준 값과 같다면)
			if (sum == s)
				// 하나 증가
				cnt++;
			return;
		}
		
		// 현재의 원소 값을 더한 후 index를 1증가시킴
		dfs(index + 1, sum + arr[index]);
		// return해서 왔다면 현재 값을 증가시키지 않고 dfs를 돌림 (즉, 현재 원소를 더하지 않고 다음 원소를 더해줌)
		dfs(index + 1, sum);
		// 이렇게 넣어 줘야 완전탐색이 이루어짐 (백트래킹)
	}
}
