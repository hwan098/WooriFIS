package step01.syntax;

public class Step07Loop {
	//객체 생성없이 메소드 호출 방법 적용 --> static
	//for	
	static void forLoop() {
		//for(초기치; 조건식; 증감치){조건이 true인 경우 실행}
		for(int i=1; i < 3; i++) {
			System.out.println(i);
		}
		
	}	
	
	//while
	static void whileLoop() {
		//
		int i = 0;
		while(i < 3) {
			System.out.println(i);
			i++;
		}
		
	}	
	//do-while
	static void doWhileLoop() {
		int i = 1;
		do {
			System.out.println(i);
			i++;
		}while(i < 6);
		
	}	
	public static void main(String[] args) {
		forLoop();
		System.out.println("-------");
		whileLoop();
		System.out.println("-------");
		doWhileLoop();
		
	}

}
