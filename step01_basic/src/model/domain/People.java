/*암기
 * 생성자
 * 1. 기본 생성자
 * 	()에 parameter가 없는 생성자 의미
 * 
 * 2. 생성자
 * 	parameter에 값 받고 받은 데이터로 멤버 변수 초기화 로직으로 주로 개발
 *  parameter값으로 대입되는 값으로 멤버변수들 토기화 하면서 객체 생성
 *  
 * 3. 기본생성자 또는 생성자 미 개발 시 컴파일 시점에 기본 생성자 자동 생성
 */




package model.domain;

public class People {
	private String name;
	private int age;

	public People() {
	}
	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
