package akillicihaz;

public class InternetKullanicisiHesabi {
	
	private int hesapNo;
	private String kullaniciAdi;
	private String sifre;
	private InternetKullanicisi kullanici;
	
	private InternetKullanicisiHesabi(HesapBuilder builder) {
		this.hesapNo=builder.hesapNo;
		this.kullaniciAdi=builder.kullaniciAdi;
		this.sifre=builder.sifre;
		this.kullanici=builder.kullanici;
	}
	
	
	public String getkullaniciAdi()
	{
		return kullaniciAdi;
	}
	
	public String getsifre()
	{
		return sifre;
	}
		
	public int gethesapNo()
	{
		return hesapNo;
	}
	
	public String getad()
	{
		return kullanici.getad();
	}
	
	public String getsoyad()
	{
		return kullanici.getsoyad();
	}
	
	public String getcinsiyet()
	{
		return kullanici.getcinsiyet();
	}
	
	
	public void setkullaniciAdi(String kullaniciAdi)
	{
		this.kullaniciAdi=kullaniciAdi;
	}
	
	public void setsifre(String sifre)
	{
		this.sifre=sifre;
	}
	
	public void sethesapNo(int hesapNo)
	{
		this.hesapNo=hesapNo;
	}
	
	public void setad(String ad)
	{
		this.kullanici.setad(ad);
	}
	
	public void setsoyad(String soyad)
	{
		this.kullanici.setsoyad(soyad);
	}
	
	public void setcinsiyet(String cinsiyet)
	{
		this.kullanici.setcinsiyet(cinsiyet);
	}
	
	@Override
	public String toString() {
		return "Internet Kullanicisi Bilgileri\n"+"Ad :"+kullanici.getad()+"\nSoyad :"+kullanici.getsoyad()+ "\nHesap Numarasi :"+
				hesapNo+"\nKullanici Adi :"+kullaniciAdi+"\nSifre :" + sifre+"\nCinsiyet :"+getcinsiyet();
	}
	
	
	public static class HesapBuilder
	{
		
		private int hesapNo;
		private String kullaniciAdi;
		private String sifre;
		private InternetKullanicisi kullanici;
		
		public HesapBuilder(int hesapNo,String kullaniciAdi,String sifre) {
			
			this.hesapNo=hesapNo;
			this.kullaniciAdi=kullaniciAdi;
			this.sifre=sifre;
		}
		
		public HesapBuilder kullanici (String ad , String soyad , String cinsiyet) {
			
			this.kullanici= new InternetKullanicisi(ad ,soyad,cinsiyet);
			return this;
		}
		
		public InternetKullanicisiHesabi build() {
			
			return new InternetKullanicisiHesabi(this);
		}
		
		
	}
	
	
}
