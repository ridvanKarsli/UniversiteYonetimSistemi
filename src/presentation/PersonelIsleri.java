package presentation;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Abstraction.Readable;
import BusinessLogic.FactoryBLL;
import Model.Kullanici;
import Model.Ogrenci;

public class PersonelIsleri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private List<Kullanici> kullanicilar;

	private Readable<Kullanici> bll = FactoryBLL.getOgrenciBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelIsleri frame = new PersonelIsleri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonelIsleri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(6, 167, 438, 82);
		contentPane.add(table);
	}
	
	private void verileriGoster() {
		kullanicilar = bll.hepsiniOku();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Id");
		model.addColumn("TC Kimlik no");
		model.addColumn("Ad");
		model.addColumn("Soyad");
		model.addColumn("E-Posta");
		model.addColumn("Okul No");

		// satırların veirlerini saklamak için
		Object[] tabloSatiri = new Object[6];

		int satirSayisi = ogrenciler.size();

		for (Ogrenci ogrenci : ogrenciler) {
			tabloSatiri[0] = ogrenci.getId();
			tabloSatiri[1] = ogrenci.getTcNo();
			tabloSatiri[2] = ogrenci.getAd();
			tabloSatiri[3] = ogrenci.getSoyad();
			tabloSatiri[4] = ogrenci.getEmail();
			tabloSatiri[5] = ogrenci.getOkulNo();
			
			model.addRow(tabloSatiri);
		}
		
		ogrenciTablosu.setModel(model);
	}

}
