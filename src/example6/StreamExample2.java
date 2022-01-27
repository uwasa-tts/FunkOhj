package example6;

import java.util.stream.*;
import java.util.*;  

public class StreamExample2 {  

        public static void main(String[] args){  

			List<String> varit = new ArrayList<>();
				
			varit.add("valkoinen");
			varit.add("sininen");
			varit.add("vaaleanpunainen");
			varit.add("violetti");
			varit.add("musta");
			varit.add("vihreä");
			varit.add("oranssi"); 
			varit.add("okra");
			varit.add("keltainen");
			
		/* 1 *************************************************
		 * Intermediate Operations: filter, map ja sorted
		 * - Palauttavat saman streamin, joten niitä voi olla 
		 * monta peräkkäin
		 *****************************************************/
			
			
			// filter : suodattaa steamista elementtejä annetun ehdon perusteella
			System.out.println("Stream 1: filter");
			varit.stream()
			.filter(s -> s.startsWith("v"))
			.forEach(e -> System.out.println(e));
			
			
			// map : muuntaa streamin elementit toiseksi elementiksi jonkin funktion perusteella
			System.out.println("\nStream 2: map");
			varit.stream()
			.filter((s) -> s.startsWith("v"))
            .map(String::toUpperCase)
            .forEach(e -> System.out.println(e));
			
			// sorted
			System.out.println("\nStream 3: sorted");
			varit.stream()
			.sorted()
			.forEach(e -> System.out.println(e));
			
			// sorted: reverse order
			System.out.println("\nStream 4: sorted reverse order");
			varit.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(e -> System.out.println(e));
			
			// distinct: palauttaa ainutkertaiset elementit
			System.out.println("\nStream 5: ainutkertaiset");
			List<String> distinctElements = varit.stream()
                    .distinct()
                    .collect(Collectors.toList());

			System.out.println("Ainutkertaiset värit: " + distinctElements);
			
			
			
			/* 2 *************************************************
			 * Terminal Operations:  foreach, collect, match
			 * - Palauttavat tietyn tyyppisen tiedon prosessoituaan
			 * streamin elementtejä
			 *****************************************************/
			
			
			// collect : palauttaa elementtejä streamista ja säilöö ne uuteen kokoelmaan
			System.out.println("\nStream 6");
			List<String> colorsInUppercase = varit.stream().sorted()
            .collect(Collectors.toList());

			System.out.print(colorsInUppercase);
			
			// match: anymatch / allmatch / nonematch
			// palauttaa boolean-arvon ehdon toteutumisen mukaan
			System.out.println("\n\nStream 7");
			boolean matchedResult = varit.stream()
			        .anyMatch((s) -> s.startsWith("o"));
			 
			System.out.println("Jokin väri alkaa kirjaimella o: " + matchedResult);     //true
			 
			matchedResult = varit.stream()
			        .allMatch((s) -> s.startsWith("o"));
			 
			System.out.println("Kaikki värit alkavat kirjaimella o: " + matchedResult);     //false
			 
			matchedResult = varit.stream()
			        .noneMatch((s) -> s.startsWith("o"));
			
			System.out.println("Yksikään väri ei ala kirjaimella o: " + matchedResult);     //false
			
			
			// count : palauttaa streamin elementtien määrän Long-tyyppisenä
			System.out.println("\nStream 8");
			long totalMatched = varit.stream()
				    .filter((e) -> e.startsWith("o") || e.startsWith("s"))
				    .count();
				 
				System.out.println("Kirjaimella o tai s alkaa " + totalMatched + " väriä");
			
				
			// reduce : yhdistää streamin elementit
			System.out.println("\nStream 9");
			Optional<String> reduced = varit.stream()
			        .reduce((s1,s2) -> s1 + "#" + s2);
			 
			reduced.ifPresent(e -> System.out.println(e));				
			
			
			// findFirst : palauttaa ensimmäisen elementin streamista
			System.out.println("\nStream 10");
			String firstMatchedName = varit.stream()
		            .filter((s) -> s.startsWith("o") || s.startsWith("m"))
		            .findFirst()
                    .get();
		 
			System.out.println("Ensimmäinen o- tai m-kirjaimella alkava väri: " + firstMatchedName); 
			
			
			
			/* 3 *************************************************
			 * Parallel stream
			 *****************************************************/
			
			
			// stream, jossa ehdot täyttävät värit joukkoon (set) ja tulostetaan lopuksi joukko
			System.out.println("\nStream 11");
			Set<String> variJoukko = varit.parallelStream()
				.filter(e -> e.startsWith("o") || e.startsWith("m"))
				.map(a -> a)	
				.collect(Collectors.toSet()); 	
				
				variJoukko.forEach(a -> System.out.println(a));	
		
		}  
}  