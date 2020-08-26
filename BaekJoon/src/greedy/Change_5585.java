package greedy;

import java.util.Scanner;

/*

타로는 자주 JOI잡화점에서 물건을 산다. 
JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 
언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 
타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 
받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.

예를 들어 입력된 예1의 경우에는 아래 그림에서 처럼 4개를 출력해야 한다.

입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.

입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.

*/

public class Change_5585 {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		int money = 1000-n;
//		int change[] = new int[6];
//		int cnt = 0;
//		
//		while(money > 0) {
//			if(money >= 500) {
//				change[0]++;
//				money -= 500;
//			}else if(money >= 100) {
//				change[1]++;
//				money -= 100;
//			}else if(money >= 50) {
//				change[2]++;
//				money -= 50;
//			}else if(money >= 10) {
//				change[3]++;
//				money -= 10;
//			}else if(money >= 5) {
//				change[4]++;
//				money -= 5;
//			}else if(money >= 1) {
//				change[5]++;
//				money -= 1;
//			}
//		}
//		for(int i : change) {
//			cnt += i;
//		}
//		
//		System.out.println(cnt);
//		
//	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int money = 1000-n;
		int cnt = 0;
		
		cnt += money / 500;
		money %= 500;
		
		cnt += money / 100;
		money %= 100;
		
		cnt += money / 50;
		money %= 50;
		
		cnt += money / 10;
		money %= 10;
		
		cnt += money / 5;
		money %= 5;
		
		cnt += money / 1;
		
		System.out.println(cnt);
		
		
		
	}
	
}
