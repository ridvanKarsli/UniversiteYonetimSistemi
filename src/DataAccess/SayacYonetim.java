package DataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Sayac {
	private SayacTuru sayacTuru;
	private long sayacDegeri;

	Sayac(SayacTuru sayacTuru, long sayacDegeri) {
		this.sayacTuru = sayacTuru;
		this.sayacDegeri = sayacDegeri;
	}

	public long getSayacDegeri() {
		return sayacDegeri;
	}

	public void setSayacDegeri(long sayacDegeri) {
		this.sayacDegeri = sayacDegeri;
	}

	public SayacTuru getSayacTuru() {
		return sayacTuru;
	}
}

enum SayacTuru {
	OGRENCI, EGITMEN, MEMUR, KULLANICI, DERS
}

final class SayacYonetim {

	private static final String SAYAC_DOSYA_ADI = "id_sayaclari.csv";
	
	
	//sibgleton design pattern begin
	private static SayacYonetim sayac;

	private SayacYonetim() {
	}

	static SayacYonetim getInstance() {

		if (sayac == null) {
			sayac = new SayacYonetim();
		}
		return sayac;
	}
	
	//sibgleton design pattern final
	long sonIdVer(SayacTuru sayacTuru) {
		long id = 0;

		File sayacDosyasi = new File(SAYAC_DOSYA_ADI);
		
		try {

			Scanner reader = new Scanner(sayacDosyasi);

			while (reader.hasNextLine()) {
				String satir = reader.nextLine();

				String[] veriler = satir.split(";");

				String strSayacTuru = veriler[0];
				String strId = veriler[1];

				if (SayacTuru.valueOf(strSayacTuru) == sayacTuru) {
					id = Long.valueOf(strId);
					idArttır(sayacTuru);
					break;
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return id;
	}

	private List<Sayac> sayacOku() {
		File idSayacDosyasi = new File(SAYAC_DOSYA_ADI);
		List<Sayac> liste = new ArrayList<>();

		try {

			Scanner reader = new Scanner(idSayacDosyasi);

			while (reader.hasNextLine()) {

				String satir = reader.nextLine();
				String[] veriler = satir.split(";");

				SayacTuru dosyaSayacTuru = SayacTuru.valueOf(veriler[0]);
				long id = Long.valueOf(veriler[1]);

				Sayac sayac = new Sayac(dosyaSayacTuru, id);

				liste.add(sayac);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return liste;

	}

	private void idArttır(SayacTuru sayacTuru) {

		List<Sayac> liste = sayacOku();

		for (Sayac sayac : liste) {
			if (sayacTuru == sayac.getSayacTuru()) {
				sayac.setSayacDegeri(sayac.getSayacDegeri() + 1);
			}
		}

		try {

			FileWriter dosyaYazici = new FileWriter(SAYAC_DOSYA_ADI);
 
			for (Sayac sayac : liste) {
				dosyaYazici.write(sayac.getSayacTuru() + ";" + sayac.getSayacDegeri());
				dosyaYazici.write("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

// 17.2.0

/*
 * final extends edilemez enum class interface public olacaksa dosya ismi ile
 * aynı olmalı yoksa hata verir
 */