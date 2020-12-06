package arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

배열 회전 스페셜 저지
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
10 초	128 MB	144	0	0	0.000%
문제
1부터 N까지의 자연수가 차례로 적혀 있는 배열이 있다. 아래의 배열은 N=6인 경우의 예이다.

1	2	3	4	5	6
이러한 배열에서 임의의 구간 (a, b)를 잡아, 그 구간에 포함되는 수들을 회전시킬 수 있다. 
회전을 하게 되면 a번째 칸부터 b번째 칸까지 적혀 있는 수의 순서가 뒤집히고, 부호 또한 바뀌게 된다. 
(1≤a≤b≤N) 예를 들어 위의 배열에서 (1, 4)에서 회전을 수행한 결과는 아래와 같이 된다.

-4	-3	-2	-1	5	6
이미 회전을 수행한 배열에 대해서도 물론 계속 회전을 수행할 수 있다. 다시 (3, 5)에서 회전을 수행하면 최종 배열 상태는 아래와 같이 된다.

-4	-3	-5	1	2	6
초기 배열에는 1부터 N까지의 자연수가 차례로 적혀 있다. 
최종 배열 상태가 주어졌을 때 가급적 적은 횟수의 회전 연산을 수행하여 초기 배열에서 최종 배열을 만드는 프로그램을 작성하시오.

입력
첫째 줄에 배열의 크기 N(1≤N≤250)이 주어진다. 
둘째 줄에는 최종 배열 상태가 빈 칸을 사이에 두고 순서대로 주어진다. 
주어지는 수열에는 절댓값이 1 이상 N 이하인 수들이 모두 한 번씩 등장한다.

출력
첫 줄에 회전 연산의 사용 횟수 K를 출력한다. 
이어서 K줄에 걸쳐 연산을 사용한 순서대로 회전 연산을 사용한 구간 (a, b)를 나타내는 두 정수 a와 b를 빈 칸을 사이에 두고 출력한다. (1≤a≤b≤N)

예제 입력 1 
6
-4 -3 -5 1 2 6
예제 출력 1 
2
1 4
3 5

*/

public class ArrRotate_1845 {
	private static int K;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		
		
		br.close();
	}
}
