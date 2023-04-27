package model;

import model.domain.Food;

public class Restaurant {

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
