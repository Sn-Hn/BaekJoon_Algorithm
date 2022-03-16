package thirdStage_for;

import java.io.*;

public class UptoN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= A; i++) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}
