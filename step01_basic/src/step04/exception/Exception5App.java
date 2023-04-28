/* 응용
 * 1. id과 pw 값 "fisa"/11 만 유효하다 가정
 * 2. 개발에 대한 경우의 수
 * 	경우의 수 1 : boolean
 *  경우의 수 2 : 무효한 경우 예외 발생해서 예외 처리 가능
 *  	- 사용자 정의로 상황에 맞게 예외를 직접 발생 및 처리하겠다는 의미
 *  
 *  3. Thread의 
 *  	public static void sleep(초) throws InterruptedException{
 *  	  프로그램을 잠시 중지 시도시 일시 중지 가능성 : 정상실행
 *  		"			   싫다 다 계속 실행 가능성 : 비정상실행
 *  		비정상실행 야기되는 다음 코드가 실행
 *  			throw new InterruptedException();  
 *  	}
 * 
 */
package step04.exception;

public class Exception5App {
	//id/pw 검증 메소드라 가정
	//정상인 경우 true값 반환/무효할 경우 예외 발생
	/* == : 기본타입인 경우 값비교, 참조타입 비교시에는 주소값 비교
	 * public boolean equals(Object v){
	 * 	 java.lang.Object의 메소드 - 주소값 비교
	 *   String, Integer 등등의 이미 다수의 API에선 이미 동일한 타입의 내용값들 비교로 재정의
	 * }
	*/
	//1
	public static boolean loingCheck(String id, int pw) throws Exception{
		if(id.equals("fisa") && pw == 11) {//유효한 id pw
			return true;			
		}else { //무효한 경우
			throw new Exception("무효한 id/pw입니다.");
		}
//		return false; 100% 실행 불가인 라인 따라서 문법 오류
	}
	
	//2
	public static boolean loingCheck2(String id, int pw) throws Exception{
		boolean result = false;
		
		if(id.equals("fisa") && pw == 11) {//유효한 id pw
			result = true;			
		}else { 
			throw new Exception("무효한 id/pw입니다.");
		}
		return result;
	}
	
	//3
	public static boolean loingCheck3(String id, int pw) throws Exception{
		if( !id.equals("fisa") || !(pw == 11)) {//유효한 id pw
			throw new Exception("무효한 id/pw입니다.");
		}
		return true;
	}
	
	//4
	public static boolean loingCheck4(String id, int pw) throws Exception{
		if(id.equals("fisa") && pw == 11) {//유효한 id pw
			return true;
		}
		throw new Exception("무효한 id/pw입니다.");
	}
	
	
	
	public static void main(String[] args) {
		try{
			boolean r = loingCheck("fisa2", 11);
			System.out.println(r);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 그 이상의 로직들은 예외가 발생되어도 중단 없이 실행 유지됨
	}

}