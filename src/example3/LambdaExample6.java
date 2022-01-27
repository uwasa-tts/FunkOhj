package example3;

@FunctionalInterface
interface MathOperation {
	public int operation(int a, int b);
}


public class LambdaExample6 {

	   public static void main(String args[]) {
				
		      // parametrit tyyppimäärityksin
		      MathOperation addition = (int a, int b) -> a + b;
				
		      // parametrit ilman tyyppimääritystä
		      MathOperation subtraction = (a, b) -> a - b;
				
		      // paluuarvo aaltosulkeissa - return ei pakollinen
		      MathOperation multiplication = (int a, int b) -> { return a * b; };
				
		      // ilman returnia ja aaltosulkeita
		      MathOperation division = (int a, int b) -> a / b;
			
		      System.out.println("Tulostus 1: Kutsuen rajapinnan metodia");
		      System.out.println("10 + 5 = " + addition.operation(10, 5));
		      System.out.println("10 - 5 = " + subtraction.operation(10, 5));
		      System.out.println("10 x 5 = " + multiplication.operation(10, 5));
		      System.out.println("10 / 5 = " + division.operation(10, 5));

		      System.out.println("Tulostus 2: Kutsutaan operate-metodia välittäen sille rajapinta");
		      System.out.println("10 + 5 = " + operate(10, 5, addition));
		      System.out.println("10 - 5 = " + operate(10, 5, subtraction));
		      System.out.println("10 x 5 = " + operate(10, 5, multiplication));
		      System.out.println("10 / 5 = " + operate(10, 5, division));
		   }
			
			
		   private static int operate(int a, int b, MathOperation mathOperation) {
		      return mathOperation.operation(a, b);
		   }

}
