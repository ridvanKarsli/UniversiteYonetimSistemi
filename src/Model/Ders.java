package Model;

public class Ders {
	
	private int id;
	private String ad;
	private byte sinifNo;
	private byte kredi;
	private boolean devamZorunlulugu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public byte getSinifNo() {
		return sinifNo;
	}
	public void setSinifNo(byte sinifNo) {
		this.sinifNo = sinifNo;
	}
	public byte getKredi() {
		return kredi;
	}
	public void setKredi(byte kredi) {
		this.kredi = kredi;
	}
	public boolean isDevamZorunluluğu() {
		return devamZorunlulugu;
	}
	public void setDevamZorunluluğu(boolean devamZorunluluğu) {
		this.devamZorunlulugu = devamZorunluluğu;
	}
	
	
	
}
