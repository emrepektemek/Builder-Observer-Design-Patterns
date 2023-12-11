package akillicihaz;

//import veritabani.Baglanti;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
	
	private double sicaklik;
	
	private InternetKullanicisiHesabi hesap;
	private ITelefonEkran telefon_ekran;
	private IAgArayuzu ag_arayuzu;
	private IAnaIslemPlatformu ana_islem_platformu;
	private IAkilliCihazBilgiSistemi bilgiSistemi;
	
	public SicaklikAlgilayici()
	{
		sicaklik=0;
	}
	
	public void sicaklikOku(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi,ITelefonEkran telefon_ekran,IAgArayuzu ag_arayuzu,IAnaIslemPlatformu ana_islem_platformu)
	{	
		
		this.hesap=hesap;
		this.bilgiSistemi=bilgiSistemi;
		this.telefon_ekran=telefon_ekran;
		this.ag_arayuzu=ag_arayuzu;
		this.ana_islem_platformu=ana_islem_platformu;
		
		
		ag_arayuzu.iletiAlgila();
		ag_arayuzu.iletiIlet();
		ana_islem_platformu.iletiAlgila();
		ana_islem_platformu.komutIlet();
		
		telefon_ekran.mesajGoruntule("Sicaklik Algilayicisi Ortamin Sicakligini Algiliyor");
		Araclar.bekle(1000);
		
		int sogutucuDurumu = bilgiSistemi.sogutucuDurumu(hesap.gethesapNo());//sogutucu kapaliysa ortamin sicakligi artacaktir , sogutucu aciksa ortamin sicakligi azalacaktir bu yuzden sogutucunun acik olup olmadigini bilmem gerekiyor
		
		sicaklik = bilgiSistemi.sicaklikGetir(hesap.gethesapNo());
		
		if(sogutucuDurumu==0) {
			telefon_ekran.mesajGoruntule("\nSogutucu Su An Calismiyor");
		}
		
		if(sogutucuDurumu==1) {
			telefon_ekran.mesajGoruntule("\nSogutucu Su An Calisiyor");
		}
		
		telefon_ekran.mesajGoruntule("\nOrtamin Eski Sicakligi :"+sicaklik+"\n");
		
		double sicaklik_degisimi = (Math.random()*(3-0))+(0);//0 ile 3 arasinda double turunden sayi uretir
		
		
		if(sogutucuDurumu==0&&sicaklik<30)//sogutucu kapalidir sicaklik ona gore artis gostericektir
		{
			sicaklik=sicaklik+sicaklik_degisimi;
		}
		else if(sogutucuDurumu==0&&sicaklik>29)
		{
			sicaklik=30;//odanin sicakliginin 30 yi gecmesini istemiyorum bu yuzden boyle bir kontrol yaptim yoksa sicaklik 50 gibi ucuk rakamlara kadar cikabilir bu da programin gercekligini yitirmesine sebep olur bu yuzden boyle bir kontrol yapmak istedim
		}
		else if(sogutucuDurumu==1&&sicaklik<13)//ucuk bir sayi olmamasi icin boyle bir kontrol yaptim
		{
			sicaklik=12;
		}
		else if(sogutucuDurumu==1&&sicaklik>12)//sogutucu aciktir sicaklik ona gore dusus gostericektir
		{
			sicaklik=sicaklik-sicaklik_degisimi;
		}
		
		//burada veri tabanina sicaklik guncellemesi yapacagim
		bilgiSistemi.sicaklikGuncelle(hesap.gethesapNo(),sicaklik);
		
		telefon_ekran.mesajGoruntule("Ortamin Sicakligi : "+sicaklik);
	}

}
