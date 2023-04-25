package model;
//ctrl+shift+o 자동으로 필요한 import 문장 완성
import model.domain.Customer;

public class Model {
	//다수의 로직이 존재한다고 가정
	
	//DB로부터 고객 정보 검색해서 한명의 고객 정보 반환하는 핵심 기능
	/*
	 * 데이터베이스로부터 검색 -> 검색된 결과값으로 Customer객체 생성 -> 반환
	 */
	public Customer getCustomer() {
		
		return new Customer("vvip", "재석", 10);
	}
}
