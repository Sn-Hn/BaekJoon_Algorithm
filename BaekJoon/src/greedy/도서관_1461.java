package greedy;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

/*

도서관
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	3098	1204	951	38.928%
문제
세준이는 도서관에서 일한다. 
도서관의 개방시간이 끝나서 세준이는 사람들이 마구 놓은 책을 다시 가져다 놓아야 한다. 
세준이는 현재 0에 있고, 사람들이 마구 놓은 책도 전부 0에 있다. 
각 책들의 원래 위치가 주어질 때, 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수를 계산하는 프로그램을 작성하시오. 
세준이는 한 걸음에 좌표 1칸씩 가며, 책의 원래 위치는 정수 좌표이다. 
책을 모두 제자리에 놔둔 후에는 다시 0으로 돌아올 필요는 없다. 
그리고 세준이는 한 번에 최대 M권의 책을 들 수 있다.

입력
첫째 줄에 책의 개수 N과, 세준이가 한 번에 들 수 있는 책의 개수 M이 주어진다. 
둘째 줄에는 책의 위치가 주어진다. 
N은 10,000보다 작거나 같은 자연수이고, M은 10,000보다 작거나 같다. 
책의 위치는 0이 아니며, 그 절댓값이 10,000보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1 
7 2
-37 2 -6 -39 -29 11 -28
예제 출력 1 
131

*/

// https://www.acmicpc.net/problem/1461
public class 도서관_1461 {
	private static int N;
	private static int M;
	private static int[] bookPosition;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bookPosition = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int max = 0;
		int index = 0;
		for (int i = 0; i < N; i++) {
			bookPosition[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(bookPosition);
		
		print();
		int farthest = getFarthest();
		
		
		
		br.close();
	}
	
	private static void getStepCount() {
		int farthest = getFarthest();
		
		
		int step = 0;
		int j = 0;
		int count = 0;
		for (int i = 0; i < N; i ++) {
			step = step + bookPosition[i] * 2;
		}
	}
	
	private static int getStartPosition() {
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < N; i++) {
			if (min > Math.abs(bookPosition[i])) {
				min = Math.abs(bookPosition[i]);
				index = i;
			}
		}
		
		return index;
	}
	
	// true : 절대값이 양수가 더 큼
	// false : 절대값이 음수가 더 큼
	// 절대값을 구하는 이유는 제일 먼 곳을 찾기 위함
	// 제일 먼 곳을 구해 가장 마지막에 가져다 놓아 돌아오는 걸음 수를 줄이기 위해 
	private static int getFarthest() {
		if (Math.abs(bookPosition[0]) < Math.abs(bookPosition[N - 1])) {
			return N - 1;
		}
		
		return 0;
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(bookPosition[i] + " ");
		}
		System.out.println();
	}
}
