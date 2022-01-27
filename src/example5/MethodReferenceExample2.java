package example5;

import java.util.*;

@FunctionalInterface
interface IntPredicate {

    boolean check(int i);

}

class IntPredicatesChecker {

    // staattinen metodi luvun positiivisuuden tarkistamiseksi

    public static boolean isPositive(int n) {

        return n > 0;

    }

    // staattinen metodi luvun parillisuuden tarkistamiseksi

    public static boolean isEven(int n) {

        return (n % 2) == 0;

    }

}


public class MethodReferenceExample2 {
    
//	 metodi, jolle annetaan ensimmäiseksi parametriksi funktionaalinen rajapinta
    public boolean numCheck(IntPredicate p, int n) {

        return p.check(n);

    }

    public static void main(String[] args) {

    	MethodReferenceExample2 demo = new MethodReferenceExample2();

        boolean result;

        int num = 9;

        // tarkistetaan lambdalla, onko luku parillinen

        IntPredicate lb1 = number -> (number % 2) ==0;

        result = demo.numCheck(lb1, num);

        System.out.println("Lambda: " + num + " on parillinen: " + result);

        // tarkistetaan metodiviittauksella, onko luku parillinen

        result = demo.numCheck(IntPredicatesChecker::isEven, num);

        System.out.println("Metodiviittaus: " + num + " on parillinen: " + result);

        // tarkistetaan lambdalla, onko luku positiivinen

        IntPredicate lb2 = number -> number > 0;

        result = demo.numCheck(lb2, num);

        System.out.println("Lambda: " + num + " on positiivinen: " + result);

        // tarkistetaan metodiviiitauksella, onko luku positiivinen

        result = demo.numCheck(IntPredicatesChecker::isPositive, num);

        System.out.println("Metodiviittaus: " + num + " on positiivinen: " + result);
	}
}

