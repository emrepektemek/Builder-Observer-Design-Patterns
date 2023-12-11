package akillicihaz;

public class Subscriber1 implements IObserver {
	@Override
    public void update(String mesaj) {
        System.out.println("E-postaniza gonderilen mesaj--->" + mesaj);
    }
}
