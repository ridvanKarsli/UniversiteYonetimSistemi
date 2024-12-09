package BusinessLogic;
import java.util.List;

import Abstraction.Readable;
import Abstraction.Updateable;
import DataAccess.OgrenciVeriYonetimi;
import Model.Ogrenci;


public class OgrenciBLL implements Readable<Ogrenci>, Updateable<Ogrenci>{

	Readable<Ogrenci> dal = OgrenciVeriYonetimi.getInstance();
	Updateable<Ogrenci> update = OgrenciVeriYonetimi.getInstance();
	
	@Override
	public List<Ogrenci> hepsiniOku() {
		// TODO Auto-generated method stub
		return dal.hepsiniOku();
	}

	@Override
	public Ogrenci emailIleOku(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ogrenci idIleOku(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ekle(Ogrenci ogrenci) {
		// TODO Auto-generated method stub
		update.ekle(ogrenci);
		
	}

	@Override
	public void guncelle(Ogrenci t) {
		// TODO Auto-generated method stub
		update.guncelle(t);
		
	}

	@Override
	public void sil(int id) {
		// TODO Auto-generated method stub
		update.sil(id);
		
	}

}
