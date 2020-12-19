package samsung_SW_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

연산자 끼워넣기 (2) 분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	3112	1658	1354	54.073%
문제
N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 
또, 수와 수 사이에 끼워넣을 수 있는 연산자가 주어진다. 
연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다. 
연산자의 개수는 N-1보다 많을 수도 있다. 
모든 수의 사이에는 연산자를 한 개 끼워넣어야 하며, 주어진 연산자를 모두 사용하지 않고 모든 수의 사이에 연산자를 끼워넣을 수도 있다.

우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 
이때, 주어진 수의 순서를 바꾸면 안 된다.

예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 3개, 뺄셈(-) 2개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 250가지의 식을 만들 수 있다. 
예를 들어, 아래와 같은 식을 만들 수 있다.

1+2+3-4×5÷6
1÷2+3+4-5×6
1+2÷3×4-5+6
1÷2×3-4+5+6
1+2+3+4-5-6
1+2+3-4-5×6
식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 
또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 
음수를 양수로 나눌 때는 C++14의 기준을 따른다. 
즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 
이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.

1+2+3-4×5÷6 = 1
1÷2+3+4-5×6 = 12
1+2÷3×4-5+6 = 5
1÷2×3-4+5+6 = 7
1+2+3+4-5-6 = -1
1+2+3-4-5×6 = -18
N개의 수와 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)가 주어진다. 
둘째 줄에는 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 100) 
셋째 줄에는 합이 N-1보다 크거나 같고, 4N보다 작거나 같은 4개의 정수가 주어지는데, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다. 

출력
첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 
연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 
또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.

예제 입력 1 
2
5 6
1 1 1 1
예제 출력 1 
30
-1
예제 입력 2 
3
3 4 5
2 1 2 1
예제 출력 2 
60
-5
예제 입력 3 
6
1 2 3 4 5 6
3 2 1 1
예제 출력 3 
72
-48

*/

// InsertOperator_14888이랑 똑같은 답안으로 풀어도 된다.
// 난 그렇게 14888번을 풀었음
public class InsertOperator3_15658 {
	private static int N;
	private static int arr[];
	private static int result[];
	private static int operator[] = new int[4];
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		insertOperator(0);
		
		System.out.println(max);
		System.out.println(min);
		
		br.close();
	}
	
	private static void insertOperator(int depth) {
		if(depth == N-1) {
			int ans = operate(result);
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				result[depth] = i;
				operator[i]--;
				insertOperator(depth+1);
				operator[i]++;
			}
		}
	}
	
	private static int operate(int res[]) {
		int answer = arr[0];
		// 0 : +, 1 : -, 2 : *, 3 : /
		
		for(int i = 1; i < N; i++) {
			if(res[i-1] == 0) {
				answer += arr[i];
			}else if(res[i-1] == 1) {
				answer -= arr[i];
			}else if(res[i-1] == 2) {
				answer *= arr[i];
			}else if(res[i-1] == 3) {
				answer /= arr[i];
			}
		}
		
		return answer;
	}
}
