package stageBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수_2581_에라토스테네스의체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean isChecked[] = new boolean[10001];	// 예를 들어 10000까지의 수라고 가정
		isChecked[0] = isChecked[1] = false;
		
		for(int i = 2; i <= m; i++) {
			isChecked[i] = true;
		}
		
		for(int i = 2; i*i <= m; i++) {
			for(int j = i*i; j <= m; j+=i) {
				isChecked[j] = false;
			}
		}
		
		int sum = 0, min = 0;
		for(int i = n; i <= m; i++) {
			if(isChecked[i]) {
				if(min == 0) min = i;
				sum += i;
			}
		}
		
		if(sum + min == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);			
		}
		
		br.close();
	}
}
