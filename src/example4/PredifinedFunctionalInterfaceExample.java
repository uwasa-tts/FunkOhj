package example4;
/* 
 * Joitain esimerkkejä paketin java.util.Function
 * valmiista funktionaalisista rajapinnoista
 */

import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredifinedFunctionalInterfaceExample {

	public static void main(String[] args) {

		/* ********************************************
		 * Function : suorittaa jonkin toimenpiteen, parametri ja paluuarvo
		 * interface Function<T,R> { 
    			R apply(T t);
			}
		 */
		System.out.println("Function:");
		Function<Integer, Integer> adder = (value) -> value + 3;
		Integer result = adder.apply(8);
		System.out.println("result after adding = " + result);
		
		Function<String, Integer> strLength = s -> s.length(); 
		System.out.println(strLength.apply("ohjelmoinnin erikoiskurssi")); 
		
		
		/* *********************************************
		 * BiFunction : suorittaa jonkin toimenpiteen, kaksi parametria ja paluuarvo
		interface BiFunction<T, U, R> {
		    R apply(T t, U u);
		}
		 */
		System.out.println("\nBiFunction:");
		BiFunction<Integer,Integer,Integer> bf = (i,j)->i+j; 
		System.out.println("24 + 4 = " + bf.apply(24,4)); 
		
		
		/* *********************************************
		 * Predicate : toteuttaa tilatarkistuksia, parametri ja paluuarvona boolean
		 * public interface Predicate<T> {
    			boolean test(T t);
			}
		*/
		System.out.println("\nPredicate:");
		Predicate<Integer> lesserthan = i -> (i < 18); 
        System.out.println("Onko 12 pienempi kuin 18? " + lesserthan.test(12));
        
        
        /* *********************************************
		 * Consumer : suorittaa jonkin toimenpiteen, yksi parametri, mutta ei paluuarvoa
		 * interface Consumer<T> {
   				void accept(T t);
			}
		*/
		System.out.println("\nConsumer:");
        Consumer<String> showThreeTimes = s -> {
        	System.out.println(s);
        	System.out.println(s);
        	System.out.println(s);
        }; 
        
        showThreeTimes.accept("punainen");
        showThreeTimes.accept("sininen");
        
        
        /* *********************************************
		 * Supplier : ei parametria, mutta palauttaa jonkin objektin
        *  interface Supplier<R>{
            	R get();
        	}
        */
        System.out.println("\nSupplier:");
        Supplier<Integer> supplier = () -> (int) (Math.random() * 1000);
        System.out.println("Arvottu luku on " + supplier.get());
        
        Supplier<LocalDateTime> time = () -> LocalDateTime.now();
        System.out.println(time.get());
	}

}
