package dynamicProgramming_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기_11048 {
	private static int N, M;
    private static int map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = Math.max(map[i-1][j], map[i][j-1]) + a;
            }
        }
        
        System.out.println(map[N][M]);
        
        br.close();
    }
}
