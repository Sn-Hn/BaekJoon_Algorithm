package bruteForce;

import java.util.ArrayList;
import java.util.Scanner;

/*

2~15개의 서로 다른 자연수로 이루어진 리스트가 있을 때, 이들 중 리스트 안에 자신의 정확히 2배인 수가 있는 수의 개수를 구하여라.
예를 들어, 리스트가 "1 4 3 2 9 7 18 22"라면 2가 1의 2배, 4가 2의 2배, 18이 9의 2배이므로 답은 3이다.

입력은 여러 개의 테스트 케이스로 주어져 있으며, 입력의 끝에는 -1이 하나 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 2~15개의 서로 다른 자연수가 주어진다. 
각 자연수는 100보다 작으며, 리스트의 끝은 0으로 판별한다(0은 리스트에 속하지 않는다).

*/

public class Doubles_4641 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(scan.hasNext()) {
			
			int cnt = 0;
			int num = scan.nextInt();
			list.add(num);
			if(num == 0) {
				list.remove(list.size()-1);
				for(int i = 0; i < list.size(); i++) {
					for(int j = 0; j < list.size(); j++) {
						if(list.get(i)*2 == list.get(j)) cnt++;
					}
				}
				System.out.println(cnt);
				list.clear();
			}
			
		}
		
		
		
	}
}
