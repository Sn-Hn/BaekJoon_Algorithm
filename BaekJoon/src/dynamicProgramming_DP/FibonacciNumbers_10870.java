package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*

문제
피보나치 수는 0과 1로 시작한다. 
0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.

n=17일때 까지 피보나치 수를 써보면 다음과 같다.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 n번째 피보나치 수를 출력한다.

예제 입력 1 
10
예제 출력 1 
55

*/

public class FibonacciNumbers_10870 {
	private static int visited[];
	
	private static int fibo(int n) {
		if(n == 0) return 0;	// 수열의 첫 번째 수
		if(n == 1) return 1;	// 수열의 두 번째 수
								// 수열의 첫 번째, 두 번째 수만 있다면 피보나치 수열은 끝
		if(visited[n] != 0) {
			return visited[n];
		}
		
		return visited[n] = fibo(n-1) + fibo(n-2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		visited = new int[num+1];
		
		bw.write(String.valueOf(fibo(num)));
		
		br.close();
		bw.close();
		
	}
}
