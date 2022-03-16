package bruteForce;

import java.util.*;
public class TheSevenDwarfs_2309 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int[] arr = new int[9];
        int sum = 0;
        
        for(int i = 0; i < 9; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }
        
        for(int i = 0; i < 8; i++) {
        	if(flag) break;
            for(int j = i+1; j < 9; j++) {
                if(sum - (arr[i] + arr[j]) == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    flag = true;
                    break;
                }
            }
        }
        Arrays.sort(arr);
        
        for(int i = 0; i < 9; i++) {
            if(arr[i] != 0) System.out.println(arr[i]);
        }
        
        
    }
}