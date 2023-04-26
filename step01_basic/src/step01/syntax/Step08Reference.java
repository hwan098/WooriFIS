/* 학습내용
 * 1. 객체 참조 관계 이해하기
 * 2. . : dot 연산자(접근 연산자)
 * 3. 객체 생성 문법
 * 	- String : "" / 배열 : {값1, 값2,..} / new 생성자([..])
 *  - 생성은 메모리에 실제 사용 가능하게 구성
 *  - 생성자 호출되었다는 객체 만들었다, 멤버 변수 메모리 생성했다!!!
 */
package step01.syntax;

class A{
	String aVar = "A의 변수";
	A(){
		//aVar 변수 객체 생성
		System.out.println("A 생성자");
	}//A 객체 생성 
}
class B{
	String bVar = "B의 변수";
	A a = new A();
	B(){
		
		System.out.println("B 생성자");
	}// "B의 변수"객체 생성 -> "A의 변수" 문자열 객체 생성 -> A객체 생성 -> B객체 생성 
}
class C{
	String cVar = "C의 변수";
	B b = new B()   ;
	C(){
		//보유한 모든 멤버 변수들을 완벽하게 생성
		System.out.println("C 생성자");
	}//"C의 변수" 문자열 객체 생성 ->  "B의 변수"객체 생성 -> "A의 변수" 문자열 객체 생성 -> A객체 생성 -> B객체 생성 ->  C 객체 생성
}
public class Step08Reference {
	public static void main(String[] args) {
		/* 1. 실행전에 출력 순서에 대해 고민후 실행
		 * 2. 절대 더이상의 객체 생성 금지!!! 단 이미 만들어 놓은 C객체를 참조하는 c변수로 
		 * 	  A객체의 aVar 변수값 출력 */
		C c = new C();  
		System.out.println(c.b.a.aVar);
	}

}