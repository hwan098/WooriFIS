package step02.array;

import model.domain.Customer;

public class Array3Object {

	public static void main(String[] args) {
		String[] sa = {"fisa", "상암"};
		for(String v : sa) {
			System.out.println(v);
		}
		//모든 객체 생성은 new가 필수이므로 선언해준다. 
		Customer [] c = {new Customer("vvip", "재석", 50), 
						 new Customer("vip", "동엽", 30)};
		
		for(Customer v : c) {
			System.out.println(v.getName());
		}
	}
	
}
