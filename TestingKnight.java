import java.util.Arrays;

public class TestingKnight {
	public static void main(String[] args) {
		Square t = new Square(4, 4);
		Knight test = new Knight(t, 5, 5);
		// test.solve();
		
//		System.out.println(test.solve().length);
		for (int k=0;k<test.solve().length;k++) {
			System.out.println(test.solve()[k]);
		}
//		System.out.println(test.solve().length);
//		test.solve();
		System.out.println(Arrays.toString(test.solve()));
//		System.out.println(test.solve().length);
	}	
}
