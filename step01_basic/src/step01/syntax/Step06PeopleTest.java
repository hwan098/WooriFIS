package step01.syntax;

//외부 package 클래스 사용을 위한 추가
import model.domain.People;

public class Step06PeopleTest {

	People getSetPeople(People p) {//ox
		p.setName("동엽");
		return p;
	}
	People getSetPeople2(People p) {//ox
		p.setName("동엽2");
		return p;
	}
	
	public static void main(String[] args) {
		Step06PeopleTest st = new Step06PeopleTest();
		
		People p1 = new People();//ox
		System.out.println(1 + " " + p1.getName() + " " + p1.getAge());
		p1.setName("재석");
		p1.setAge(10);
		
		People p3 = st.getSetPeople(p1);//ox
		p3.setName("임영웅");
		People p4 = st.getSetPeople2(p3);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p1);
		
		
		System.out.println(5 + " " + p4.getName());
		
		System.out.println(2 + " " + p1.getName() + " " + p1.getAge());//2 임영웅 10
		System.out.println(3 + " " + p3.getName() + " " + p3.getAge());//3 임영웅 10
		System.out.println(4 + " " + p1.getName() + " " + p1.getAge());//4 임영웅 10
		
	}

}