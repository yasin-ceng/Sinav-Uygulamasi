package Pratik2;

import java.io.*;

//Sınav sorusu oluşturmayı sağlayan sınıf
public class Sinav implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3971628254097381498L;

	
	private String soru;
	private String cevap;
	private int puan;
	private String zorluk;
	private String sinavTuru;
	private int  kullaniciPuani;
	private int toplamPuan;
	
	public Sinav(String soru, String cevap, int puan, String zorluk) {
		super();
		this.soru = soru;
		this.cevap = cevap;
		this.puan = puan;
		this.zorluk = zorluk;
	}
	
	public Sinav(String soru, int puan, String zorluk) {
		super();
		this.soru = soru;
		this.puan = puan;
		this.zorluk = zorluk;
	}
	
	public Sinav() {
	
	}
	public Sinav(int puan, String zorluk) {
		this.puan= puan;
		this.zorluk = zorluk;
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

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}

	public String getZorluk() {
		return zorluk;
	}

	public void setZorluk(String zorluk) {
		this.zorluk = zorluk;
	}

	public String getSinavTuru() {
		return sinavTuru;
	}

	public void setSinavTuru(String sinavTuru) {
		this.sinavTuru = sinavTuru;
	}

	public int getKullaniciPuani() {
		return kullaniciPuani;
	}

	public void setKullaniciPuani(int kullaniciPuani) {
		this.kullaniciPuani = kullaniciPuani;
	}

	public int getToplamPuan() {
		return toplamPuan;
	}

	public void setToplamPuan(int toplamPuan) {
		this.toplamPuan = toplamPuan;
	}

	@Override
	public String toString() {
		return " [" + soru + " (Puan: " + puan + ", Zorluk: " + zorluk + ")]";
	}
	
	
}
