package Pratik2;

import java.io.Serializable;

//Boşluk Doldurma Soruları için oluşturulan sınıf
public class BoslukDoldurma  extends Soru implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public BoslukDoldurma() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoslukDoldurma(String soruTipi, String soru, String cevap, String zorluk, int puan) {
		super(soruTipi, soru, cevap, zorluk, puan);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Boşluk Doldurma [" + soru  + " (Zorluk: " + zorluk + ", Puan: " + puan + ")]\n";
	}
	
	
	

}
