package Pratik2;

import java.io.Serializable;

//Test Sorularından Sınav oluşturmayı sağlayan sınıf
public class TestSinavi extends Sinav implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cvpA;
	private String cvpB;
	private String cvpC;
	private String cvpD;
	
	
	public TestSinavi() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public TestSinavi(String soru,String cevap,int puan,String zorluk, String cvpA,String cvpB, String cvpC, String cvpD) {
		super(soru, cevap, puan, zorluk);
		this.cvpA=cvpA;
		this.cvpB=cvpB;
		this.cvpC=cvpC;
		this.cvpD=cvpD;
	}
	public TestSinavi(int puan,String zorluk, String cvpA,String cvpB, String cvpC, String cvpD) {
		super(puan,zorluk);
		this.cvpA=cvpA;
		this.cvpB=cvpB;
		this.cvpC=cvpC;
		this.cvpD=cvpD;
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
		return "Test Sınav Sorusu:\n" + getSoru()  + "  ("+ getZorluk() + " - " + getPuan() +"p)\nA)" 
				+  this.cvpA + "\nB)"+ this.cvpB +"\nC)"+ this.cvpC +"\nD)"+ this.cvpD  +"\n<< Kullanıcı Cevabı: "+ getCevap()+" >>\n";
	}
	
	
}
