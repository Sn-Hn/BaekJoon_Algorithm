package bfs;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;

/*

교환 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	7006	1336	1017	20.147%
문제
0으로 시작하지 않는 정수 N이 주어진다. 이때, M을 정수 N의 자릿수라고 했을 때, 다음과 같은 연산을 K번 수행한다.

1 ≤ i < j ≤ M인 i와 j를 고른다. 그 다음, i번 위치의 숫자와 j번 위치의 숫자를 바꾼다. 이때, 바꾼 수가 0으로 시작하면 안 된다.

위의 연산을 K번 했을 때, 나올 수 있는 수의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N과 K가 주어진다. N은 1,000,000보다 작거나 같은 자연수이고, K는 10보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제에 주어진 연산을 K번 했을 때, 만들 수 있는 가장 큰 수를 출력한다. 만약 연산을 K번 할 수 없으면 -1을 출력한다.

예제 입력 1 
16375 1
예제 출력 1 
76315
예제 입력 2 
132 3
예제 출력 2 
312

31299 2
99231

*/

public class 교환_1039_그리디_실패 {
	private static int N, K;
	private static int inputLen = 0;
	private static int sub = 0;
	private static int digitsNumber[];
	private static int copyNumber[];
	private static int max = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		inputLen = input.length();
		digitsNumber = new int[inputLen];
		copyNumber = new int[inputLen];
		N = Integer.parseInt(input);
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < inputLen; i++) {
			digitsNumber[i] = input.charAt(i) - '0';
		}
		if(isChecked()) {
			changeDigits(0, 0);			
			System.out.println(max);
		}else {
			System.out.println(-1);
		}
		
		
		br.close();
	}
	
	private static void changeDigits(int digit, int k) {
		if(k == K) {
			max = Math.max(max, parseInt());
			return;
		}
		
		if(digit == inputLen - 1) {
			sub = K - k;
			for(int i = 0; i < sub; i++) {
				swap(inputLen-2, inputLen-1);
			}
			max = Math.max(max, parseInt());
			return;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		int maxNum = -1;
		int index = 0;
		for(int i = digit; i < inputLen; i++) {
			if(maxNum < digitsNumber[i]) {
				maxNum = digitsNumber[i];
				index = i;
				list.clear();
			}else if(maxNum == digitsNumber[i])	{
				list.add(index);
				maxNum = digitsNumber[i];
				index = i;
			}
		}
		list.add(index);
		for(int i = 0; i < list.size(); i++ ) {
			copy();
			if(digitsNumber[list.get(i)] == digitsNumber[digit]) {
				changeDigits(digit+1, k);						
			}else {
				swap(list.get(i), digit);
				changeDigits(digit+1, k+1);						
			}
		}
	}
	
	private static boolean isChecked() {
		int digit = (int)Math.pow(10, inputLen-1);
		if(N % digit == 0) return false;
		return true;
	}
	
	private static void swap(int a, int b) {
		int temp = copyNumber[a];
		copyNumber[a] = copyNumber[b];
		copyNumber[b] = temp;
	}
	
	private static int parseInt() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < inputLen; i++) {
			sb.append(copyNumber[i]);	
		}
		
//		System.out.println(sb.toString());
		return Integer.parseInt(sb.toString());
	}
	
	private static void restore() {
		for(int i = 0; i < inputLen; i++) {
			digitsNumber[i] = copyNumber[i];
		}
	}
	
	private static void copy() {
		for(int i = 0; i < inputLen; i++) {
			copyNumber[i] = digitsNumber[i];
		}
	}
}
