package akillicihaz;

import veritabani.PostreSQLSurucu;

public class AkilliCihazBilgiSistemi implements IAkilliCihazBilgiSistemi{
	
	private PostreSQLSurucu veritabani;
	
	public AkilliCihazBilgiSistemi() {
		
		veritabani=new PostreSQLSurucu();
	}
	
	public int kullaniciDogrula(InternetKullanicisiHesabi hesap,String kullaniciAdi,String sifre){
	
		return veritabani.kullaniciDogrula(hesap, kullaniciAdi, sifre);
	}
	
	public void sogutucuDurumGuncelle(int hesapNo, int durum) {
		
		veritabani.sogutucuDurumGuncelle(hesapNo, durum);
	}
	
	public int sogutucuDurumu(int hesapNo){
		
		return veritabani.sogutucuDurumu(hesapNo);
	}
	
	public double sicaklikGetir(int hesapNo) {
		
		return veritabani.sicaklikGetir(hesapNo);
	}
	
	public void sicaklikGuncelle(int hesapNo,double sicaklik) {
		
		veritabani.sicaklikGuncelle(hesapNo,sicaklik);
	}

}
