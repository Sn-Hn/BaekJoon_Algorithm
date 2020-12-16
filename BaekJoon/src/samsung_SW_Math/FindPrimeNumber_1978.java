package samsung_SW_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

소수 찾기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	57478	26939	22181	48.290%
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1 
4
1 3 5 7
예제 출력 1 
3

*/

public class FindPrimeNumber_1978 {
	private static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(findPrimeNumber(a)) {
				sum += 1;
			}
		}
		
		System.out.println(sum);
		
		br.close();
	}
	
	private static boolean findPrimeNumber(int a) {
		if(a == 1) {
			return false;
		}else if(a == 2) {
			return true;
		}
		
		for(int i = 2; i <= Math.sqrt(a); i++) {
			if(a%i == 0) {
				return false;
			}
		}
		return true;
	}
}
