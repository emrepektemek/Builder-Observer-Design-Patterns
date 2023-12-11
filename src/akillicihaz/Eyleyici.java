package akillicihaz;

//import veritabani.Baglanti;

public class Eyleyici implements IEyleyici {
	private int sogutucu_durumu;//sogutucu durumu 0 ise sogutucu kapalidir , sogutucu durumu 1 ise sogutucu calisiyordur
	
	private InternetKullanicisiHesabi hesap;
	private ITelefonEkran telefon_ekran;
	private IAgArayuzu ag_arayuzu;
	private IAnaIslemPlatformu ana_islem_platformu;
	private IAkilliCihazBilgiSistemi bilgiSistemi;
	ISubject publisher;
	
	public Eyleyici()
	{	
		this.sogutucu_durumu=0;
		
	}
	
	public void sogutucuyuAc(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi,ITelefonEkran telefon_ekran,IAgArayuzu ag_arayuzu,IAnaIslemPlatformu ana_islem_platformu,ISubject publisher)
	{
		this.hesap=hesap;
		this.bilgiSistemi=bilgiSistemi;
		this.telefon_ekran=telefon_ekran;
		this.ag_arayuzu=ag_arayuzu;
		this.ana_islem_platformu=ana_islem_platformu;
		this.publisher=publisher;
		
		ag_arayuzu.iletiAlgila();
		ag_arayuzu.iletiIlet();
		ana_islem_platformu.iletiAlgila();
		ana_islem_platformu.komutIlet();
				
		sogutucu_durumu = bilgiSistemi.sogutucuDurumu(hesap.gethesapNo());
		
		if(sogutucu_durumu==0)
		{
			Araclar.bekle(2000);
			telefon_ekran.mesajGoruntule("Sogutucu Aciliyor");
			Araclar.bekle(3000);
			telefon_ekran.mesajGoruntule("Eyleyici Sogutucuyu Acti");
			//sogutucunun son durumunu guncelledim su an calistigi icin veritabaninda ilgili degeri 1 yaptim
			bilgiSistemi.sogutucuDurumGuncelle(hesap.gethesapNo(),1);
			publisher.notify("(hesapNo :"+hesap.gethesapNo()+") sogutucunuz acildi");
		}
		else
		{
			Araclar.bekle(3000);
			telefon_ekran.mesajGoruntule("Sogutucu Zaten Aciktir Isleminiz Iptal Edilmistir");
		}
		
		
	}
	
	public void sogutucuyuKapat(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi,ITelefonEkran telefon_ekran,IAgArayuzu ag_arayuzu,IAnaIslemPlatformu ana_islem_platformu,ISubject publisher)
	{
		this.hesap=hesap;
		this.bilgiSistemi=bilgiSistemi;
		this.telefon_ekran=telefon_ekran;
		this.ag_arayuzu=ag_arayuzu;
		this.ana_islem_platformu=ana_islem_platformu;
		this.publisher=publisher;
		
		ag_arayuzu.iletiAlgila();
		ag_arayuzu.iletiIlet();
		ana_islem_platformu.iletiAlgila();
		ana_islem_platformu.komutIlet();
		 
		sogutucu_durumu=bilgiSistemi.sogutucuDurumu(hesap.gethesapNo());
		if(sogutucu_durumu==1)
		{
			Araclar.bekle(2000);
			telefon_ekran.mesajGoruntule("Sogutucu Kapatiliyor");
			Araclar.bekle(3000);
			telefon_ekran.mesajGoruntule("Eyleyici Sogutucuyu Kapatti");
			bilgiSistemi.sogutucuDurumGuncelle(hesap.gethesapNo(),0);
			publisher.notify("(hesapNo :"+hesap.gethesapNo()+") sogutucunuz kapatildi");
			Araclar.bekle(3000);
		}
		else
		{
			Araclar.bekle(3000);
			telefon_ekran.mesajGoruntule("Sogutucu Zaten Kapalidir Isleminiz Iptal Edilmistir");
		}
	}

}
