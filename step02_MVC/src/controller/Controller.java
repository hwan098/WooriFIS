package controller;

import model.Model;
import model.domain.Customer;
import view.EndView;

public class Controller {
	/*
	 * int 값 받아서 1이면 저장, 2면 검색
	 * 검색인 경우 EndView에게 데이터를 제공하면서 출력 지시
	 */
	 public void reqRes(int reqNo) {
		 // == : 동등비교 연산자
		 if(reqNo == 1) { //reqNo가 1인지 비교, 같으면 true
			 
		 }else if(reqNo == 2) { //검색요청으로 간주
			 /*
			  * Model에게 고객 정보 검색 요청
			  * 받은 정보를 화면에 출력(EndView에서 출력 메소드가 담당함)
			  */
			 Model m = new Model(); 
			 Customer c = m.getCustomer(); //고객 정보 획득	
			 
			 EndView e = new EndView();
			 e.printCustomer(c);
		 }else { //1도 2도 아닌 경우
			 
		 }
	 }
}

