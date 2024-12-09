package DataAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Abstraction.Readable;
import Abstraction.Updateable;
import Model.Ogrenci;

public class OgrenciVeriYonetimi implements Readable<Ogrenci>, Updateable<Ogrenci> {

	public static final String OGRENCILER_DOSYA_ADI = "Ogrenciler.csv";

	private static int idCounter = 11;

	// singleton design pattern - begin
	private static OgrenciVeriYonetimi dal;

	private OgrenciVeriYonetimi() {

	}

	public static OgrenciVeriYonetimi getInstance() {

		if (dal == null) {
			dal = new OgrenciVeriYonetimi();
		}
		return dal;
	}
	// singleton design pattern - finish

	@Override
	public List<Ogrenci> hepsiniOku() {

		File ogrencilerDosyasi = new File(OGRENCILER_DOSYA_ADI);
		List<Ogrenci> liste = new ArrayList<Ogrenci>();

		try {
			Scanner reader = new Scanner(ogrencilerDosyasi);

			while (reader.hasNextLine()) {
				String satir = reader.nextLine();

				String[] veriler = satir.split(";");

				Ogrenci ogrenci = new Ogrenci();

				ogrenci.setId(Integer.valueOf(veriler[0]));
				ogrenci.setTcNo(Long.valueOf(veriler[1]));
				ogrenci.setAd(veriler[2]);
				ogrenci.setSoyad(veriler[3]);
				ogrenci.setEmail(veriler[4]);
				ogrenci.setOkulNo(Integer.valueOf(veriler[5]));

				liste.add(ogrenci);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return liste;
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
		SayacYonetim sayac = SayacYonetim.getInstance();
		
		try {

			FileWriter dosyaYazici = new FileWriter(OGRENCILER_DOSYA_ADI, true);
			
			String csvOgrenci =  /*sayac.sonIdVer(SayacTuru.OGRENCI)*/++idCounter + ";" + ogrenci.getTcNo() + ";" + ogrenci.getAd() + ";" + ogrenci.getSoyad()
					+ ";" + ogrenci.getEmail() + ";" + ogrenci.getOkulNo();

			dosyaYazici.write("\n");
			dosyaYazici.write(csvOgrenci);
			dosyaYazici.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void guncelle(Ogrenci guncellenecekOgrenci) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub

		List<Ogrenci> liste = hepsiniOku();

		for (Ogrenci ogrenci : liste) {
			
			if (ogrenci.getId() == guncellenecekOgrenci.getId()) {
				//döngü içerisinde referans aktarımı yapamazsın
				ogrenci.setAd(guncellenecekOgrenci.getAd());
				ogrenci.setSoyad(guncellenecekOgrenci.getSoyad());
				ogrenci.setTcNo(guncellenecekOgrenci.getTcNo());
				ogrenci.setEmail(guncellenecekOgrenci.getEmail());
				ogrenci.setOkulNo(guncellenecekOgrenci.getOkulNo());
				break; 
			}
			
		}

		try {

			FileWriter dosyaYazici = new FileWriter(OGRENCILER_DOSYA_ADI);
 
			for (Ogrenci ogrenci : liste) {
				
				String csvOgrenci =  ogrenci.getId() + ";" + ogrenci.getTcNo() + ";" + ogrenci.getAd() + ";" + ogrenci.getSoyad()
						+ ";" + ogrenci.getEmail() + ";" + ogrenci.getOkulNo();
				
				dosyaYazici.write(csvOgrenci);
				dosyaYazici.write("\n");
			}
			dosyaYazici.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void sil(int id) {
		// TODO Auto-generated method stub

		List<Ogrenci> liste = hepsiniOku();

		for (Ogrenci ogrenci : liste) {
			
			if (ogrenci.getId() == id) {
				liste.remove(ogrenci);
				break; 
			}
			
		}

		try {

			FileWriter dosyaYazici = new FileWriter(OGRENCILER_DOSYA_ADI);
 
			for (Ogrenci ogrenci : liste) {
				
				String csvOgrenci =  ogrenci.getId() + ";" + ogrenci.getTcNo() + ";" + ogrenci.getAd() + ";" + ogrenci.getSoyad()
						+ ";" + ogrenci.getEmail() + ";" + ogrenci.getOkulNo();
				
				dosyaYazici.write(csvOgrenci);
				dosyaYazici.write("\n");
			}
			dosyaYazici.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
