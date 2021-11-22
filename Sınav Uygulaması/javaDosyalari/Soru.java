package Pratik2;

import java.io.Serializable;


//Soru üretmek için kullanılacak sınıf

public class Soru implements Serializable , Comparable<Soru>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String soru;
	protected String cevap;
	protected String zorluk;
	protected int puan;
	protected String soruTipi;
	
	
	private String cvpA;
	private String cvpB;
	private String cvpC;
	private String cvpD;
	
	
	public Soru(String soruTipi, String soru, String cevap, String zorluk, int puan) {
		super();
		this.soruTipi = soruTipi;
		this.soru = soru;
		this.cevap = cevap;
		this.zorluk = zorluk;
		this.puan = puan;
	}
	
	
	public Soru(String soru, String cvpA, String cvpB,String cvpC, String cvpD,String cevap, String zorluk, int puan) {
		this.soru = soru;
		this.cvpA = cvpA;
		this.cvpB = cvpB;
		this.cvpC = cvpC;
		this.cvpD = cvpD;
		this.cevap = cevap;
		this.zorluk = zorluk;
		this.puan = puan;
	}
	
	public Soru() {
		
	}
	

	public String getSoruTipi() {
		return soruTipi;
	}
	public void setSoruTipi(String soruTipi) {
		this.soruTipi = soruTipi;
	}
	public String getSoru() {
		return soru;
	}


	public void setSoru(String soru) {
		this.soru = soru;
	}


	public String getCevap() {
		return cevap;
	}


	public void setCevap(String cevap) {
		this.cevap = cevap;
	}


	public String getZorluk() {
		return zorluk;
	}


	public void setZorluk(String zorluk) {
		this.zorluk = zorluk;
	}


	public int getPuan() {
		return puan;
	}


	public void setPuan(int puan) {
		this.puan = puan;
	}
	
	
	
	@Override
	public String toString() {
		return "Soru [soru=" + soru + ", zorluk=" + zorluk + ", puan=" + puan + "]";
	}
	
	//ABCD
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
	public int compareTo(Soru o) {
		if( this.puan < o.puan)
			return -1;
		if( this.puan == o.puan)
			return 0;
		return 1;
	}
	
}
