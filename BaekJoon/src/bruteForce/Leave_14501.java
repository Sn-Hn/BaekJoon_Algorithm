package bruteForce;

import java.util.Arrays;
import java.util.Scanner;

/*  실버 4

상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.

오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.

백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.

각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.

N = 7인 경우에 다음과 같은 상담 일정표를 보자.

 	1일	2일	3일	4일	5일	6일	7일
Ti	3	5	1	1	2	4	2
Pi	10	20	10	20	15	40	200

1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 
5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.

상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 
예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 
2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.

또한, N+1일째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.

퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이때의 이익은 10+20+15=45이다.

상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.

둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 
1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)

첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.

무조건 !!!! 점화식 세우기

점화식 : solve(i) = Max(solve(i+time[i])+pay[i], solve(i+1))
	 -> 오늘 상담을 할 것인지 ? 아니면 내일 할 것인지 ? 두가지의 이득 중 더 큰 것을 고름.....
	 
*/

public class Leave_14501 {
	private static int n;
	private static int time[];
	private static int pay[];
	private static int dp[];
	private static int check[];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		time = new int[n+10];
		pay = new int[n+10];
		dp = new int[n+10];
		check = new int[n+10];
		
		for(int i = 1; i <= n; i++) {
			time[i] = scan.nextInt();
			pay[i] = scan.nextInt();
		}
		Arrays.fill(check, -1);
		
		maxProfit(1);
		int ans = solve(1);
		int dpAns = DPsolve(1);
		
		System.out.println("brute force : " + ans);
		System.out.println("DP : " + dpAns);
	}
	
	/* DP를 이용한 방식 */
	private static void maxProfit(int idx) {
		int max = 0;
		
		// 점화식
		// dp[i] = dp[i]+
		for (int i = 1; i <=n+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[time[i]+i] = Math.max(dp[time[i]+i],pay[i]+dp[i]);
            max = Math.max(max, dp[i]);
            
        }
        System.out.println("max : " + max);
	}
	
	/* brute force를 이용한 방식 (재귀) */
	private static int solve(int i) {
		if(i > n) {
			return 0;
		}
		int max = 0;		// 최대값
		if(i+time[i] <= n+1) {
			// 이 경우는 i의 위치에 있을 경우 i의 일을 그냥 한 경우.
			// 만약 i가 1일 때, 1일차의 상담을 진행하는 경우.
			max = solve(i+time[i]) + pay[i];
		}
		// max는 i일차의 상담을 진행한 경우이고, 
		// solve(i+1)은 i일차의 상담을 진행하지 않고 그 다음날의 상담을 진행한 경우
		// 따라서 두 가지를 비교하여 큰 수를 max에 담는다.
		return max = Math.max(max, solve(i+1));
		
	}
	
	// DP는 로직을 한 번만 사용할 수 있도록 만들어주는 프로그래밍 기법
	// 따라서 check배열이 이미 수행한 로직인지 체크해준다.
	private static int DPsolve(int i) {
		if(i > n) {
			return 0;
		}
		// DP를 이용하기 위한 check배열
		int max = check[i];
		if(max != -1) {
			return max;
		}
		if(i+time[i] <= n+1) {
			max = DPsolve(i+time[i]) + pay[i];
		}
		return max = Math.max(max, DPsolve(i+1));
	}

}
