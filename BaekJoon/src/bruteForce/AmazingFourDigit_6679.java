package bruteForce;

/*

싱기한 네자리 숫자란, [1000,9999]인 10진수 숫자중에서,  다음의 조건을 만족하는 숫자를 말한다.

숫자를 10진수, 12진수, 16진수로 나타낸 다음, 각각의 숫자에 대해, 각 숫자의 자리수를 더했을 때, 세 값이 모두 같아야 한다.
여러분은 싱기한 네자리 숫자를 모두 출력해야 한다.

입력은 주어지지 않는다.

싱기한 네자리 숫자를 오름차순으로 한줄에 하나씩 출력한다.

*/

public class AmazingFourDigit_6679 {
	public static void main(String[] args) {
		for(int i = 1000; i <= 9999; i++) {
			int decimalNum = 0;			// 10진법
			int duodecimalNum = 0;		// 12진법
			int hexadecimalNum = 0;		// 16진법
			
			for(int j = i; j > 0; j/=10) {
				decimalNum += j%10;
			}
			
			for(int j = i; j > 0; j/=12) {
				duodecimalNum += j%12;
			}
			
			for(int j = i; j > 0; j/=16) {
				hexadecimalNum += j%16;
			}
			
			if(decimalNum == duodecimalNum && duodecimalNum == hexadecimalNum) {
				System.out.println(i);
			}
			
		}
		
	}
}
