package example3;

@FunctionalInterface
interface NoParameterInterface {

  // Metodi ilman parametreja ja paluuarvona String
	public String greetings();
}

@FunctionalInterface
interface PiValueInterface{
	// Metodi ilman parametreja ja paluuarvona double
    public double getPiValue();
}


public class LambdaExample3 {

	public static void main(String[] args) {
		
		NoParameterInterface message = () -> {
    		return "Hello World viesti ilman parametreja";
    	};
        System.out.println( message.greetings( ));
  
        
        PiValueInterface piValue = () -> Math.PI;
        System.out.println("Piin arvo = " + piValue.getPiValue());
	}

}
