package samsung_SW_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

GCD 합 출처다국어분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	17424	6151	4960	36.836%
문제
양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있다. 
각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 
입력으로 주어지는 수는 1,000,000을 넘지 않는다.

출력
각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.

예제 입력 1 
3
4 10 20 30 40
3 7 5 12
3 125 15 25
예제 출력 1 
70
3
35

*/

public class SumOfGCD_9613 {
	private static int n = 0;
	private static boolean visited[];
	private static int arr[];
	private static int result[];
	private static long sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		result = new int[2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			visited = new boolean[n];
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println(sum);
			sum = 0;
		}
		
		br.close();
	}
	
	private static void dfs(int index, int depth) {
		if(depth == 2) {
			sum += sumGCD(Math.max(result[0], result[1]), Math.min(result[0], result[1]));
			
			return;
		}
		
		for(int i = index; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
	private static int sumGCD(int a, int b) {
		while(b > 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		
		return a;
	}
}
