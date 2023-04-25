package step01.syntax;

import model.domain.Customer;

public class Step05CustomerTest {
	
	public String insertCustomer(String grade, String name, int age){
		Customer c = new Customer();
		c.setGrade(grade);
		c.setName(name);
		c.setAge(age);
		
		return "가입 성공";
	}
	//사용자 정의 타입으로 pameter 구성해 보기
	//객체 타입 사용 가능
	public String insertCustomer(Customer cust){
		//DB에 실제 저장 성공으로 가정
		return "가입 성공";
	}
	

	public static void main(String[] args) {
		//클래스가 보유한 메소드 호출을 위한 객체 생성
		Step05CustomerTest st = new Step05CustomerTest();
		st.insertCustomer("vvip", "유재석", 40);
//		Customer c = new Customer(); 
//		System.out.println(c); 
//		
//		//c.age = -10;
//		//System.out.println(c.age);
//		
//		//method로 값 수정
//		c.setAge(-20);

	}

}
