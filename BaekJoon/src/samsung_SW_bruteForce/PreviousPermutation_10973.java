package samsung_SW_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

이전 순열 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	6592	4169	3467	65.663%
문제
1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.

사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.

N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.

1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
입력
첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

출력
첫째 줄에 입력으로 주어진 순열의 이전에 오는 순열을 출력한다. 만약, 사전순으로 가장 처음에 오는 순열인 경우에는 -1을 출력한다.

예제 입력 1 
4
1 2 3 4
예제 출력 1 
-1
예제 입력 2 
5
5 4 3 2 1
예제 출력 2 
5 4 3 1 2

*/

public class PreviousPermutation_10973 {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (previous(arr)) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
		
		
		br.close();
	}
	
	private static boolean previous(int arr[]) {
		int a = arr.length-1;
		while(a > 0 && arr[a] > arr[a-1]) a--;
		
		if(a <= 0) {
			return false;
		}
		
		int b = arr.length-1;
		while(arr[a-1] < arr[b]) b--;
		
		swap(arr, a-1, b);
		
		int start = a;
		int end = arr.length-1;
		
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
		
		return true;
	}
	
	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
