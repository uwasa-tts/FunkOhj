package example6;

import java.util.Comparator;

public class Auto implements Comparable<Auto>, Comparator<Auto> {
	private String merkki;
	private String rekNro;
	private int vuosiMalli;
	
	public Auto(String merkki, String rekNro, int vuosiMalli) {
		super();
		this.merkki = merkki;
		this.rekNro = rekNro;
		this.vuosiMalli = vuosiMalli;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getRekNro() {
		return rekNro;
	}

	public void setRekNro(String rekNro) {
		this.rekNro = rekNro;
	}
	
	public int getVuosiMalli() {
		return vuosiMalli;
	}

	public void setVuosiMalli(int vuosiMalli) {
		this.vuosiMalli = vuosiMalli;
	}

	@Override
	public String toString() {
		return "merkki = " + merkki + ", rekisteriNro = " + rekNro;
	}

	@Override
	public int compare(Auto a, Auto b) {
		return a.getRekNro().compareTo(b.getRekNro());
	}

	//@Override
	public int compareTo(Auto o) {
		return this.getRekNro().compareTo(o.getRekNro());
	}
	
	
	
}
