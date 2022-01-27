package example3;

@FunctionalInterface
interface SingleParameterInterface {
	
	//Metodi yhdellä parametrilla ja paluuarvo int 
	public int CountSquare(int s);
}

public class LambdaExample4 {

	public static void main(String[] args) {

		MyFunction2 myFunction = (text) -> System.out.println(text);
		myFunction.apply("Heippa!");
		

		SingleParameterInterface square = (num) -> num*num;
        System.out.println("5*5 = " + square.CountSquare(5));
	 
	}
}
