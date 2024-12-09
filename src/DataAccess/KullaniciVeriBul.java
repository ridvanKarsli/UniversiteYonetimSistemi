package DataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Abstraction.Readable;
import Model.Kullanici;
import Model.Memur;
import Model.Rol;

public class KullaniciVeriBul implements Readable<Kullanici> {

	public static final String KULLANICILAR_DOSYA_ADI = "Kullanicilar.csv";
	/*
	 * single design pattern : bir sınıfın tek bir instance veya nesnesi oluşması
	 * işinizi görüyorsa veya bir sınıftan tek bir nesne oluşturulmasını mecbur
	 * kılmak istiyorsam
	 * 
	 * Singleton design pattern 1.adım sınıfın kendi adıyla bir değişken oluştur
	 * 2.sınıfın default constructor methodu private yap ! bunu yaptıktan sonra
	 * başka bir constructor yaoılamaz. 3.static olarak yazılan bir instance
	 * methoduyla sadece bir nesne oluşturulur yap
	 */
	private static KullaniciVeriBul kullaniciVeriBul;
	private static final String PERSONELLER_DOSYA_ADI = "Kullanicilar.csv"; 

	private KullaniciVeriBul() {

	}

	public static KullaniciVeriBul getInstance() {
		if (kullaniciVeriBul == null) {
			kullaniciVeriBul = new KullaniciVeriBul();
		}
		return kullaniciVeriBul;
	}

	@Override
	public List<Kullanici> hepsiniOku() {


		File personelDosyasi = new File(PERSONELLER_DOSYA_ADI);
		List<Kullanici> liste = new ArrayList<>();

		try {
			Scanner reader = new Scanner(personelDosyasi);

			while (reader.hasNextLine()) {
				String satir = reader.nextLine();

				String[] veriler = satir.split(";");

				Memur memur = new Memur();

				liste.add(ogrenci);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return liste;
		
	}

	@Override
	public Kullanici emailIleOku(String email) {

		File personellerDosyasi = new File(KULLANICILAR_DOSYA_ADI);

		Kullanici arananKullanici = null;

		try {
			Scanner reader = new Scanner(personellerDosyasi);
			while (reader.hasNextLine()) {

				String satir = reader.nextLine();
				String[] veriler = satir.split(";");

				if (email.equals(veriler[0])) {

					List<Rol> roller = new ArrayList<>();
					String rol = veriler[2];

					roller.add(Rol.valueOf(rol));
					
					arananKullanici = Kullanici.getInstance(email, Long.valueOf(veriler[1]), true, null, roller);

					break;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return arananKullanici;

	}

	@Override
	public Kullanici idIleOku(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
