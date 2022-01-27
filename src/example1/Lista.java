package example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lista {

	public static void main(String[] args) {

		List<String> kalat = new ArrayList<>();
		kalat.add("Ahven");
		kalat.add("Hauki");
		kalat.add("Kuha");
		
		if(kalat.contains("Hauki"))
			System.out.println("Hauki on kala");
		
		Iterator i = kalat.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
		// Kokoelman sisältö taulukkoon
		String[] kaloja = kalat.toArray(new String[kalat.size()]);
		
		// Poistetaan listasta kuhat
//		kalat.remove("Kuha");
		System.out.println(kalat.removeIf(s -> s.equals("Kuha")));
		
		// Muunnettaan listan sisältö suurilla kirjaimilla kirjoitetuksi
		ListIterator<String> it = kalat.listIterator();
//		while(it.hasNext())
//			it.set(it.next().toUpperCase());
		kalat.replaceAll(s -> s.toUpperCase());
		
		System.out.println("Tulostetaan järjestyksessä");
		ListIterator<String> ite = kalat.listIterator();
		while(ite.hasNext())
			System.out.println(ite.next());
		
		System.out.println("Tulostetaan käänteisessä järjestyksessä");
		while(ite.hasPrevious())
			System.out.println(ite.previous());

		System.out.println("Lista sekaisin:");
		Collections.shuffle(kalat);
		System.out.println(kalat);
		System.out.println("Lista järjestyksessä:");
		Collections.sort(kalat);
		System.out.println(kalat);
		
		// läpikäynti for-each-silmukalla tulostaen sanan pituus ja sama lambda-lauseella
		for(String s: kalat)
			System.out.println(s + " pituus " + s.length());
		
		kalat.iterator().forEachRemaining(s -> System.out.println(s + " pituus " + s.length()));
		
		
	}

}