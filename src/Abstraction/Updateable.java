package Abstraction;

public interface Updateable<T> {
	void ekle(T t);
	void guncelle(T t);
	void sil(int id);
}
