package example3;

public class LambdaExample2 {

	public static void main(String[] args) {

		MyFunction myFunction = () -> System.out.println("Hello world!");
		
		myFunction.apply();
	}

}
