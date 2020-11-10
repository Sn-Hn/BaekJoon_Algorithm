package nhn_공개채용;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0

4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0

*/

class PracticeProblem {
	private static boolean visited[][];
	private static int[] dx = {0 ,0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	private static int sizeOfArr;
	
	private static int arrAreaOfCnt(int x, int y, int sizeOfMatrix, int[][] matrix) {
		visited[x][y] = true;
		
		for(int i = 0; i <dx.length; i++) {
			int X = dx[i] + x;
			int Y = dy[i] + y;

			if(X >= 0 && Y >= 0 && X < sizeOfMatrix && Y < sizeOfMatrix) {
				if(!visited[X][Y] && matrix[X][Y] == 1) {
					sizeOfArr++;
					arrAreaOfCnt(X, Y, sizeOfMatrix, matrix);
				}
			}
		}
		
		return 1;
	}

	private static void solution(int sizeOfMatrix, int[][] matrix) {
		// TODO: 이곳에 코드를 작성하세요.
		visited = new boolean[sizeOfMatrix][sizeOfMatrix];
		int cntOfArr = 0;
		List<Integer> sizeOfArrList = new ArrayList<Integer>();
		for(int i = 0; i < sizeOfMatrix; i++) {
			for(int j = 0; j < sizeOfMatrix; j++) {
				if(!visited[i][j] && matrix[i][j] == 1) {
					sizeOfArr = 1;
					cntOfArr += arrAreaOfCnt(i, j, sizeOfMatrix, matrix);
					sizeOfArrList.add(sizeOfArr);					
				}
			}
		}
		
		sizeOfArrList.sort(null);
		OutputData(cntOfArr, sizeOfArrList);
	}
	
	private static void OutputData(int cntOfArr, List<Integer> sizeOfArrList) {
		System.out.println(cntOfArr);
		for(int i = 0; i < sizeOfArrList.size(); i++) {
			if(i != sizeOfArrList.size()-1) {
				System.out.print(sizeOfArrList.get(i) + " ");
			}else {
				System.out.print(sizeOfArrList.get(i));
			}
		}
	}

	private static class InputData {
		int sizeOfMatrix;
		int[][] matrix;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
			for (int i = 0; i < inputData.sizeOfMatrix; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.sizeOfMatrix; j++) {
					inputData.matrix[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.sizeOfMatrix, inputData.matrix);
	}
}


