/* 학습내용
 * 1. static
 * 	1. 변수 : 생성되는 모든 객체가 공유, 객체 생성없이 호출
 *  2. 메소드 : 객체 생성없이 호출 가능한 문법으로 사용
 *  3. static{} 
 *  	: 공유자원을 단 한번 bytecode를 로딩할때 자동 실행되는 특이한 블록
 *  	: main() 보다 유일하게 먼저 실행
 *  	: 왜? byte code가 메모리에 로딩시에 한줄한줄 로딩되면서 static{} 존재할 경우 로딩하면서 실행
 *  	이름이 없는 블록  따라서 재호출 방법 없음 
 *  	: DB연동시 db접속을 위한 driver 로딩 주로 사용
 */
package step04.exception;

class A{
	static {
		System.out.println("A class의 byte code가 메모리에 로딩됨을 확인하는 문장");	
	}
}

public class Exception2 {

	public static void main(String[] args) {
		//java.lang.Class : public static Class forName(String name){메모리에 로딩}
		//parameter값으로 적용시 package명 포함
		
		/* parameter값으로 존재하는 클래스명 적용시	- 정상 실행
		 * "			 미 존재하는 클래스명 적용시 - 비정상 실행
		 * - ClassNotFoundException 으로 관리
		 * - 처리 코드가 없을 경우 문법 자체가 즉 컴파일 오류
		 * ClassNotFoundException 클래스는 java.lang.RuntimeException 와 무관
		 * 결론 :  RuntimeException과 무관한 모든 예외 상황은 예외 처리 문장인
		 * 		try~catch 필수 
		 */
		try {//서비스 로직 단 예외 발생가능성 있는 코드들 블록
			Class.forName("step04.exception.A---");
			System.out.println(1);
		
		}catch(ClassNotFoundException e) {//예외 발생시 처리하는 블록
			System.out.println("문제 발생시 처리하는 영역");
		}
		
		//예외 발생이 된다 하더라도 실행 유지
		System.out.println(3);//늘 실.행.된.다. 서버 관점에선 서버 중지없이 실행된다~~~
	}

}