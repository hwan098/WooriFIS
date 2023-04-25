package view;

import model.domain.Customer;

public class EndView {
	//검색된 정보를 화면에 출력해주는 기능
	//브라우저로 실행되는 코드라 간주
	/*
	 * Customer 데이터 받고 등급, 이름, 나이 출력
	 */
	public void printCustomer(Customer c) {
		System.out.println(c.getName());
	}
}
