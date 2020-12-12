package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 에라토스테네스의 체
// 내가 푼 방식으로는 메모리와 시간이 많이 잡아먹는다.
// 백준상에서는 간신히 통과한듯한 느낌
// 소수를 구할 때 에라토스테네스의 체로 구하면 짧아진다고 한다.

public class PrimeNumberAndPalindrome_에라토스테네스의체 {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(palindrome(N));
		
		br.close();
	}
	
	private static boolean primeNumber(int num) {
		int primeNumber = num;
		boolean flag = false;
		
		if(primeNumber == 1) {
			return false;
		}
		
		for(int i = 2; i <= Math.sqrt(primeNumber); i++) {
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
			int temp = 0;
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
