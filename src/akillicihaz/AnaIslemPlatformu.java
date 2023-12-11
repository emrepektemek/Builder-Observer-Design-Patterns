package akillicihaz;

public class AnaIslemPlatformu implements IAnaIslemPlatformu {
	
	private ITelefonEkran telefon_ekran;
	
	public void iletiAlgila()
	{
		telefon_ekran=new TelefonEkran();
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Isleminiz Algilaniyor (Ana Islem Platformu)");
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Isleminiz Algilandi");
	}
	public void komutIlet()
	{
		telefon_ekran=new TelefonEkran();
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Komutunuz Iletiliyor");
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Komutunuz Iletildi");
		Araclar.bekle(1000);
		
	}

}
