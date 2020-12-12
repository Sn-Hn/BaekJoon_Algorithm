package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*	골드 5

N-Queen 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
10 초	128 MB	29734	16251	10665	54.388%
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92

*/

public class N_Queen_9663 {
	private static int N;
	private static int map[][];
	private static int depth = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		
		
		br.close();
	}
	
	private static void queen() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				

			}
		}
	}
}
