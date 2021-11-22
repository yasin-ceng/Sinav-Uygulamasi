package Pratik2;

//Boşluk Doldurma Sorularından Sınav oluşturmayı sağlayan sınıf
public class BoslukDoldurmaSinav extends Sinav{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BoslukDoldurmaSinav() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BoslukDoldurmaSinav(String soru, String cevap, int puan, String zorluk) {
		super(soru, cevap, puan, zorluk);
		// TODO Auto-generated constructor stub
	}
	public BoslukDoldurmaSinav(String soru, int puan, String zorluk) {
		super(soru, puan, zorluk);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Boşluk Doldurma Sınav Sorusu: " + super.toString() + "\n<<Kullanıcı Cevabı: " + getCevap()+">>\n";
	}
	
	

}
