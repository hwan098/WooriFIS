/*
 * 암기
 * java.lang.package
 */


package step_03.api;

public class ApiTest {

	public static void main(String[] args) {
		
		/* 1. 문자열의 길이를 요청, int로 반환
		 * 2. 문자열에서 F 한글자(char) 사용
		 * 3. 1기 문자열을 첫스타트 문자열로 반환
		 */
		String data = "FISA 1기 입성을 축하합니다.";
		System.out.println(data.length());
		char c = data.charAt(5);
		System.out.println(c);		
		
		// 1기 문자열을 첫스타트 문자열로 변환
		String v = data.replace("1기", "첫스타트");
		System.out.println(v);
		System.out.println(data);
		System.out.println(data.replace("1기", "첫스타트").charAt(0));
	}

}
