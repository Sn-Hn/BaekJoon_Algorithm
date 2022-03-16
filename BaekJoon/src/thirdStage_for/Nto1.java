package thirdStage_for;

import java.io.*;

public class Nto1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A = Integer.parseInt(br.readLine());
		
		for(int i = A; i >= 1; i--) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}
