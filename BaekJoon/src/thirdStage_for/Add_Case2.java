package thirdStage_for;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Add_Case2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int A = Integer.parseInt(br.readLine());
		String str = "Case #";
		String str1 = ": ";
		for(int i = 1; i <= A; i++) {
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int sum = B+C;
			String Case = str + String.valueOf(i) +str1;
			bw.write(Case + B + " + " + C + " = " + sum + "\n");
		}
		bw.flush();
	}
}
