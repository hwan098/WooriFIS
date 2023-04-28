/*
 * 학습내용
 * 1. APi활용해서 예외 처리 문법 익숙해지기
 * 	- 실행 중 잠시 멈추는 메소드(API)호출
 */

package step04.exception;

public class Exception3 {

	public static void main(String[] args) {
		System.out.println(1);
		
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace(); //예외 정보를 콘솔창에 출력
		}
		
		System.out.println(2);
	}

}
