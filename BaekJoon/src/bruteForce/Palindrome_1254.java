package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

팰린드롬 만들기 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	4148	1625	1308	41.119%
문제
동호와 규완이는 212호에서 문자열에 대해 공부하고 있다. 
규완이는 팰린드롬을 엄청나게 좋아한다. 
팰린드롬이란 앞에서부터 읽으나 뒤에서부터 읽으나 같게 읽히는 문자열을 말한다.

동호는 규완이를 위한 깜짝 선물을 준비했다. 
동호는 규완이가 적어놓고 간 문자열 S에 0개 이상의 문자를 문자열 뒤에 추가해서 팰린드롬을 만들려고 한다. 
동호는 가능하면 가장 짧은 문자열을 만들려고 한다.

동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열 S가 주어진다. S의 길이는 최대 1000이다.

출력
첫째 줄에 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력한다.

예제 입력 1 
abab
예제 출력 1 
5

*/

public class Palindrome_1254 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		System.out.println(solution(S));
		br.close();
	}

	private static int solution(String input) {

		int len = input.length();
		for (int i = 0; i < len; i++) {
			// 맨 끝에 추가 하는 것 보다 하나씩 지우면서 검사하는 것이 더 효율적
			if (isPalindrome(input.substring(i))) {
				return len + i;
			}
		}
		return len;
	}

	private static boolean isPalindrome(String input) {
		int len = input.length();
		for (int i = 0; i < len / 2; i++) {
			if (input.charAt(i) != input.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
