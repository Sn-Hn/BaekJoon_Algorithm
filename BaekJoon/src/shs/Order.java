package shs;

import java.util.Scanner;

/*
2
B2(RG)
3(R2(GB))

BRGRG
RGBGBRGBGBRGBGB

3
3(BR2(R))
B(RGB(RG))
1B2R3G

BRRRBRRRBRRR
BRBGBBBRBBBG
BRRGGG
*/

class Order {
	private static String fistLastString(String order, String firstString, String lastString) {
		String detailOrder = order;
		
		
		if(!firstString.equals("")) {
			detailOrder = firstString + detailOrder;
		}
		
		if(!lastString.equals("")) {
			detailOrder += lastString;
		}
		
		return detailOrder;
	}
	
	private static String detailOrder(String order, String firstString, String lastString, char frontCharacter) {
		String detailOrder = "";
		int numberOfString = order.length();
		int startParenthesis = order.indexOf('(');
		int endParenthesis = order.lastIndexOf(')');
		boolean flag = true;
		
		if(numberOfString > endParenthesis + 1) {
			lastString = order.substring(endParenthesis+1, numberOfString-1);
		}
		if(startParenthesis > 1) {
			firstString = order.substring(0, startParenthesis-1);
		}
//		System.out.println("fr : " + firstString);
		
		if(startParenthesis != -1) {
			
			detailOrder = order.substring(startParenthesis+1, endParenthesis);
			frontCharacter = order.charAt(order.indexOf('(')-1);
			detailOrder = detailOrder(detailOrder, firstString, lastString, frontCharacter);
			System.out.println("order : " + order);
			System.out.println("front : " + frontCharacter);
			System.out.println("first : " + firstString);
			System.out.println("detail : " + detailOrder);
			
//			if(frontCharacter != ' ') {
//				if(frontCharacter == 48) {
//					detailOrder = "";
//				}else if(frontCharacter > 48 && frontCharacter <= 57) {
//					for(int i = 0; i < Character.getNumericValue(frontCharacter)-1; i++) {
//						detailOrder += order;
//					}
//				}else {
//					for(int i = 0; i < numberOfString; i++) {
//						detailOrder += Character.toString(frontCharacter) + Character.toString(order.charAt(i));
//					}
//				}
//				
//			}
//			
//			return detailOrder;
			
		}
		
		if(startParenthesis == -1){
			for(int i = 0; i < numberOfString; i++) {
				if(order.charAt(i) == 48) {
					i+=1;
					continue;
				}else 
				if(order.charAt(i) > 48 && order.charAt(i) <= 57 && numberOfString-1 > i) {
					int numberOfIndex = Character.getNumericValue(order.charAt(i));
					char charOfIndex = order.charAt(i+1);
					for(int j = 0; j < numberOfIndex-1; j++) {
						detailOrder += charOfIndex;						
					}
				}else {
					detailOrder += order.charAt(i);
				}
			}
			if(frontCharacter != ' ') {
				if(frontCharacter == 48) {
					detailOrder = "";
				}else if(frontCharacter > 48 && frontCharacter <= 57) {
					for(int i = 0; i < Character.getNumericValue(frontCharacter)-1; i++) {
						detailOrder += order;
					}
				}else {
					for(int i = 0; i < numberOfString; i++) {
						detailOrder += Character.toString(frontCharacter) + Character.toString(order.charAt(i));
					}
				}
				
			}
			 
			return detailOrder;
		}
		
		detailOrder = fistLastString(detailOrder, firstString, lastString);
		System.out.println(frontCharacter);
		detailOrder = detailOrder(detailOrder, firstString, lastString, frontCharacter);
		
		return detailOrder;
	}
	
	private static void solution(int numOfOrder, String[] orderArr) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		for(int i = 0; i < numOfOrder; i++) {
			System.out.println("정답 : " + detailOrder(orderArr[i], "", "", ' '));
//			detailOrder(orderArr[i], "", ' ');
		}
	}

	private static class InputData {
		int numOfOrder;
		String[] orderArr;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.orderArr = new String[inputData.numOfOrder];
			for (int i = 0; i < inputData.numOfOrder; i++) {
				inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfOrder, inputData.orderArr);
	}
}