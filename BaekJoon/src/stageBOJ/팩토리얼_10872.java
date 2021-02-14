package stageBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

팩토리얼 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	61242	28994	24698	48.025%
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.

예제 입력 1 
10
예제 출력 1 
3628800
예제 입력 2 
0
예제 출력 2 
1

*/

public class 팩토리얼_10872 {
	private static int sum = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(solution(N));
		
		br.close();
	}
	
	private static int solution(int n) {
		if(n == 0) return sum;
		sum *= n;
		
		return solution(n-1);
	}
}
