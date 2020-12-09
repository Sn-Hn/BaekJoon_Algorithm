package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*

리모컨 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	36994	8562	5829	22.387%
문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. 
+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 
어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다.

입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다. 
둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 
고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.

예제 입력 1 
5457
3
6 7 8
예제 출력 1 
6
예제 입력 2 
100
5
0 1 2 3 4
예제 출력 2 
0
예제 입력 3 
500000
8
0 2 3 4 6 7 8 9
예제 출력 3 
11117

*/

// 완전탐색
public class RemoteControl_1107 {
	private static List<Integer> breakDown = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			breakDown.add(Integer.parseInt(st.nextToken()));
		}

		int min = Math.abs(N - 100);
		// i는 0부터 500000까지의 임의 채널 500000에서 0도 있으니 2배
		for (int i = 0; i <= 1000000; i++) {
			int length = channel(i);

			if (length > 0)
				// 모든 경우의 수에 대한 최단거리를 min에 집어넣는다.
				min = Math.min(min, Math.abs(N - i) + length);
		}
		System.out.print(min);

		br.close();
	}

	private static int channel(int num) {
		int length = 0;
		
		// num이 0일 때, 버튼 num이 고장나지 않았다면 1, 고장났다면 0리턴
		if(num == 0) return breakDown.contains(num)? 0 : 1;
		
		// num의 자리수
		while(num > 0) {
			// num의 각 자리수가 고장난 버튼이면 0
			if(breakDown.contains(num % 10)) return 0;
			
			// 고장나지 않았다면 length++, 즉 자리수 개수
			length++;
			num /= 10;
		}
		return length;
	}
}
