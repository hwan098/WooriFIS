package view;

import model.domain.Food;

public class EndView {

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
