package Pratik2;

import java.io.Serializable;

//Test Sorusu oluşturmaya yarayan sınıf
public class TestSoru extends Soru implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	
	private String cvpA;
	private String cvpB;
	private String cvpC;
	private String cvpD;
	
	
	public TestSoru(String soruTipi, String soru, String cvpA, String cvpB , String cvpC , String cvpD, String cevap, String zorluk, int puan) {
		super(soruTipi,soru, cevap, zorluk, puan);
		this.cvpA = cvpA;
		this.cvpB = cvpB;
		this.cvpC = cvpC;
		this.cvpD = cvpD;
	}
	
	public TestSoru() 
	{
		
	}
	
	

	public String getCvpA() {
		return cvpA;
	}

	public void setCvpA(String cvpA) {
		this.cvpA = cvpA;
	}

	public String getCvpB() {
		return cvpB;
	}

	public void setCvpB(String cvpB) {
		this.cvpB = cvpB;
	}

	public String getCvpC() {
		return cvpC;
	}

	public void setCvpC(String cvpC) {
		this.cvpC = cvpC;
	}

	public String getCvpD() {
		return cvpD;
	}

	public void setCvpD(String cvpD) {
		this.cvpD = cvpD;
	}
	
	
	
	
	

	@Override
	public String toString() {
		
		return "Test:\n" + soru +  "\nA) " + cvpA + "\nB) " + cvpB +
				"\nC) "+ cvpC + "\nD) " + cvpD +"\n(" + zorluk+" - "+ puan +" Puan)\n" ;
	}


	
	
	

}
