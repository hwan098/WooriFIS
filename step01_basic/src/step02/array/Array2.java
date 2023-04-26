package step02.array;

public class Array2 {

	public static void main(String[] args) {
		int[] i = new int[3];
		i[0] = 100;
		i[1] = 200;
		i[2] = 300;
		
		//for
		for(int index=0; index < i.length; index++) {
			System.out.println(i[index]);
		}
		
		//while
		int index = 0;
		while(index < i.length) {
			System.out.println(i[index]);
			index++;
		}
		
		//do-while
		int index2 = 0;
		do {
			System.out.println(i[index2]);
			index2++;
		}while(index2 < i.length);
		
			
	}

}
