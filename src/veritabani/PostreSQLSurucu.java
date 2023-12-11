package veritabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import akillicihaz.Araclar;
import akillicihaz.InternetKullanicisiHesabi;

public class PostreSQLSurucu {

	
	public int kullaniciDogrula(InternetKullanicisiHesabi hesap,String kullaniciAdi,String sifre) {
		//InternetKullanicisiHesabi hesap =null;

        System.out.println("Hesap Dogrulama Islemi Baslatildi");
        Araclar.bekle(2000);
        int durum = 0 ;
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
                    "postgres", "AsD123321001");
            if (conn != null) {
                System.out.println("Veritabanina Baglandi Hesap Sorgulaniyor");
                Araclar.bekle(3000);
                String sql= "SELECT * FROM \"public\".\"Hesap\"";
               
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
              
                while (rs.next()){
                	int hesapno=rs.getInt("hesapNo");
                	String kullaniadi = rs.getString("kullaniciAdi");
                	String oksifre = rs.getString("sifre");
                	String ad = rs.getString("ad");
                	String soyad = rs.getString("soyad");
                	String cinsiyet = rs.getString("cinsiyet");
                	  
                	if (kullaniadi.equals(kullaniciAdi) && oksifre.equals(sifre)) {//girilen deger ile veritabanindan cektigim deger uyusuyorsa boyle bir hesap veritabaninda bulunuyordur 
                		durum = 1;
                		hesap.sethesapNo(hesapno);
                		hesap.setkullaniciAdi(kullaniciAdi);
                		hesap.setsifre(sifre);
                		hesap.setad(ad);
                		hesap.setsoyad(soyad);
                		hesap.setcinsiyet(cinsiyet);
                		break;
                	}
                }               
                rs.close();
                stmt.close();
            }
            else {
                System.out.println("Veritabanina Baglanamadi");
        	} 

            conn.close();
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        if (durum ==1)//girilen hesap veritabaninda varmis
        {
        	return durum;
        }
        else//girilen hesap veritabaninda yokmuþ
        {
        	return durum; //durum burada 0 degerindedir
        }
    }
	public void sogutucuDurumGuncelle(int hesapNo, int durum) {
		 try
	        {
	            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
	                    "postgres", "AsD123321001");
	            if (conn != null) {  
	                String sql= "Update \"public\".\"Sogutucu\" Set \"sogutucuDurumu\" = " + durum + " where \"Sogutucu\".\"hesapNo\"="+ hesapNo;	              
	                Statement stmt = conn.createStatement();
	                int rs = stmt.executeUpdate(sql);  	         
	                stmt.close();	               
	               // Araclar.bekle(2000);
	                //System.out.println("Sogutucunun Durumu Guncellenmistir");
	            }
	            else {
	                System.out.println("Veritabanina Baglanamadi");
	        	} 

	            
	            conn.close();
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	public int sogutucuDurumu(int hesapNo)
	{		
	        int durum = 0 ;
	        try
	        {
	            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
	                    "postgres", "AsD123321001");
	            if (conn != null) {
	               
	                String sql= "SELECT * FROM \"public\".\"Sogutucu\"";
	               
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(sql);	              
	                while (rs.next()){
	                	
	                	int hesapnumarasi = rs.getInt("hesapNo");
	                	int durumne=rs.getInt("sogutucuDurumu");
	                	if (hesapnumarasi==hesapNo) {//baslattaki hesap nesnesinin hesanosu ile veritabanindaki hesap numarasi eslesiyorsa asagidaki islemleri yapacagiz	                		                		
	                		durum = durumne;
	                		break;
	                	}

	                }               
	                rs.close();
	                stmt.close();
	            }
	            else {
	                System.out.println("Veritabanina Baglanamadi");
	        	} 

	            conn.close();
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	       return durum;
	}
	
	public double sicaklikGetir(int hesapNo)
	{
		 double sicaklik = 0;
	        try
	        {
	            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
	                    "postgres", "AsD123321001");
	            if (conn != null) { 
	               
	                String sql= "SELECT * FROM \"public\".\"Sogutucu\"";
	               
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(sql);	              
	                while (rs.next()){
	                	
	                	int hesapnumarasi = rs.getInt("hesapNo");	                
	                	if (hesapnumarasi==hesapNo) {//baslattaki hesap nesnesinin hesanosu ile veritabanindaki hesap numarasi eslesiyorsa asagidaki islemleri yapacagiz	                		
	                		sicaklik=rs.getDouble("sicaklik");	     
	                		break;
	                	}

	                }               
	                rs.close();
	                stmt.close();
	            }
	            else {
	                System.out.println("Veritabanina Baglanamadi");
	        	} 

	            conn.close();
	            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	       return sicaklik;
	}
	
	public void sicaklikGuncelle(int hesapNo,double sicaklik)
	{
		try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
                    "postgres", "AsD123321001");
            if (conn != null) {  
                String sql= "Update \"public\".\"Sogutucu\" Set \"sicaklik\" = " + sicaklik + " where \"Sogutucu\".\"hesapNo\"="+ hesapNo;	              
                Statement stmt = conn.createStatement();
                double rs = stmt.executeUpdate(sql);  	         
                stmt.close();
                conn.close();
                
                Araclar.bekle(2000);
            }
            else {
                System.out.println("Veritabanina Baglanamadi");
        	} 

            
            conn.close();
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
