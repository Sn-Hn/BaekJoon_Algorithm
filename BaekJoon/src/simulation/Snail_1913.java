package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*

문제
홀수인 자연수 N(3≤N≤999)이 주어지면, 다음과 같이 1부터 N2까지의 자연수를 달팽이 모양으로 N*N의 표에 늘어놓을 수 있다.

9	2	3
8	1	4
7	6	5
25	10	11	12	13
24	9	2	3	14
23	8	1	4	15
22	7	6	5	16
21	20	19	18	17
N이 주어졌을 때, 이러한 표를 출력하는 프로그램을 작성하시오. 
또한 N2 이하의 자연수가 하나 주어졌을 때, 그 좌표도 함께 출력하시오. 
예를 들어 N=5인 경우 6의 좌표는 (4,3)이다.

입력
첫째 줄에 홀수인 자연수 N이 주어진다. 
둘째 줄에는 위치를 찾고자 하는 N2 이하의 자연수가 하나 주어진다.

출력
N개의 줄에 걸쳐 표를 출력한다. 
각 줄에 N개의 자연수를 한 칸씩 띄어서 출력하면 되며, 자릿수를 맞출 필요가 없다. 
N+1번째 줄에는 입력받은 자연수의 좌표를 나타내는 두 정수를 한 칸 띄어서 출력한다.

예제 입력 1 
7
35
예제 출력 1 
49 26 27 28 29 30 31
48 25 10 11 12 13 32
47 24 9 2 3 14 33
46 23 8 1 4 15 34
45 22 7 6 5 16 35
44 21 20 19 18 17 36
43 42 41 40 39 38 37
5 7


*/

// 메모리 너무 많이 썼다.. 시간도 꽤 많이 뺏겼다 1시간 걸린듯 실버 5라고 무시하면 안되겠다..
// 다른 사람 코딩 보고 배우자
public class Snail_1913 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int index = Integer.parseInt(br.readLine());
		int NN = N*N;
		
		int snail[][] = new int[N][N];
		boolean visited[][] = new boolean[N][N];
		int k = 0;
		int i = 0;
		int j = 0;
		int temp = N;
		boolean stamp = false;
		
		while(true) {
			if(!stamp) {
				for(i = k; i < temp; i++) {
					snail[i][k] = NN;
					NN--;
				}
				i--;
				for(j = k+1; j < temp; j++) {
					snail[i][j] = NN;
					NN--;
					
				}
				j--;
				stamp = true;
				temp--;
			}else {
				for(; i > k; i--) {
					snail[i-1][j] = NN;
					NN--;						
				}
				for(; j > k+1; j--) {
					snail[k][j-1] = NN;
					NN--;
				}
				stamp = false;
				k++;
			}
			if(NN == 0) {
				break;
			}
			
		}
		
		for(int m = 0; m < N; m++) {
			for(int n = 0; n < N; n++) {
				bw.write(String.valueOf(snail[m][n]) + " ");
				if(snail[m][n] == index) {
					i = m+1;
					j = n+1;
				}
			}
			bw.newLine();
		}
		
		bw.write(i + " " + j);
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
