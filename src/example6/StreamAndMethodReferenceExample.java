package example6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAndMethodReferenceExample {

	public static void main(String[] args) {

		List<String> colors = new ArrayList<>();
		
		colors.add("valkoinen");
		colors.add("sininen");
		colors.add("vaaleanpunainen");
		colors.add("violetti");
		colors.add("musta");
		colors.add("vihreä");
		colors.add("oranssi"); 
		colors.add("okra");
		colors.add("keltainen");
		
		
		// lambdalla
		System.out.println("Aakkostus ja tulostus lambdalla");
		colors.stream()
		  .sorted((a, b) -> a.compareTo(b))
		  .forEach(e -> System.out.println(e));
		// metodiviittauksella
		System.out.println("\nAakkostus ja tulostus metodiviittauksella");
		colors.stream()
		  .sorted(String::compareTo)
		  .forEach(System.out::println);
		
		System.out.println("\nIsoilla kirjaimilla metodiviittauksella");
		colors.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);

		// Maksimiarvo listasta metodiviittauksella
		List<Integer> integers = Arrays.asList(1,12,433,5);
        
		Optional<Integer> max = integers.stream().reduce( Math::max ); 
		 
		max.ifPresent( System.out::println ); 
			
	}

}
