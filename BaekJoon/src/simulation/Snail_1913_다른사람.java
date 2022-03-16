package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 사용이 나보다 1/3
// 보고 배우자 

public class Snail_1913_다른사람 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int tofind = Integer.parseInt(br.readLine());

		int x=-1, y=-2;

		int[][] ar = new int[n][n];

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(j>i){
					if(i+j+2>n){
						ar[i][j] = (2*(j-n/2))*(2*(j-n/2))+1+(i-j);
					}
					else{
						ar[i][j] = (1-2*(n/2-i))*(1-2*(n/2-i))+j-i;
					}
				}
				else{
					if(i+j<n){
						ar[i][j] = (1+2*(n/2-j))*(1+2*(n/2-j))-(i-j);
					}
					else{
						ar[i][j] = (2*(i-n/2))*(2*(i-n/2))+1+(i-j);
					}
				}
			}
		}
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				sb.append(ar[i][j]).append(" ");
				if(ar[i][j]==tofind){
					x = i+1;
					y = j+1;
				}
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		System.out.print(x+" "+y);
	}
}
