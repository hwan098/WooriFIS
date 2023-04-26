package step02.array;

public class Array2 {

	public static void main(String[] args) {
		int[] i = new int[3];
		i[0] = 100;
		i[1] = 200;
		i[2] = 300;
		
		//for
		System.out.println("--for--");
		for(int index=0; index < i.length; index++) {
			System.out.println(i[index]);
		}
		System.out.println("--while--");
		//while
		int index = 0;
		while(index < i.length) {
			System.out.println(i[index]);
			index++;
		}
		System.out.println("--do-while--");
		//do-while
		int index2 = 0;
		do {
			System.out.println(i[index2]);
			index2++;
		}while(index2 < i.length);
		
		/*
		 * forEach
		 * 배열과 리스트에 사용되는 반복문
		 * for(단일데이터 : 반복할 데이터){
		 * 		처리로직
		 * }	
		 */
		System.out.println("--forEach--");
		for(int v : i) {
			System.out.println(v);
		}
	}

}
