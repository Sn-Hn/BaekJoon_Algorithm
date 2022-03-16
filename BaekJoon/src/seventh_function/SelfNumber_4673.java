package seventh_function;


public class SelfNumber_4673 {
	public static void main(String[] args) {
		boolean[] flag = new boolean[10000];
		for(int i = 0; i < flag.length; i++) {
			flag[i] = true;
		}
		
		for(int i = 0; i < flag.length; i++) {
			if(selfNumber(i+1) < 10000) {
				flag[selfNumber(i+1)] = false;				
			}
		}
		for(int i = 1; i < flag.length; i++) {
			if(flag[i] != false) {
				System.out.println(i);
			}
		}
	}
	
	public static int selfNumber(int n) {
		int sum = 0;
		sum += n;
		while(n>0) {
			sum += n%10;
			n/=10;
		}
		return sum;
		
	}
}
