package Pratik2;

import java.io.Serializable;

//Doğru / Yanlış tipinde soru oluşturmayı sağlayan sınıf
public class DYSoru extends Soru implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DYSoru() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public DYSoru(String soruTipi, String soru, String cevap, String zorluk, int puan) {
		super(soruTipi, soru, cevap, zorluk, puan);
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public String toString() {
		return "D/Y Sorusu [" + soru + " (Zorluk:" + zorluk + " Puan: " + puan + ")]\n";
	}
	
	

}
