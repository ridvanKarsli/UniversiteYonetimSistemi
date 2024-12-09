package Model;

import java.time.LocalDate;
import java.util.List;

public class Kullanici {
	
	private String kullaniciAdi;
	private long sifre;
	private boolean aktifMi;
	private LocalDate sonGirisZamani;
	private List<Rol> rol; //birden fazla rol olabilir
	
	
	//sibgleton tek bir nesne oluşturma
	//1.adım setleri kaldır
	
	private static Kullanici kullanici; //2.adım
	
	private Kullanici() { //3.adım
		
	}
	
	public static Kullanici getInstance(String kullaniciAdi, long sifre, boolean aktifMi, LocalDate sonGirisZamani, List<Rol> rol) { //4.adım
		if (kullanici == null) {
			kullanici = new Kullanici();
			
			kullanici.aktifMi = aktifMi;
			kullanici.kullaniciAdi = kullaniciAdi;
			kullanici.sifre = sifre;
			kullanici.rol = rol;
			kullanici.sonGirisZamani = sonGirisZamani;
		}
		
		return kullanici;
	}
	
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
//	public void setKullaniciAdi(String kullaniciAdi) {
//		this.kullaniciAdi = kullaniciAdi;
//	}
	public long getSifre() {
		return sifre;
	}
//	public void setSifre(long sifre) {
//		this.sifre = sifre;
//	}
	public boolean isAktifMi() {
		return aktifMi;
	}
//	public void setAktifMi(boolean aktifMi) {
//		this.aktifMi = aktifMi;
//	}
	public LocalDate getSonGirisZamani() {
		return sonGirisZamani;
	}
//	public void setSonGirisZamani(LocalDate sonGirisZamani) {
//		this.sonGirisZamani = sonGirisZamani;
//	}
	public List<Rol> getRol() {
		return rol;
	}
//	public void setRol(List<Rol> rol) {
//		this.rol = rol;
//	}
	
	
	
	
	
}
