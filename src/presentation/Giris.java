package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Abstraction.Readable;
import BusinessLogic.FactoryBLL;
import Model.Kullanici;

public class Giris extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtKullaniciAdi;
	private JPasswordField txtSifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris frame = new Giris();
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
	public Giris() {
		
		Readable<Kullanici> bul = FactoryBLL.getKullaniciBul();
		 
		setTitle("GİRİŞ EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullanıcı adı :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 31, 122, 19);
		contentPane.add(lblNewLabel);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(184, 28, 231, 19);
		contentPane.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		
		JLabel lblSifre = new JLabel("Şifre :");
		lblSifre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSifre.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblSifre.setBounds(50, 62, 122, 19);
		contentPane.add(lblSifre);
		
		JButton btnGirisYap = new JButton("Giriş yap");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//button clicked
				String kullaniciAdi = txtKullaniciAdi.getText();
				String sifre = txtSifre.getText();
		
				Kullanici kullanici = bul.emailIleOku(kullaniciAdi);		
				
				 
				if (kullanici != null && kullanici.getSifre() == Long.valueOf(sifre)) {
					JOptionPane.showMessageDialog(btnGirisYap,  "Hoş Geldiniz ","giriş başarılı",JOptionPane.PLAIN_MESSAGE);
					//diğer ekrana geçiş
					Menu menu = new Menu(kullanici);
					menu.setVisible(true);
					//ilk ekranı kapatma
					close();
				}else {
					JOptionPane.showMessageDialog(btnGirisYap, "Hatalı kullanıcı adı ve/veya şifre", "giriş hatalı  " ,JOptionPane.ERROR_MESSAGE);
				}
				
				//karşılaştırmaları string ile değil sayı ile yap mümkünse	
			}
		});
		
		btnGirisYap.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnGirisYap.setBounds(298, 108, 117, 29);
		contentPane.add(btnGirisYap);
		
		txtSifre = new JPasswordField();
		txtSifre.setBounds(184, 59, 231, 26);
		contentPane.add(txtSifre);
	}
	
	private void close() {
		this.setVisible(false);
	}
}
