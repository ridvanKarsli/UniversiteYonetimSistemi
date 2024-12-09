package presentation;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Abstraction.Readable;
import Abstraction.Updateable;
import BusinessLogic.FactoryBLL;
import Model.Ogrenci;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OgrenciIsleri extends JFrame {

	private Readable<Ogrenci> bll = FactoryBLL.getOgrenciBLL();
	private Updateable<Ogrenci> update = FactoryBLL.getOgrenciBLLUpdateable();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Menu menu;
	private JScrollPane scrollPane;
	private JTable ogrenciTablosu;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JTextField txtTcNo;
	private JTextField txtEmail;
	private JTextField txtOkulNo;
	private JLabel lblId;
	
	private List<Ogrenci> ogrenciler;
	private JButton btnGuncelle;

	public OgrenciIsleri(Menu menu) {
		this.menu = menu;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				menuPenceresiAc();
			}
		});
		setTitle("OGRENCİ ISLERİ");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
			}
		});
		scrollPane.setBounds(6, 161, 438, 105);
		scrollPane.setViewportView(ogrenciTablosu);
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		
		ogrenciTablosu = new JTable();
		ogrenciTablosu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int secilenIndex = ogrenciTablosu.getSelectedRow();
				Ogrenci secilenOgrenci = ogrenciler.get(secilenIndex);
				
				lblId.setText("id: " + secilenOgrenci.getId());
				
				txtAd.setText(secilenOgrenci.getAd());
				txtSoyad.setText(secilenOgrenci.getSoyad());
				txtTcNo.setText(String.valueOf(secilenOgrenci.getTcNo()));
				txtEmail.setText(secilenOgrenci.getEmail());
				txtOkulNo.setText(secilenOgrenci.getOkulNo().toString());
				
			}
		});
		scrollPane.setViewportView(ogrenciTablosu);
		
		txtAd = new JTextField();
		txtAd.setBounds(79, 17, 130, 26);
		contentPane.add(txtAd);
		txtAd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ad :");
		lblNewLabel.setBounds(6, 22, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtSoyad = new JTextField();
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(79, 56, 130, 26);
		contentPane.add(txtSoyad);
		
		JLabel lblSoyad = new JLabel("Soyad :");
		lblSoyad.setBounds(6, 61, 61, 16);
		contentPane.add(lblSoyad);
		
		txtTcNo = new JTextField();
		txtTcNo.setColumns(10);
		txtTcNo.setBounds(79, 94, 130, 26);
		contentPane.add(txtTcNo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tc No :");
		lblNewLabel_1_1.setBounds(6, 99, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(314, 17, 130, 26);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_1_1.setBounds(241, 22, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtOkulNo = new JTextField();
		txtOkulNo.setColumns(10);
		txtOkulNo.setBounds(314, 56, 130, 26);
		contentPane.add(txtOkulNo);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Okul No :");
		lblNewLabel_1_1_1_1.setBounds(241, 61, 61, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ogrenci yeniOgrenci = new Ogrenci();
				
				yeniOgrenci.setAd(txtAd.getText());
				yeniOgrenci.setSoyad(txtSoyad.getText());
				yeniOgrenci.setTcNo(Long.valueOf(txtTcNo.getText()));
				yeniOgrenci.setEmail(txtEmail.getText());
				yeniOgrenci.setOkulNo(Integer.valueOf(txtOkulNo.getText()));
				
				update.ekle(yeniOgrenci);
	
				veriGoster();
				formuTemizle();
			}
		});
		btnKaydet.setBounds(89, 132, 100, 29);
		contentPane.add(btnKaydet);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tablodan alan seçilmiş mi
				int selectedIndex = ogrenciTablosu.getSelectedRow();
				
				if ( selectedIndex == -1) {
					JOptionPane.showMessageDialog(btnSil, "Silme işlemi ini bir satır seçmelisiniz!");
					return;//return methoddan çıkar
				}
				//satır seçildiyse
				int secilenOgrenciId = ogrenciler.get(selectedIndex).getId();
				
				update.sil(secilenOgrenciId);
				
				veriGoster();
				
			}
		});
		btnSil.setBounds(192, 132, 100, 29);
		contentPane.add(btnSil);
		
		btnGuncelle = new JButton("Güncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//tablodan alan seçilmiş mi
				int selectedIndex = ogrenciTablosu.getSelectedRow();
				
				if ( selectedIndex == -1) {
					JOptionPane.showMessageDialog(btnSil, "Silme işlemi ini bir satır seçmelisiniz!");
					return;//return methoddan çıkar
				}
				//satır seçildiyse
				Ogrenci guncellenecekOgrenci = ogrenciler.get(selectedIndex);
				
				guncellenecekOgrenci.setAd(txtAd.getText());
				guncellenecekOgrenci.setSoyad(txtSoyad.getText());
				guncellenecekOgrenci.setTcNo(Long.valueOf(txtTcNo.getText()));
				guncellenecekOgrenci.setEmail(txtEmail.getText());
				guncellenecekOgrenci.setOkulNo(Integer.valueOf(txtOkulNo.getText()));
				
				update.guncelle(guncellenecekOgrenci);
				
				formuTemizle();
				
				veriGoster();
				
			}
		});
		btnGuncelle.setBounds(304, 132, 100, 29);
		contentPane.add(btnGuncelle);
		
		lblId = new JLabel("");
		lblId.setBounds(51, 6, 61, 16);
		contentPane.add(lblId);

		veriGoster();
	}
	
	private void formuTemizle() {
		
		txtAd.setText("");
		txtSoyad.setText("");
		txtTcNo.setText("");
		txtEmail.setText("");
		txtOkulNo.setText("");
		
//		//contentpane alanına ekleen bütün componentleri aldım(abstraction)
//		Component[] components = contentPane.getComponents();
//		
//		//aldığım componentler içinde dönerken bunlardan textFiekd olanları siliyorum
//		for (Component component : components) {//poymorephism
//			((JTextField) component).setText("");
//		}
		
	}

	private void veriGoster() {
		ogrenciler = bll.hepsiniOku();

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

	private void menuPenceresiAc() {
		this.menu.setVisible(true);
	}
}
