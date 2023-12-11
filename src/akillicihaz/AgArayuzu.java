package akillicihaz;

public class AgArayuzu implements IAgArayuzu {
	
	private ITelefonEkran telefon_ekran;
	
	public void iletiAlgila()
	{
		telefon_ekran=new TelefonEkran();
		telefon_ekran.mesajGoruntule("Isleminiz Algilaniyor (Ag Ara Yuzu)");
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Isleminiz Algilandi");
	}
	public void iletiIlet()
	{
		telefon_ekran=new TelefonEkran();
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Isleminiz Iletiliyor");
		Araclar.bekle(1000);
		telefon_ekran.mesajGoruntule("Isleminiz Iletildi");
	}

}
