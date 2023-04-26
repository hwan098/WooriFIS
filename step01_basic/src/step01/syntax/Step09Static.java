/*
 * Static 키워드 학습
 * 필요에 따라 적용하는 옵션
 * 위치
 *  - 변수, 메소드, static{}
 * 특징 : 모든 변수와 메소드는 보유하고 있는 클래스 기반의 객체 생성 후에 창조 변수로 호출
 * 단, 예외사항 static으로 선언된 변수와 메소드는 Class만으로 호출
 * 	변수
 * 	- 생성된 모든 객체가 공유하는 메모리
 * 	메모리
 * 	- 객체생성 없이 호출 가능만 부여
 */

package step01.syntax;

public class Step09Static {
	static int no1;	//객체 생성시점과 무관하게 바이트코드가 로딩 시 자동으로 메모리에 생성!!
	int no2;	//객체 생성후에만 사요가능한 인스턴스 변수
	
	Step09Static(){
		no1++;	// 0->1->2
		no2++;	//새로 만들고 0->1
	}
	public static void main(String[] args) {
		System.out.println(no1);
		System.out.println(Step09Static.no1);
		
		Step09Static s = new Step09Static();
		System.out.println(s.no2); 
		
		//두 개의 숫자 제공 후 min값 구하는 메소드 호출 및 결과 출력
		System.out.println(Math.min(3, 7));
	}

}
