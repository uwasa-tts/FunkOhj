package example6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample3 {

	public static void main(String[] args) {

		Auto auto1 = new Auto("Volvo", "ABC-123", 2016);
		Auto auto2 = new Auto("Audi", "FRD-457", 2014);
		Auto auto3 = new Auto("Toyota", "AFE-122", 2012);
		Auto auto4 = new Auto("Volvo", "JTH-555", 2010);

		// Autot ArrayList-kokoelmassa
		ArrayList<Auto> autoLista = new ArrayList<Auto>();
		autoLista.add(auto1);
		autoLista.add(auto2);
		autoLista.add(auto3);
		autoLista.add(auto4);
		
		System.out.println("Autot, joíden merkki alkaa kirjaimella V");
		ArrayList<Auto> AutotAlkukirjaimella = (ArrayList<Auto>) autoLista.stream()
				.filter(a -> a.getMerkki().startsWith("V"))
				.collect(Collectors.toList());

		System.out.println(AutotAlkukirjaimella);
		
		System.out.println("Autot, jotka uudempia kuin 2013, järjestettynä");
		List<Auto> autotJarjestyksessa = autoLista.stream()
				.filter((a -> a.getVuosiMalli() > 2013))
				.sorted()
	            .collect(Collectors.toList());

		System.out.print(autotJarjestyksessa);
				
		// Autot Map-kokoelmassa
		Map<String, Auto> autot = new HashMap<String, Auto>();
		autot.put(auto1.getRekNro(), auto1);
		autot.put(auto2.getRekNro(), auto2);
		autot.put(auto3.getRekNro(), auto3);
		autot.put(auto4.getRekNro(), auto4);
		
	
		System.out.println("\nAutot mapista:");
		Map<String, Auto> tulokset = autot.entrySet() 
		          .stream()
		          .filter(map -> map.getValue().getVuosiMalli() > 2012) 
		          .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));  
		  
		tulokset.forEach((k,v)->System.out.println("avain: " + k + ", arvot: " + v));
	}

}