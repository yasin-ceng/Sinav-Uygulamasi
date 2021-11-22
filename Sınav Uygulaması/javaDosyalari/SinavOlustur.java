package Pratik2;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

//Soru Bankası dosyasından soruları okuyup her türde sınav sorusu oluşturan sınıf
public class SinavOlustur {
	
	Scanner veriGir = new Scanner(System.in);
	private int kullaniciPuani;
	private int toplamPuan;
	
	//Test Sınav Sorularını oluşturan metot x değeri sorulacak soru sayısını belirlemede kullanılır. (x=1: 1 soru, x=100: 100 puanlık sınav)
	public int testSinaviYap(int x) {

			toplamPuan=0;
			Vector<Sinav> test = new Vector<>();
			
			try {
				FileInputStream fis = new FileInputStream("sorubankasi.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Vector<Soru> sorular = (Vector<Soru>)ois.readObject();
				
				
				for(;toplamPuan<x;) {
					int random = (int) (Math.random()*sorular.size());
					Soru soru = sorular.get(random);
					if(soru.getSoruTipi().equalsIgnoreCase("Test")) {

						Sinav t = new TestSinavi(soru.getSoru(),soru.getCevap(),soru.getPuan(),soru.getZorluk(),soru.getCvpA(),soru.getCvpB(),soru.getCvpC(),soru.getCvpD());
						System.out.println(soru);
						
						
						System.out.print("Cevap: ");
						String cevap = veriGir.nextLine().toUpperCase().trim();
						t.setCevap(cevap);
						System.out.println();
						test.add(t);
						if(cevap.equals(soru.getCevap())) {
						kullaniciPuani+=soru.getPuan();
						}
						toplamPuan+=soru.getPuan();
					}
					
					}
				
				
				sinavEkle(test);
				if(x==100)
				System.out.println("Sınav Sona Erdi..\n/*/*/ Aldığınız Puan: " +kullaniciPuani+ "/"+toplamPuan + " /*/*/\n");
				
				
			}catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return toplamPuan;
	}
	
	//tüm sorulardan random 1'er tane seçerek 100-110 puan arasında sınav oluşturan metot
	public void karmaSinavYap() {
		
		System.out.println("Karışık Sınav Başlıyor...\n");
		
		for(int puan=0;puan<100;) {
		int random=(int)(Math.random()*4);
		switch(random) {
		case(0):
			puan+=klasikSinavYap(1);break;
		case(1):
			puan+=testSinaviYap(1);break;
		case(2):
			puan+=bdSinavYap(1);break;	
		case(3):
			puan+=dySinavYap(1); break;
		default: break;
		}
		
		}
		
			
			
	}

	//Klasik Sınav Sorularını oluşturan metot x değeri sorulacak soru sayısını belirlemede kullanılır. (x=1: 1 soru, x=100: 100 puanlık sınav)
	public int klasikSinavYap(int x) {
		
		toplamPuan=0;
		Vector<Sinav> klasik = new Vector<>();
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();
			
			
			
			for(;  toplamPuan<x  ;) {
				int random = (int) (Math.random()*sorular.size());
				Soru soru = sorular.get(random);
				if(soru.getSoruTipi().equalsIgnoreCase("Klasik")) {
					
					Sinav t = new KlasikSinav(soru.getSoru(),soru.getCevap(),soru.getPuan(),soru.getZorluk());
					
					System.out.println(soru);
					
					System.out.print("Cevap: ");
					String cevap = veriGir.nextLine();
					t.setCevap(cevap);
					System.out.println();
					klasik.add(t);
					
					
					toplamPuan+=soru.getPuan();
				}
				
			}
			
			
			sinavEkle(klasik);
			
			
		}catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toplamPuan;

	}
	

	//Boşluk Doldurma Sorularını oluşturan metot x değeri sorulacak soru sayısını belirlemede kullanılır. (x=1: 1 soru, x=100: 100 puanlık sınav)
	public int bdSinavYap(int x) {

		
		toplamPuan=0;
		
		Vector<Sinav> bd = new Vector<>();
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();
			
			
			
			for(;toplamPuan<x;) {
				int random = (int) (Math.random()*sorular.size());
				Soru soru = sorular.get(random);
				if(soru.getSoruTipi().equalsIgnoreCase("Bosluk")) {
					
					Sinav t = new BoslukDoldurmaSinav(soru.getSoru(),soru.getPuan(),soru.getZorluk());
					
					System.out.println(soru);
					
					System.out.print("Cevap: ");
					String cevap = veriGir.nextLine();
					t.setCevap(cevap);
					System.out.println();
					bd.add(t);
				
					
					
					toplamPuan+=soru.getPuan();
				}
				
			}
			
			sinavEkle(bd);
			
			
		}catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toplamPuan;
	}

	//Doğru/Yanlış Sorularını oluşturan metot x değeri sorulacak soru sayısını belirlemede kullanılır. (x=1: 1 soru, x=100: 100 puanlık sınav)
	public int dySinavYap(int x) {
		
		
		toplamPuan=0;
		Vector<Sinav> dy = new Vector<>();
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();
			
			
			
			for(;toplamPuan<x;) {
				int random = (int) (Math.random()*sorular.size());
				Soru soru = sorular.get(random);
				if(soru.getSoruTipi().equalsIgnoreCase("DYSoru")) {
					
					Sinav t = new DYSinav(soru.getSoru(),soru.getPuan(),soru.getZorluk());
					
					System.out.println(soru );
					
					System.out.print("Cevap: ");
					String cevap = veriGir.nextLine();
					t.setCevap(cevap);
					System.out.println();
					dy.add(t);
					
					toplamPuan+=soru.getPuan();
				}
				
			}
			
			sinavEkle(dy);
			
			
		}catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toplamPuan;
	}
	
	//Oluşturulan sınavı sınavlar dosyasına ekler
	public void sinavEkle(Vector<Sinav> newSinav){
		try {
			
			FileInputStream fis = new FileInputStream("sinavlar.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Sinav> sinavlar = (Vector<Sinav>)ois.readObject();
			
			sinavlar.addAll(newSinav);
			
			try {
				
				
				FileOutputStream fos = new FileOutputStream("sinavlar.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		
				oos.writeObject(sinavlar);
				
				oos.close();
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Sınav Sorularını görüntülemek için kullnılacak olan sınıf
	public void sinavGoruntule() {
		System.out.println(">>>>>>>>>>>>>>>>  Sınavlar Gösteriliyor   <<<<<<<<<<<<\n");
		try {
		FileInputStream fis = new FileInputStream("sinavlar.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Vector<Sinav> sinavlar = (Vector<Sinav>)ois.readObject();
		
		for (Sinav sinav : sinavlar) {
			System.out.println(sinav);
		}
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//sınavlar.dat dosyasının tüm içeriğini siler
	public void dosyaTemizle() {
		
		Vector<Sinav> sinavlar = new Vector<>();
		
		try {
			
		FileOutputStream fos = new FileOutputStream("sinavlar.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		sinavlar.clear();
		oos.writeObject(sinavlar);
		
		oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		