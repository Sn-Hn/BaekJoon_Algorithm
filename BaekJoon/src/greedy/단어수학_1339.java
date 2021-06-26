package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

단어 수학 실패
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	14262	6100	4587	43.433%
문제
민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다.
이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 
같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 
둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 
단어는 알파벳 대문자로만 이루어져있다. 
모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 
서로 다른 문자는 서로 다른 숫자를 나타낸다.

출력
첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.

예제 입력 1 
2
AAA
AAA
예제 출력 1 
1998
예제 입력 2 
2
GCF
ACDEB
예제 출력 2 
99437
예제 입력 3 
10
A
B
C
D
E
F
G
H
I
J
예제 출력 3 
45
예제 입력 4 
2
AB
BA
예제 출력 4 
187

*/

public class 단어수학_1339 {
	private static int N;
	private static String[] words;
	private static int[] alphabet = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		
		int maxLen = 0;
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			maxLen = Math.max(maxLen, words[i].length());
		}
		
		getCoefficient();
		
		Arrays.sort(alphabet);
		
		int num = 9;
		int sum = 0;
		for (int i = alphabet.length - 1; i >= 0; i--) {
			if (alphabet[i] == 0) {
				break;
			}
			
			sum = sum + alphabet[i] * num;
			num--;
		}
		
		System.out.println(sum);
		
//		print();
		
		br.close();
	}
	
	private static void getCoefficient() {
		for (int i = 0; i < N; i++) {
			int len = words[i].length();
			int index = 0;
			for (int j = len - 1; j >= 0; j--) {
				alphabet[words[i].charAt(j) - 65] += (int) Math.pow(10, index);
				index++;
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
		System.out.println();
	}
}
