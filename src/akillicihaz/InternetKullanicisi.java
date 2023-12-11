package akillicihaz;

public class InternetKullanicisi {

	private String ad;
	private String soyad;
	private String cinsiyet;
	
	public InternetKullanicisi(String ad,String soyad,String cinsiyet)
	{
		this.ad=ad;
		this.soyad=soyad;
		this.cinsiyet=cinsiyet;
	}
	
	public String getad()
	{
		return ad;
	}
	
	public String getsoyad()
	{
		return soyad;
	}
	
	public String getcinsiyet()
	{
		return cinsiyet;
	}
	
	public void setad(String ad)
	{
		this.ad=ad;
	}
	
	public void setsoyad(String soyad)
	{
		this.soyad=soyad;
	}
	
	public void setcinsiyet(String cinsiyet)
	{
		this.cinsiyet=cinsiyet;
	}
}
