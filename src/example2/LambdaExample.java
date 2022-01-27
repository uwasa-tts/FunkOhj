package example2;

import java.util.Comparator;

public class LambdaExample {

	public static void main(String[] args) {

		/*
		 * CompareTo-metodi palauttaa int-tyyppisen arvon seuraavasti:
		 * 0, jos oliot ovat yhtäsuuret
		 * < 0, jos ensimmäinen olio on pienempi (tpinen suurempi) 
		 * > 0, jos ensimmäinen olio on suurempi (toinen pienempi)
		 */ 
		
		// Kahden olion vertailu entiseen tapaan Comparator-rajapinnan avulla
		Comparator<String> stringComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		
		int comparison = stringComparator.compare("Heippa", "Moikka");
		System.out.println(comparison);

		
		// Sama vertailu lambda-lausekkeella
		Comparator<String> stringComparatorLambda = 
				(String o1, String o2) -> o1.compareTo(o2);
				
		int lambdaComparison = stringComparatorLambda.compare("Heippa", "Moikka");
		System.out.println(lambdaComparison);
		
		// Integer-vertailu
		Comparator<Integer> intComparatorLambda = 
				(Integer o1, Integer o2) -> o1.compareTo(o2);
				
		int lambdaComparison2 = intComparatorLambda.compare(6 , 6);
		System.out.println(lambdaComparison2);
		
		// Auto-vertailu
		Auto auto1 = new Auto("Volvo", "RBC-123", 2015);
		Auto auto2 = new Auto("Audi", "CFG-365", 2017);
		Comparator<Auto> autoComparatorLambda = 
				(Auto o1, Auto o2) -> o1.getMerkki().compareTo(o2.getMerkki());
				
		int lambdaComparison3 = autoComparatorLambda.compare(auto1, auto2);
		System.out.println(lambdaComparison3);
	}

	
	
}
