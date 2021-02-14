package stageBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

소수 출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	43765	17023	14835	39.332%
문제
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.

입력
입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.

M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

출력
M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 

단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.

예제 입력 1 
60
100
예제 출력 1 
620
61
예제 입력 2 
64
65
예제 출력 2 
-1

*/

public class 소수_2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		findFrimeNumber(N, M);
		
		br.close();
	}
	
	private static void findFrimeNumber(int n, int m) {
		boolean flag = true;
		int sum = 0;
		int min = 0;
		for(int i = n; i <= m; i++) {
			if(isFrimeNumber(i) ) {
				sum += i;
				if(flag) min = i; flag = false;
			}
		}
		if(sum + min == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);			
		}
	}
	
	private static boolean isFrimeNumber(int n) {
		if(n == 1) return false;
		if(n == 2) return true;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
