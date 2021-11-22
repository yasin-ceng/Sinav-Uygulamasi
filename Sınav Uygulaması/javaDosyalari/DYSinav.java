package Pratik2;


//Doğru / Yanlış Sorularından Sınav oluşturmayı sağlayan sınıf
public class DYSinav extends Sinav{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DYSinav() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DYSinav(String soru, String cevap, int puan, String zorluk) {
		super(soru, cevap, puan, zorluk);
		// TODO Auto-generated constructor stub
	}
	public DYSinav(String soru, int puan, String zorluk) {
		super(soru, puan, zorluk);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "D/Y Sınav Sorusu = " + super.toString() + "\n<<Kullanıcı Cevabı: " + getCevap()+">>\n" ;
	}
	
	
	
	

}
