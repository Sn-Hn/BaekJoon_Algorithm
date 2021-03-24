package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

가장 긴 증가하는 부분 수열 실패분류
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	69080	26512	17505	36.825%
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

예제 입력 1 
6
10 20 10 30 20 50
예제 출력 1 
4

*/

public class 가장긴증가하는부분수열_11053 {
	private static int N;
    private static int arr[];
    private static int dp[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
        	dp[i] = 1;
        	for(int j = 1; j <= i; j++) {
        		if(arr[i] > arr[j] && dp[i] <= dp[j]) {
        			dp[i] = dp[j] + 1;
        		}
        	}
        }
        
        for(int i : dp) System.out.print(i + " ");
        
        br.close();
    }
}
