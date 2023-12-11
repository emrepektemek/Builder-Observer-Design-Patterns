package akillicihaz;

public class AkilliCihaz {
	
	private ITelefonEkran telefon_ekran;
	private ITelefonKlavye telefon_klavye;
	private IEyleyici eyleyici;
	private ISicaklikAlgilayici sicaklik_algilayici;	
	private IAkilliCihazBilgiSistemi bilgiSistemi;
	private InternetKullanicisiHesabi hesap;
	private IAgArayuzu ag_arayuzu;
	private IAnaIslemPlatformu ana_islem_platformu;
	
	private static final int SOGUTUCU_AC = 1;
	private static final int SOGUTUCU_KAPAT = 2;
	private static final int SICAKLIK_GOSTER = 3;
	private static final int CIKIS = 4;
	
	public AkilliCihaz()
	{
		 telefon_ekran=new TelefonEkran();
		 telefon_klavye = new TelefonKlavye();
		 eyleyici = new Eyleyici();
		 sicaklik_algilayici = new SicaklikAlgilayici();
		 ag_arayuzu=new AgArayuzu();
		 ana_islem_platformu=new AnaIslemPlatformu();
	}
		
	public void basla()
	{		
		 Subscriber1 s1 = new Subscriber1();
	     Subscriber2 s2 = new Subscriber2();

	     Publisher p = new Publisher();

	     p.attach(s1);
	     p.attach(s2);
	     
		//program calistigi surece hayatini surduren bir hesap nesnesi
	     hesap=new InternetKullanicisiHesabi.HesapBuilder(-1," ", " ")
	    		 .kullanici(" "," "," ")
	    		 .build();
		bilgiSistemi = new AkilliCihazBilgiSistemi();
		hesapIslemleri(hesap,bilgiSistemi);
		islemSecimi(hesap,bilgiSistemi,p);			
	}
	
	private void hesapIslemleri(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi)//hesaba giris islemleri
	{
		int secim=0;
		int hatasayisi=0;
		do
		{
			if(secim==0)
			{
				telefon_ekran.mesajGoruntule("Lutfen kullanici adinizi giriniz");
				String kullanici_adi=telefon_klavye.veriAl(2);//klavyeden girdigimiz deger bu degiskene atandi
				telefon_ekran.mesajGoruntule("Lutfen sifrenizi giriniz");
				String sifre=telefon_klavye.veriAl(2);//klavyeden girdigimiz deger bu degiskene atandi
			
				int hesapVarmi=bilgiSistemi.kullaniciDogrula(hesap, kullanici_adi, sifre);
				if(hesapVarmi==1)
				{
					telefon_ekran.mesajGoruntule("Hesap Dogrulandi");	
					if(hesap.getcinsiyet().equals("Kadin")) {
						telefon_ekran.mesajGoruntule(hesap.getad()+" Hanim Hos Geldiniz");	
					}
					
					if(hesap.getcinsiyet().equals("Erkek")) {
						telefon_ekran.mesajGoruntule(hesap.getad()+" Bey Hos Geldiniz");	
					}
					
					break;
				}
				else if (hesapVarmi==0)
				{
					 Araclar.bekle(2000);
					telefon_ekran.mesajGoruntule("Hesap Dogrulanamadi Kullanici Adi Veya Sifre Yanlis");
					hatasayisi++;
					if(hatasayisi%3==0)
					{
						telefon_ekran.mesajGoruntule("Hesaba "+ hatasayisi+ " kere hatali girdiniz lutfen " +(hatasayisi/3)*10+" saniye bekleyiniz");
						Araclar.bekle(10000*(hatasayisi/3));
						telefon_ekran.mesajGoruntule("Hesaba tekrardan girmeyi denemek icin 0 , uygulamayi kapatmak icin herhangi bir sayiya basiniz");
						secim= Integer.parseInt(telefon_klavye.veriAl(1));
					}
					else
					{
						 Araclar.bekle(2000);
						telefon_ekran.mesajGoruntule("Hesaba tekrardan girmeyi denemek icin 0 , uygulamayi kapatmak icin herhangi bir sayiya basiniz");
						secim= Integer.parseInt(telefon_klavye.veriAl(1));//veri al parametresine 1 girersen veri almak icin sadece sayi degerlerini kabul eder string kabul etmez
					}
					
				}
			}
			
			if(secim!=0)
			{
				telefon_ekran.mesajGoruntule("Telefon Uygulamasi Kapatiliyor");
				Araclar.bekle(2000);
				telefon_ekran.mesajGoruntule("Telefon Uygulamasi Kapatildi");
				System.exit(0);
			}
			
		}while(secim!=1);
			
	}
	
	
	private String anaMenuyuGoster()
	{
		telefon_ekran.mesajGoruntule("---------------------------------------------------");
		telefon_ekran.mesajGoruntule("Ana Menu");
		telefon_ekran.mesajGoruntule("1 Sogutucuyu Calistir");
		telefon_ekran.mesajGoruntule("2 Sogutucuyu Kapat");
		telefon_ekran.mesajGoruntule("3 Sicaklik Goruntule");
		telefon_ekran.mesajGoruntule("4 Cikis");
		telefon_ekran.mesajGoruntule("Seciminiz");
		telefon_ekran.mesajGoruntule("---------------------------------------------------");
		return telefon_klavye.veriAl(1);
	}
	
	private void islemSecimi(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi,ISubject p)
	{
		int secim=0;	
		do
		{
			secim=Integer.parseInt(anaMenuyuGoster());//anaMenuyuGoster string dondurdugu icin burada int donusturmem gerekiyor
			switch (secim) {
			case SOGUTUCU_AC:
				eyleyici.sogutucuyuAc(hesap,bilgiSistemi,telefon_ekran,ag_arayuzu,ana_islem_platformu,p);	
				break;
				
			case SOGUTUCU_KAPAT:
				eyleyici.sogutucuyuKapat(hesap,bilgiSistemi,telefon_ekran,ag_arayuzu,ana_islem_platformu,p);	
				break;

			case SICAKLIK_GOSTER:
				sicaklik_algilayici.sicaklikOku(hesap,bilgiSistemi,telefon_ekran,ag_arayuzu,ana_islem_platformu);
				break;

			case CIKIS:
				telefon_ekran.mesajGoruntule("Telefon Uygulamasi Kapatiliyor");
				Araclar.bekle(2000);
				telefon_ekran.mesajGoruntule("Telefon Uygulamasi Kapatildi");
				System.exit(0);
				break;
				
			default:
				telefon_ekran.mesajGoruntule("1-4 arasinda bir rakam girmelisiniz");
		}			
		}while(secim!=4);
		
	}
	

}
