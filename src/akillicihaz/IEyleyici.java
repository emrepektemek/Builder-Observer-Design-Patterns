package akillicihaz;

public interface IEyleyici {
	
	public void sogutucuyuKapat(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi,ITelefonEkran telefon_ekran,IAgArayuzu ag_arayuzu,IAnaIslemPlatformu ana_islem_platformu,ISubject publisher);
	public void sogutucuyuAc(InternetKullanicisiHesabi hesap,IAkilliCihazBilgiSistemi bilgiSistemi,ITelefonEkran telefon_ekran,IAgArayuzu ag_arayuzu,IAnaIslemPlatformu ana_islem_platformu,ISubject publisher);
}
