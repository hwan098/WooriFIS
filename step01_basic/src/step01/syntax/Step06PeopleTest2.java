package step01.syntax;

import model.domain.People;

public class Step06PeopleTest2 {

	People getSetPeople(People p) {//ox
		p.setName("동엽");
		return p;
	}

	public static void main(String[] args) {
		Step06PeopleTest2 st = new Step06PeopleTest2();
		//name 멤버 변수값은 총 몇 번 변경 : null--> 동엽 --> 유재석
		People p1 = new People();//ox
		
		st.getSetPeople(p1).setName("유재석");
		System.out.println(p1.getName());
	}

}