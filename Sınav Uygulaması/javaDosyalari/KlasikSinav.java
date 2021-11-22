package Pratik2;

import java.io.Serializable;

//Klasik Sorulardan Sınav oluşturmayı sağlayan sınıf
public class KlasikSinav extends Sinav implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public KlasikSinav() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KlasikSinav(String soru, String cevap, int puan, String zorluk) {
		super(soru, cevap, puan, zorluk);

	}
	public KlasikSinav(String soru, int puan, String zorluk) {
		super(soru, puan, zorluk);
		
	}

	

	@Override
	public String toString() {
		return "Klasik Sınav Sorusu: " + super.toString() + "\n<<Kullanıcı Cevabı: " + getCevap()+">>\n";
	}

	
	
	

}
