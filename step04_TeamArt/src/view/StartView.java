package view;

import controller.Controller;

public class StartView {

	public static void main(String[] args) {
		
		/* 검색만 요청 --> 2값 주면 검색요청
		 * 클래스 내부의 메소드 호출 개발 코드 프로세스
		 * 객체생성 --> 생성된 객체 참조 변수로 메소드 또는 변수 호출
		 */
		Controller c = new Controller();
		c.reqRes(2);
	
	}

}
 