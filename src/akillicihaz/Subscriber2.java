package akillicihaz;

public class Subscriber2 implements IObserver {
	@Override
    public void update(String mesaj) {
        System.out.println("Telefon uygulamaniza gonderilen mesaj--->" + mesaj);
    }
}
