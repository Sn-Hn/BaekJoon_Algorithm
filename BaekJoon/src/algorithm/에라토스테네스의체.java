package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수 구하기 알고리즘

public class 에라토스테네스의체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean isChecked[] = new boolean[10001];	// 예를 들어 10000까지의 수라고 가정
		isChecked[0] = isChecked[1] = false;
		
		for(int i = 2; i <= n; i++) {
			isChecked[i] = true;
		}
		
		for(int i = 2; i*i <= n; i++) {
			for(int j = i*i; j <= n; j+=i) {
				isChecked[j] = false;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(isChecked[i]) System.out.println(i);
		}
		
		br.close();
	}
}
