package Pratik2;

import java.io.Serializable;

//Klasik soru tipindeki soruları oluşturmayı sağlayan sınıf
public class KlasikSoru extends Soru implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public KlasikSoru(String soruTipi, String soru, String cevap, String zorluk, int puan) {
		super(soruTipi, soru, cevap, zorluk, puan);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public KlasikSoru() {
		
	}

	@Override
	public String toString() {
		return "Klasik Soru [" + soru + " (Zorluk: " + zorluk + ", Puan=" + puan + ")]\n";
	}


	
}
