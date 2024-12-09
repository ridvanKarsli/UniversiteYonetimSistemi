package BusinessLogic;

import Abstraction.Readable;
import Abstraction.Updateable;
import Model.Kullanici;
import Model.Ogrenci;

public class FactoryBLL {
	
	public static Readable<Kullanici> getKullaniciBul() {
		return new KullaniciBul();
	}
	
	public static Readable<Ogrenci> getOgrenciBLL(){
		return new OgrenciBLL();
	}
	
	public static Updateable<Ogrenci> getOgrenciBLLUpdateable(){
		return new OgrenciBLL();
	}
}
