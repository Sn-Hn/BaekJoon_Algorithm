package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

/*

감소하는 수 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	11599	3027	2436	30.404%
문제
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 
예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. 
N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 
0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 
만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.

예제 입력 1 
18
예제 출력 1 
42

*/

// 출처 : https://roseline124.github.io/algorithm/2019/04/16/Algorithm-baekjoon-1038.html
public class DecreasingNumber_1038 {
	private static int N;
	private static List<Long> decreasingNumber = new ArrayList<Long>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int num = 0; num < 10; num++) {
			decrease(num, 1);
		}
		
		// 정렬
		Collections.sort(decreasingNumber);
		
		if(N >= decreasingNumber.size()) {
			System.out.println(-1);
		}
		else {
			System.out.println(decreasingNumber.get(N));
		}
		
		br.close();
	}
	
	// num은 맨 앞자리수
	private static void decrease(long num, int digit) {
		// 재귀는 9번까지 돌아감
		if(digit > 10) {
			return;
		}
		
		decreasingNumber.add(num);
		
		for(int i = 0; i < 10; i++) {
			if(num % 10 > i) {
				// num = 0 : 0
				// num = 1 : 10
				// num = 2 : 20 21
				// num = 3 : 30 31 32
				// ...
				// num = 30 : 0 = 0 이므로 넘어감
				// num = 31 : 1 > 0 이므로 310
				decrease((num * 10) + i, digit + 1);	// digit + 1 -> 재귀 깊이 +1
			}
		}
		
		
	}
	
}
