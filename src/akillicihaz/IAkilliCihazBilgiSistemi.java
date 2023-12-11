package akillicihaz;

public interface IAkilliCihazBilgiSistemi {
	
	public int kullaniciDogrula(InternetKullanicisiHesabi hesap,String kullaniciAdi,String sifre);
	public void sogutucuDurumGuncelle(int hesapNo, int durum);
	public int sogutucuDurumu(int hesapNo);
	public double sicaklikGetir(int hesapNo);
	public void sicaklikGuncelle(int hesapNo,double sicaklik);
}
