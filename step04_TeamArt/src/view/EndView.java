package view;

import model.domain.Food;

public class EndView {
	//검색된 정보를 화면에 출력해주는 기능
	//브라우저로 실행되는 코드라 간주
	/*
	 * Customer 데이터 받고 등급, 이름, 나이 출력
	 */
	public static void printFood(Food f) {
		System.out.println("메뉴 : " + f.getName());
		System.out.println("가격 : " + f.getPrice());
		System.out.println("평점 : " + f.getPoint());
	}
	public static void printFoods(Food[] food) {
		System.out.println("--메뉴--");
		for(int i=0; i < food.length; i++) {
			System.out.println("  " + food[i].getName());
			System.out.println("가격 : " + food[i].getPrice());
			System.out.println("평점 : " + food[i].getPoint());
			System.out.println("---------");
		}
		
	}
}
