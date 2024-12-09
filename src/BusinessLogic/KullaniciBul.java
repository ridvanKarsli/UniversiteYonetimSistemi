package BusinessLogic;

import java.util.List;

import Abstraction.Readable;
import DataAccess.KullaniciVeriBul;
import Model.Kullanici;

public class KullaniciBul implements Readable<Kullanici> {

	Readable veriBul = KullaniciVeriBul.getInstance();

	@Override
	public List<Kullanici> hepsiniOku() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kullanici emailIleOku(String email) { 
		Kullanici kullanici = (Kullanici) veriBul.emailIleOku(email);
		return kullanici;
	}

	@Override
	public Kullanici idIleOku(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
