package 제3회류호석배;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 빌런호석 {
	private static final int DIGITCOUNT = 10; 
	private static int N;
	private static int K;
	private static int P;
	private static int X;
	
	private static int count = 0;
	
	private static Integer[][] reverseDigital = 
		{
				{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
				{0, 0, 5, 3, 2, 5, 6, 1, 5, 4},
				{0, 0, 0, 2, 5, 4, 3, 4, 2, 3},
				{0, 0, 0, 0, 3, 2, 3, 2, 2, 1},
				{0, 0, 0, 0, 0, 3, 4, 3, 3, 2},
				{0, 0, 0, 0, 0, 0, 1, 4, 2, 1},
				{0, 0, 0, 0, 0, 0, 0, 5, 1, 2},
				{0, 0, 0, 0, 0, 0, 0, 0, 4, 3},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		setSymmetry();
		
		getList();
		
		System.out.println(count);
		
		
		br.close();
	}
	
	private static void getReverseAllCase(List<Integer> nowFloor, int p, int sum, int depth) {
		if (depth == K) {
			if (sum <= N && sum != X && sum > 0) {
				System.out.println("sum : " + sum);
				count++;
			}
			return;
		}
		
		int now = nowFloor.get(depth);
		
		for (int i = 0; i < DIGITCOUNT; i++) {
			int cnt = reverseDigital[now][i];
			int cur = merge(sum, i);
			if (p >= cnt && N >= cur) {
				System.out.println(p + ", " + cur);
				getReverseAllCase(nowFloor, p - cnt, cur, depth + 1);
			}
		}
	}
	
	private static int merge(int a, int b) {
		return 10 * a + b;
	}
	
	private static void getList() {
		List<Integer> nowFloor = getDigits(X);
		List<Integer> limits = getDigits(N);
		
		while (limits.size() > nowFloor.size()) {
			nowFloor.add(0, 0);
		}
		
		getReverseAllCase(nowFloor, P, 0, 0);
	}
	
	private static List<Integer> getDigits(int n) {
		List<Integer> digits = new ArrayList<>();
		while(n > 0) {
			digits.add(0, n % 10);
			n /= 10;
		}
		
		return digits;
	}
	
	private static void setSymmetry() {
		for (int i = 0; i < DIGITCOUNT; i++) {
			for (int j = 0; j < i; j++) {
				reverseDigital[i][j] = reverseDigital[j][i];
			}
		}
	}
	
}
