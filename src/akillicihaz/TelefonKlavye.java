package akillicihaz;

import java.util.Scanner;

public class TelefonKlavye implements ITelefonKlavye{
	
	public String veriAl(int giristuru)
	{
		 Scanner input=new Scanner(System.in); 
		 String number;
		 if (giristuru ==1) {//giris turu 1 ise sadece sayi degerleri kabul eder
			 
			 while (!input.hasNextInt())
			 {
				 System.out.println("Girilen deger sayi degildir lutfen isleme devam edebilmek icin sayi bir deger giriniz");
				 input.nextLine();
			 }
			 
			  number = String.valueOf(input.nextInt());
		 }
		 else {
			 while (!input.hasNext())
			 {
				 System.out.println("Girilen deger string degildir");
				 input.nextLine();
			 }
			 
			  number= input.next();
		 }
		 
	   return number;  
	}

}
