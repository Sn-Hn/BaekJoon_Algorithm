package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

소수&팰린드롬 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	7426	2030	1470	26.747%
문제
어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 
예를 들어 79,197과 324,423 등이 팰린드롬 수이다.

어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 조건을 만족하는 수를 출력한다.

예제 입력 1 
31
예제 출력 1 
101

*/

public class PrimeNumberAndPalindrome_1747 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(palindrome(N));
		
		br.close();
	}
	
	private static boolean primeNumber(int num) {
		int primeNumber = num;
		boolean flag = false;
		
		if(primeNumber == 1) {
			return false;
		}
		
		for(int i = 2; i < Math.sqrt(primeNumber); i++) {
			if(primeNumber % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	// 숫자를 뒤집었을 때 똑같은 것
	// 예를 들어 11 22 33 121 232 4554 ...
	private static int palindrome(int num) {
		String reverseNum = "";
		int result = num;
		while(true) {
			int compareNum = result;
			while(compareNum > 0) {
				reverseNum += compareNum%10;
				compareNum/=10;
			}
			
			if(result == Integer.parseInt(reverseNum) && primeNumber(result)) {
				break;
			}
			
			reverseNum = "";
			result++;
		}
		
		return result;
	}
}
