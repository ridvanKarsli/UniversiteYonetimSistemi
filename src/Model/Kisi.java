package Model;

public abstract  class Kisi {
	
	//bu sınıftan nesne oluşturulmasını istemiyorsam abstract
	//bu sınıftan sınıf oluşturulmasını istemiyorsam final
	
	private int id;
	private long tcNo;
	private String ad;
	private String soyad; 
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public long getTcNo() {
		return tcNo;
	}
	public void setTcNo(long tcNo) {
		this.tcNo = tcNo;
	}
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
