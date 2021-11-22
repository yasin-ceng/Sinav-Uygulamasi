package Pratik2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;


//Ekrana yapılacak işlemler için Menü seçeneklerini getirir

public class Menu  {
	
	static SoruEkleSil addremove = new SoruEkleSil();
 	static Scanner veriGir = new Scanner(System.in);
 	
 	//kullanıcıdan alınacak seçimler için
 	static int secim; 	
 	//aranacak kelimeyi tutabilmek için
 	static String ara;

 	//Ana Menü
 	public static int menuGoster() {
	
	try {
			System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz");
			System.out.println("1.Soru Ekle");
			System.out.println("2.Soru Çıkar");
			System.out.println("3.Soruları Listele");
			System.out.println("4.Sınav Oluştur");
			System.out.println("5.Çıkış");
			
			
			secim = veriGir.nextInt();
			veriGir.nextLine();
			switch(secim) {
				case(1): soruEkle(); break;
				case(2): soruCikar(); break;
				case(3): sorulariGoster(); break;
				case(4): sinav(); break;
				case(5): return 5;
				default: System.out.println("Geçerli Bir Seçim Yapmadınız.\n"); break;
			}
		}catch(InputMismatchException e){
			System.err.println("Hatalı Giriş Yaptınız");
			veriGir.nextLine();
			return menuGoster();
		}
	
	return 0;
 	}	

 	//Sınav Menüsü
 	public static void sinav() {

	SinavOlustur yeniSinav = new SinavOlustur();
	
		try {
			FileInputStream fis = new FileInputStream("sorubankasi.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Vector<Soru> sorular = (Vector<Soru>)ois.readObject();;
			ois.close();
			
			System.out.println("Lütfen Sınav Yapmak İstediğiniz Soru Tipi Seçiniz");
			System.out.println("1.Test Sınavı");
			System.out.println("2.Klasik Sınav");
			System.out.println("3.Karışık Sınav");
			System.out.println("4.Sınav Görüntüle");		
			System.out.println("5.Çıkış");
		
 	
			secim = veriGir.nextInt();	
			veriGir.nextLine();	
			switch(secim) {
		
			case(1): yeniSinav.testSinaviYap(100); break;
	 		
			case(2): yeniSinav.klasikSinavYap(100); break;
			
			case(3): yeniSinav.karmaSinavYap(); break;
			
			case(4): yeniSinav.sinavGoruntule(); break;
	
			case(5): break;
			
			default: System.out.println("Geçersiz Giriş Yapıldı"); break;
	
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

 	//Soru Ekle Menü Seçenekleri

 	public static void soruEkle() {
	
		System.out.println("Lütfen Eklemek İstediğiniz Soru Tipini Seçiniz");
		System.out.println("1.Test Sorusu Ekle");
		System.out.println("2.Klasik Soru Ekle");
		System.out.println("3.Doğru Yanlış Sorusu Ekle");
		System.out.println("4.Boşluk Doldurma Sorusu Ekle");
		System.out.println("5.Çıkış");
		

		secim = veriGir.nextInt();
		veriGir.nextLine();
		switch(secim) {
			case(1): addremove.testEkle(); break;
			case(2): addremove.klasikEkle(); break;
			case(3): addremove.dySoruEkle(); break;
			case(4): addremove.boslukDoldurmaEkle(); break;
			case(5): System.out.println("Soru Eklemeden Çıkış Yapıldı\n");break;
			default: System.out.println("Geçerli Bir Seçim Yapmadınız.\n"); break;
		}
 	}
 	
 	//soru çıkarma için yardımcı seçenekler
	public static void soruCikar() {
		
		 System.out.println("Hangi soruyu silmek istersiniz ? \n"
					+ "Lütfen içerdiği kelimeyi girin: ");

		 ara = veriGir.nextLine();


		 addremove.soruCikarTespit(ara);
	}
	
	//Soru Listeleme Menüsü
	public static void sorulariGoster () {
		

		 System.out.println("1.Tüm Soruları Listele");
		 System.out.println("2.Soru Metinleri İçeriğine Göre Listele");
		 System.out.println("3.Şıkların Metin İçeriklerine Göre Listele");
		 System.out.println("4.Doğru Şıklara Göre Listele");
		 System.out.println("5.Puan Seviyesine Göre Listele");
		 System.out.println("6.Puan Seviyesine Göre Sırala");
		 System.out.println("7.Zorluk Seviyesine Göre Listele");
		 System.out.println("8.Çıkış");
		 
		 System.out.println("\nSeçiminiz Nedir ?");
		 secim = veriGir.nextInt();
		 veriGir.nextLine();
		 int araInt = 0;
		
		
			switch(secim){
	 		
	 		case(1):
	 				addremove.soruGosterTumu(); break;
	 				
	 		case(2):
	 				System.out.println("Soru metinlerinde bulunan kelimeyi girin:");	
	 				ara = veriGir.next().trim();
	 				addremove.soruGosterMetinOzelinde(ara);
	 				break;
		
	 		case(3):
	 				System.out.println("Şıklarda bulunan kelimeyi girin: ");
	 				ara = veriGir.next().trim();
	 				addremove.soruGosterSecenekOzelinde(ara);
	 				break;
	 			
	 		case(4):
	 				System.out.println("Hangi şıkkı doğru olan soruları görmek istiyorsunuz ? ");
	 				ara = veriGir.next().trim().toUpperCase();
	 				addremove.soruGosterCevapOzelinde(ara);
	 				break;	
	 	
	 		case(5):
	 				System.out.println("Kaç puanlık soruları görmek istiyorsunuz ? (0-10)");
	 				araInt = veriGir.nextInt();
	 				addremove.soruGosterPuanOzelinde(araInt);
	 				veriGir.nextLine();
	 				break;	
 				 
	 		case(6):
	 				System.out.println("Puan Sırasına Göre Listele");
	 				addremove.soruSiralaPuanaGore(); 
	 				break;	

	 		case(7):
	 				System.out.println("Hangi zorluk seviyesindeki soruları görmek istiyorsunuz ?\n(Kolay,Orta,Zor) ");
	 				ara = veriGir.next().trim();
	 				addremove.soruGosterZorlukOzelinde(ara);
	 				break;
	 		case(8):  break;
	 				
	 		default: 
	 				System.out.println("Geçersiz Seçim Yaptınız"); break;
			}
	}
}
