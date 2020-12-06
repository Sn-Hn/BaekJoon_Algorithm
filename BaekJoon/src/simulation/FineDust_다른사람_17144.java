package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FineDust_다른사람_17144 {
	static int r, c, t;
	static ArrayList<Integer> fresher;	// x좌표는 무조건 1이므로, y좌표 값만 담아서 sort 진행하면 [0]이 up, [1]이 down.
	static int[][] map, movedMap;	// 기존 미세먼지 담은 맵, 미세먼지 분산 후 증가량 담은 맵
	// 이동 방향은  왼 - 아래 - 오른 - 위  순서
	static int[] moveX = { 1, 0, -1, 0 };
	static int[] moveY = { 0, 1, 0, -1 };
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		t = Integer.valueOf(st.nextToken());
		map = new int[r][c];
		movedMap = new int[r][c];
		fresher = new ArrayList<Integer>();
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				int dust = Integer.valueOf(st.nextToken());
				map[i][j] = dust;
				
				// 공기 청정기
				if(dust == -1) {
					fresher.add(i);
				}
			}
		}
		
		// 공기 청정기 UP, DOWN 확정
		Collections.sort(fresher);
		
		// 1초 동안 일 진행
		int nowTime = 0;
		while(nowTime < t) {
			spread();
			setDustAfterSpread();
			moveWind(true);		// UP
			moveWind(false);	// DOWN
			
			nowTime++;
		}
		
		// 미세먼지 총 양 계산
		int allDust = 0;
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				if(map[y][x] > 0) {
					allDust += map[y][x];
				}
			}
		}
		
		System.out.println(allDust);
	}
	
	// 미세먼지 확산
	static void spread() {
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				if(map[y][x] >= 5) {	// 5 미만의 수는 5로 나누면 0이라서 의미 없다.
					int movedDust = map[y][x] / 5;
					int count = 0;
					for(int i = 0; i < moveX.length; i++) {
						int nextX = x + moveX[i];
						int nextY = y + moveY[i];
						
						// 벽에 닿으면
						if(nextY < 0 || nextY >= r || nextX < 0 || nextX >= c) {
							continue;
						}
						// 공기 청정기
						if(map[nextY][nextX] == -1) {
							continue;
						}
						
						movedMap[nextY][nextX] += movedDust;
						count++;
					}
					
					map[y][x] = map[y][x] - (movedDust * count);	// 계산 제대로 되는지 확인
				}
			}
		}
	}
	
	// 확산된 미세먼지 맵에 값 추가하기
	static void setDustAfterSpread() {
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				if(movedMap[y][x] > 0) {
					map[y][x] += movedMap[y][x];
					movedMap[y][x] = 0;
				}
			}
		}	
	}
	
	// 공기 청정기 바람 이동
	// @param : isUp : True - UP 청정기,   False - DOWN 청정기
	static void moveWind(boolean isUp) {
		int startX = 1;
		int startY = isUp ? fresher.get(0) : fresher.get(1);
		int endY = startY;
		int direction = 0;
		
		while(startX != 0 || startY != endY) {
			int nextX = startX + moveX[direction];
			int nextY = startY + moveY[direction];
			
			// 벽에 닿으면
			if(nextY < 0 || nextY >= r || nextX < 0 || nextX >= c) {
				if(isUp) {
					direction = direction == 0 ? 3 : direction - 1;
				}
				else {
					direction++;
				}
				continue;
			}
			
			// 바람 이동
			movedMap[nextY][nextX] = map[startY][startX];
			map[startY][startX] = movedMap[startY][startX];
			movedMap[startY][startX] = 0;
			
			startX = nextX;
			startY = nextY;
		}
		
		movedMap[startY][startX] = 0;
	}
}
