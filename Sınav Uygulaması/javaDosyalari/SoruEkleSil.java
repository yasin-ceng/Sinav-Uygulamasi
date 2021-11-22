package Pratik2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import java.io.*;

//Soru eklemek ve silmek için oluşturulan sınıf
public class SoruEkleSil  {
	

	Scanner veriGir = new Scanner(System.in);
	
	Vector<Soru> yeniSoru = new Vector<>();
	Soru so = new Soru();
	
	//klasik soru ekleme metodu
	public void klasikEkle() {

		Soru k = new KlasikSoru();
		
		k.setSoruTipi("Klasik");
		
		System.out.println("Sorunuzu Giriniz :");
		k.setSoru(veriGir.nextLine());

		System.out.println("Cevabı Giriniz :");
		k.setCevap(veriGir.nextLine());
		
		System.out.println("Zorluk Seviyesi Giriniz :");
		k.setZorluk(veriGir.nextLine());
		
		System.out.println("Puan Giriniz :");
		k.setPuan(veriGir.nextInt());
		veriGir.nextLine();
					
		yeniSoru.add(k);
		soruEkle(k);
		System.out.println("Başarıyla Eklendi.\n");
		
	}
	
	//Doğru/Yanlış tipinde soru ekleme metodu
	public void dySoruEkle() {
		
		Soru dy = new DYSoru();
		
		dy.setSoruTipi("DYSoru");
		
		System.out.println("Sorunuzu Giriniz :");
		dy.setSoru(veriGir.nextLine());

		System.out.println("Cevabı Giriniz :");
		dy.setCevap(veriGir.nextLine());
		
		System.out.println("Zorluk Seviyesi Giriniz :");
		dy.setZorluk(veriGir.nextLine());
		
		System.out.println("Puan Giriniz :");
		dy.setPuan(veriGir.nextInt());
		veriGir.nextLine();
					
		yeniSoru.add(dy);
		soruEkle(dy);
		System.out.println("Başarıyla Eklendi.\n");
		
		
	}
	
	//Boşluk Doldurma Soruları Ekleme Metodu
	public void boslukDoldurmaEkle() {
		
		Soru bd = new BoslukDoldurma();
		
		bd.setSoruTipi("Bosluk");
		
		System.out.println("Sorunuzu Giriniz :");
		bd.setSoru(veriGir.nextLine());

		System.out.println("Cevabı Giriniz :");
		bd.setCevap(veriGir.nextLine());
		
		System.out.println("Zorluk Seviyesi Giriniz :");
		bd.setZorluk(veriGir.nextLine());
		
		System.out.println("Puan Giriniz :");
		bd.setPuan(veriGir.nextInt());
		veriGir.nextLine();
					
		yeniSoru.add(bd);
		soruEkle(bd);
		System.out.println("Başarıyla Eklendi.\n");
		
		
	}
	
	//Test sorusu ekleme metodu
	public void testEkle() {

		Soru t = new TestSoru();
		
		t.setSoruTipi("Test");
	
		System.out.println("Sorunuzu Giriniz :");
		t.setSoru(veriGir.nextLine());
		System.out.println("A Şıkkını Giriniz :");
		t.setCvpA(veriGir.nextLine());
		System.out.println("B Şıkkını Giriniz :");
		t.setCvpB(veriGir.nextLine());
		System.out.println("C Şıkkını Giriniz :");
		t.setCvpC(veriGir.nextLine());
		System.out.println("D Şıkkını Giriniz :");
		t.setCvpD(veriGir.nextLine());
		System.out.println("Doğru Şıkkı Giriniz :");
		t.setCevap(veriGir.nextLine());
		
		System.out.println("Zorluk Seviyesi Giriniz :");
		t.setZorluk(veriGir.nextLine());
		
		System.out.println("Puan Giriniz :");
		t.setPuan(veriGir.nextInt());
		veriGir.nextLine();
			
		
		yeniSoru.add(t);
		soruEkle(t);
		System.out.println("Başarıyla Eklendi.\n");
		
	}
	
	//Oluşturulan Soruları Eklemek İçin Kullanılacak Metot
	public void soruEkle(Soru newSoru) {
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();
			
			sorular.add(newSoru);
			
			
			try {
				
				
				FileOutputStream fos = new FileOutputStream("sorubankasi.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		
				oos.writeObject(sorular);
				
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

	//Soru Silmek için soru metinlerine gör ara parametresiyle hangi sorunun silineceğini tespit etmede kullanılacak olan metot.
	public void soruCikarTespit(String ara) {
	 System.out.println("Gelen sozcuk: "+ara);
	
	 int araInt;
	 boolean soruYok = true;
	 
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			ois.close();

			
			for (Soru soru : sorular) {
				 if(soru.getSoru().indexOf(ara)!=-1) {
					 System.out.println("Soru indeks numarası: " + sorular.indexOf(soru) );
					 System.out.println(soru); 
					 soruYok = false;
				 }
			}
				 if(soruYok)
					 System.out.println("Girdiğiniz kelimeyi içeren soru bulunamadı");
				 else {
					 System.out.println("Silmek istediğiniz sorunun indeks numarasını girin:");
					 araInt = veriGir.nextInt();
					 soruCikar(araInt);	
					 veriGir.nextLine();
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
	
	//indeks numarasını parametre olarak alarak ilgili soruyu silmeye yarayan metot
	public void soruCikar(int i) {
	
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();
		
			sorular.remove(i);
		
		
				try {
			
			
					FileOutputStream fos = new FileOutputStream("sorubankasi.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
			
					oos.writeObject(sorular);
			
					oos.close();
					System.out.println("Soru Silindi.");
			
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


	
	//içeriği silinecek olan dosya adını parametre olarak alarak temizleyen metot
	public void dosyaTemizle(String dosya) {
		try {
			
			FileOutputStream fos = new FileOutputStream(dosya);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			yeniSoru.clear();
			oos.writeObject(yeniSoru);
		
			oos.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//tüm soruları listeler
	public void soruGosterTumu() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<< Tüm Sorular >>>>>>>>>>>>>>>>>>>>>>");
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			for (Soru soru : sorular) {
				System.out.println(soru);
			}
			
			ois.close();
			
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
	
	//metin içeriğine göre soruları listeler
	public void soruGosterMetinOzelinde(String ara) {
		
		boolean soruVar = false;
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			for (Soru soru : sorular) {
				if(soru.getSoru().indexOf(ara)!=-1) {
				System.out.println(soru);
				soruVar=true;
				}
			}
			if(!soruVar)
				System.out.println("Girdiğiniz kelimeyi içeren soru bulunamadı.");
			
			
			
			ois.close();
			
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
	
	//soruları şıklarda bulunan kelimeye göre arayıp görüntüler
	public void soruGosterSecenekOzelinde(String ara) {
		
		boolean soruVar = false;
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			for (Soru soru : sorular) {
				if(soru.toString().indexOf("Test:")!=-1)
				if(soru.getCvpA().indexOf(ara)!=-1 || soru.getCvpB().indexOf(ara)!=-1 || 
				   soru.getCvpC().indexOf(ara)!=-1 || soru.getCvpD().indexOf(ara)!=-1) {
					System.out.println(soru);
					soruVar=true;
				}
			}
			if(!soruVar)
				System.out.println("Girdiğiniz kelimeyi içeren soru bulunamadı.");
			
			
			
			ois.close();
			
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
	
	//Doğru Şıklara göre soruları listelemeyi sağlayan metot
	public void soruGosterCevapOzelinde(String ara) {
		
		boolean soruVar = false;
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			for (Soru soru : sorular) {
				if(soru.toString().indexOf("Test:")!=-1)
					if(soru.getCevap().indexOf(ara)!=-1)  {
						System.out.println(soru);
						soruVar=true;
					}
			}
			if(!soruVar)
				System.out.println("Girdiğiniz kelimeyi içeren soru bulunamadı.");
			
			
			
			ois.close();
			
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
	
	//Kaç puanlık sorular görüntülenmek istiyorsa ekrana yazdırır
	public void soruGosterPuanOzelinde(int araInt) {
				
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			for (Soru soru : sorular) {
					if(soru.getPuan()==araInt)  {
						System.out.println(soru);
					}
			}
			
			ois.close();
			
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
	
	//Puanlarına göre küçükten büyüğe soruları sıralamayı sağlayan metot
	public void soruSiralaPuanaGore() {
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			Collections.sort(sorular);
			for (Soru soru : sorular) {
				System.out.println(soru);
			}

			ois.close();
			
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
	
	//Zorluk seviyesine göre soruları listeler
	public void soruGosterZorlukOzelinde(String ara) {
		
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			
			for (Soru soru : sorular) {
				if(soru.getZorluk().indexOf(ara)!=-1)  {
					System.out.println(soru);
				}
			}
			
			ois.close();
			
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


}

