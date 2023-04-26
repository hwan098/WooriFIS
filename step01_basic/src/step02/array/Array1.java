/* 학습내용

 * 1. 하나의 변수의 다수의 데이터 저장 가능한 자료구조
 * 2. 다수의 데이터 구분 - 고유한 index(순번)
 * 3. index 시작은 0부터
 * 	- 10개라면  index 0~9까지
 * 4. 배열만의 특징
 * 	1. 한번 생성한 배열의 크기 변경은 불가
 * 	2. index로 데이터 구분
 *  3. length 속성 자동 생성 - 배열의 크기값 보유한 속성  
 *  
 *
 *5. 배열 생성 및 활용 문법
 *	1. new 생성
 *		타입 [] 변수 = new 타입[크기];
 *		변수[index] = 값;
 *
 *  2. new 키워드 없이 배열 객체 생성
 *  	- 데이터로만 생성
 *	  	타입 [] 변수 = {값1, 값2, ..};
 *  
 *  참고 : 객체 생성 문법
 *  	new 생성자([..])
 *  new 연산자 없이 데이터 표현만으로 객체화 되는 타입
 *  	- "" : String 객체 생성
 *  	- {값1, 값2, ...} : 배열 객체 생성
 *  
 *  메모리에서 객체들 저장 영역 : heap
 *  	1. gc가 메모리 관리
 *  	2. 멤버 변수들은 객체에 포함되어 생성, 자동 초기화
 *  	3. 배열도 객체 따라서 heap에 저장, 자동 초기화
 * 
 */
package step02.array;

public class Array1 {

	public static void main(String[] args) {
		// int 데이터 3개로 배열 생성 및 활용
		// new로 생성하는 문법
		int[] i = new int [3]; //3개 메모리 생성
		System.out.println(i.length + " " + i[0]);
		
		i[0] = 100; 
		i[1] = 200; 
		i[2] = 300; 
		System.out.println(i.length + " " + i[0]);
		
		//new 없이 생성하는 문법
		int [] ii = {10, 20, 30};
		System.out.println(ii.length + " " + ii[0]);
	}

}
