package samsung_SW_Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

최대공약수와 최소공배수 출처분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	31623	18769	15426	63.307%
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

예제 입력 1 
24 18
예제 출력 1 
6
72

*/

// 최대공약수는 유클리드 호제법!! 
// 여기서 기억할 공식은 큰 수 A를 작은수 B로 나누었을때 나누어 떨어진다면 최대공약수는 B가 된다.
// 1)  입력 받은 두 수중 큰 수를 A, 작은수를 B로 정한다.
// 2)  A 를 B 로 나눈값의 나머지를 R로 지칭한다.
// 3)  R 이 0이라면 A는 B로 나누어 지기 때문에 최대 공약수는 B가 된다.
// 4)  만약 R이 0이 아니라면 A값은 B로, B 값은 R로 변경한뒤 3번 과정을 반복한다. 

class GCD_LCM_2609 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		
		// 유클리드 호제법으로 푼 최대공약수
		System.out.println(GCD1(max, min));
		System.out.println(LCM(max, min));
		
		br.close();
	}
	
	private static int GCD(int a, int b) {
		while(b > 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		return a;
	}
	
	// 재귀.. 깔끔
	private static int GCD1(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return GCD1(b, a%b);
		}
	}
	
	// 두수를 곱한 후 최대공약수로 나누면 된다.
	private static int LCM(int a, int b) {
		return (a*b)/GCD(a, b);
	}
}
