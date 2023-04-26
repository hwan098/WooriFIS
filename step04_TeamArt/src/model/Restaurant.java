package model;
//ctrl+shift+o 자동으로 필요한 import 문장 완성
import model.domain.Food;

public class Restaurant {
	//다수의 로직이 존재한다고 가정
	
	//DB로부터 고객 정보 검색해서 한명의 고객 정보 반환하는 핵심 기능
	/*
	 * 데이터베이스로부터 검색 -> 검색된 결과값으로 Customer객체 생성 -> 반환
	 */
	public static Food  getFood() {
		return new Food("라면", 3000, 4.5);
	}
	public static Food[] getFoods() {
		Food[] food = {
				new Food("라면", 3000, 4.5),
				new Food("김밥", 2000, 4.0),
				new Food("비빔밥", 4500, 4.7),
				new Food("김치볶음밥", 8000, 4.1),
				new Food("칼국수", 6000, 3.8)
		};
		return food;
	}
}
