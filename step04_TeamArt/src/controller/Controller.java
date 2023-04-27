package controller;

import model.Restaurant;
import model.domain.Food;
import view.EndView;

public class Controller {

	 public void reqRes(int reqNo) {
		 // == : 동등비교 연산자
		 if(reqNo == 1) { //reqNo가 1인지 비교, 같으면 true
			 
		 }else if(reqNo == 2) { //검색요청으로 간주
			 /*
			  * restaurant에게 음식 정보 검색 요청
			  * 받은 정보를 화면에 출력(EndView에서 출력 메소드가 담당함)
			  */
			 //Restaurant r = new Restaurant(); 
			 Food f = Restaurant.getFood(); //음식 정보 획득	
			 Food[] food = Restaurant.getFoods();
			 
			 //EndView e = new EndView();
			 EndView.printFood(f);
			 EndView.printFoods(food);
		 }else { //1도 2도 아닌 경우
			 
		 }
	 }
}

