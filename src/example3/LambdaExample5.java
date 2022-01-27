package example3;

interface MulipleParamaterInterface {

	  //metodi kahdella parametrilla ja paluuarvona int 
	    public int sum(int a, int b);
}

public class LambdaExample5 {

	public static void main(String[] args) {
		
		MyFunction3 myFunction = (text, text2) -> System.out.println(text + "ja " + text2);
		myFunction.apply("Heippa!", "Moikka!");
		
		
		MulipleParamaterInterface add = (a, b) -> a + b;
        System.out.println("5 + 4 = " + add.sum(5, 4));
	}

}
