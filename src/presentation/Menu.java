package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Kullanici;
import Model.Rol;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Kullanici kullanici;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param kullanici
	 */
	public Menu(Kullanici kullanici) {
		this.kullanici = kullanici; //constructor dışındaki methodlarda kullanabilmek için
		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOgrenciIsleri = new JButton("Ogrenci isleri");

		btnOgrenciIsleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ogrenciIsleriPenceresiAc();
				close();
			}
		});
		btnOgrenciIsleri.setBounds(78, 77, 117, 29);
		btnOgrenciIsleri.setVisible(false);
		contentPane.add(btnOgrenciIsleri);
		
		JButton btnPersonelIsler = new JButton("Personel işleri");
		btnPersonelIsler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personelIsleriPenceresiAc();
			}
		});
		btnPersonelIsler.setBounds(78, 118, 117, 29);
		btnPersonelIsler.setVisible(false);
		contentPane.add(btnPersonelIsler);
		
		JButton btnDersIsleri = new JButton("Ders işleri");
		btnDersIsleri.setBounds(78, 159, 117, 29);
		btnDersIsleri.setVisible(false);
		contentPane.add(btnDersIsleri);

		List<Rol> kullaniciRolleri = kullanici.getRol();

		if (kullaniciRolleri.contains(Rol.MEMUR) || kullaniciRolleri.contains(Rol.ADMIN)) {
			btnOgrenciIsleri.setVisible(true);
		}
		
		if (kullaniciRolleri.contains(Rol.ADMIN)) {
			btnDersIsleri.setVisible(true);
			btnPersonelIsler.setVisible(true);
		}
		
		if (kullaniciRolleri.contains(Rol.EGITMEN)) {
			btnDersIsleri.setVisible(true);
		}
		
		
		
	}

	private void ogrenciIsleriPenceresiAc() {
		OgrenciIsleri ogrenciIsleri = new OgrenciIsleri(this);
		ogrenciIsleri.setVisible(true);
	}
	
	private void personelIsleriPenceresiAc() {
		PersonelIsleri personelIsleri = new PersonelIsleri();
		personelIsleri.setVisible(true);
	}

	private void close() {
		this.setVisible(false);
	}
}
