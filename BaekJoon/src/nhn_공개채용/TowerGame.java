package nhn_공개채용;

import java.util.Scanner;

/*

17
5
B D I M P
11
3 -4 5 6 -7 -8 10 -12 -15 -20 23

*/

class TowerGame {
	private static char it;
	private static int indexOfIt;
	private static int[] cntOfIt;
	
	private static char[] findIt(char[] players, int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickplayers,
			int numOfMovesPerGame) {
		
		boolean isQuickPlayer = false;
		if(indexOfIt + numOfMovesPerGame >= 0) {
			System.out.println(numOfAllPlayers);
			indexOfIt = (indexOfIt + numOfMovesPerGame) % (numOfAllPlayers - 1);
		}else {
			indexOfIt = numOfAllPlayers - (Math.abs(indexOfIt + numOfMovesPerGame) % (numOfAllPlayers - 1))-1;
		}
		
		for(int i = 0; i < numOfQuickPlayers; i++) {
			if(players[indexOfIt] != namesOfQuickplayers[i]) {
				isQuickPlayer = true;
			}else {
				isQuickPlayer = false;
				cntOfIt[it-65]++;
				break;
			}
		}
		if(isQuickPlayer) {
			char changeIt = it; 
			it = players[indexOfIt];
			players[indexOfIt] = changeIt;
			cntOfIt[it-65]++;
			System.out.println("it : " + it);
		}
		
		return players;
		
	}

	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		it = 'A';
		indexOfIt = 0;
		char[] players = new char[numOfAllPlayers-1];
		cntOfIt = new int[numOfAllPlayers];
		cntOfIt[0]++;
		for(int i = 0; i < numOfAllPlayers-1; i++) {
			players[i] = (char) (66 + i); 
		}
		
		for(int i = 0; i < numOfGames; i++) {
			players = findIt(players, numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfMovesPerGame[i]);
		}
		OutputData(players);
		
	}
	
	private static void OutputData(char[] players) {
		for(int i = 0; i < players.length; i++) {
			System.out.println(players[i] + " " + cntOfIt[players[i]-65]);
		}
		System.out.println(it + " " + cntOfIt[it-65]);
		
		
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
				inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}