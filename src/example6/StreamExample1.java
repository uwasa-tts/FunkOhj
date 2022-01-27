package example6;

import java.util.stream.*; 
import java.util.*; 

public class StreamExample1 {  

	public static void main(String[] args){  

		/* Stream, johon lis‰t‰‰n kokonaisluvut v‰lilt‰ 1-4 ja joka sitten tulostaa luvut
		*/
		System.out.println("Stream 1");
		IntStream.range(1,5)
		.forEach(e -> System.out.println(e));

		/* Stream, joka laskee keskiarvon luvuista v‰lilt‰ 3-8
		*/

		System.out.println("Stream 2");
		IntStream.range(3,9)
		.average()
		.ifPresent(System.out::println);
		
		/* Stream, joka tulostaa nelj‰ll‰ jaolliset luvut v‰lilt‰ 1-24
		*/
		System.out.println("Stream 3");
		IntStream.iterate(1, e->e+1)  
		.filter(e->e%4==0)  
		.limit(6)  
		.forEach(System.out::println); 

		/* Stream, joka tulostaa luvut 21-29
		*/
		System.out.println("Stream 4");
		IntStream.range(10,30)
		.filter(e -> e > 20)
		.forEach(e -> System.out.println(e));	

		/* Stream, joka kertoo taulukossa olevat luvut 1-6 itsell‰‰n,
			sijoittaa tulokset listaan ja tulostaa listan
		*/

		System.out.println("Stream 4: listan luvut potenssiin kaksi");
		List<Integer> luvut = Arrays.asList(1,2,3,4,5,6);
        List<Integer> luvut2 = luvut.stream()
        		.map(n -> n * n)
        		.collect(Collectors.toList());
        System.out.println(luvut2);      
        
		System.out.println("Stream 5: luvut joukkoon (set)");
		Set square = luvut.stream()
				.map(x->x*x)
				.collect(Collectors.toSet());
		System.out.println(square);
		
		System.out.println("Stream 6: listan luvut suuruusj‰rjestyksess‰");
		List<Integer> numbers = Arrays.asList(6, 7, 2, 9, 3, 5, 1, 2, 8, 12, 15, 6);
		numbers.stream().sorted().forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nStream 7: listan luvut k‰‰nteisess‰ suuruusj‰rjestyksess‰");
		numbers.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.print(e + " "));
		
		
		System.out.println("\nStream 8: max ja min listan luvuista");
		Integer max = numbers.stream()
				.max(Comparator.comparing(Integer::valueOf))
                .get();
		
		Integer min = numbers.stream()
				.min(Comparator.comparing(Integer::valueOf))
                .get();
		System.out.println("Max: " + max + " ja min: " + min);
		
		System.out.println("\nStream 9: tilastoja listan luvuista v‰h‰n toisin");
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Suurin luku : " + stats.getMax());
		System.out.println("Pienin luku : " + stats.getMin());
		System.out.println("Lukujen summa : " + stats.getSum());
		System.out.println("Keskiarvo : " + stats.getAverage());
	}  
}  