package example5;

public class MethodReferenceExample1 {

	public static void main(String[] args) {

		// olion metodiin viittaaminen
		// lambdalla
		Finder finder = (s1, s2) -> s1.indexOf(s2);
		System.out.println(finder.find("ohjelmointi", "moi"));
		
		// metodiviittauksella
		Finder finder2 = String::indexOf;
		System.out.println(finder2.find("testisana", "ti"));
	}

}
