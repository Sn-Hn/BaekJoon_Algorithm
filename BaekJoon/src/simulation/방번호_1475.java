package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

문제
다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. 
(6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

입력
첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 필요한 세트의 개수를 출력한다.

예제 입력 1 
9999
예제 출력 1 
2

*/

public class 방번호_1475 {
	private static int N;
	private static int arr[] = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = N;
		int num = 0;
		
		while(N > 0) {
			num = N % 10;
			N /= 10;
			
			if(num == 9) {
				num = 6;
			}
			arr[num]++;
		}
		
		int max = -1;
		for(int i = 0; i < 10; i++) {
			if(i != 6) {
				if(max <= arr[i]) {
					max = arr[i];
				}				
			}else {
				if(max <= arr[i]/2 + arr[i]%2) {
					max = arr[i]/2 + arr[i]%2;
				}
			}
		}
		
		if(result == 0) max = 1;
		
		System.out.println(max);
		
		br.close();
	}
}
