package thirdStage_for;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FastAdd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int A = Integer.parseInt(br.readLine());
		for(int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());	// Enter 치면 C값 인식 X
			int C = Integer.parseInt(st.nextToken());
			int sum = B+C;
			bw.write(sum+"\n");
			
			
		}
		bw.flush();
	}
}
