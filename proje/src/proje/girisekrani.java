package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class girisekrani extends JFrame {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";					//VERİTABANINA BAĞLANTI İŞLEMİ
	static final String DB_URL = "jdbc:mysql://localhost:3306/galeri";
	static final String USER = "kullanici_adi";
	static final String PASS = "sifre";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField sifre_giris;
	private JTextField kullanici_adi_giris;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisekrani frame = new girisekrani();
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
	public girisekrani() {
		setTitle("Sahisinden | Giriş Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 306);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAHİSİNDEN");
		lblNewLabel.setBounds(109, 11, 218, 37);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JButton btn_KayitOl = new JButton("Kayıt Ol");
		btn_KayitOl.setIcon(new ImageIcon(girisekrani.class.getResource("/proje/ikonlar/ekle.png")));
		btn_KayitOl.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	dispose(); //Önceki jFrame'i kapatır.
		        KayitOlEkrani kayitOlEkrani = new KayitOlEkrani(); //Kayıt Ol butonuna tıklandığında Kayıt olma sayfası açılacak.
		        kayitOlEkrani.setVisible(true);
		    }
		});

		btn_KayitOl.setBounds(88, 194, 130, 37);
		btn_KayitOl.setBackground(UIManager.getColor("Button.background"));
		btn_KayitOl.setForeground(Color.BLACK);
		btn_KayitOl.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(btn_KayitOl);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı");
		lblNewLabel_1.setBounds(48, 104, 140, 29);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Şifre");
		lblNewLabel_1_1.setBounds(48, 144, 111, 29);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnGirisYap = new JButton("Giriş Yap");
		btnGirisYap.setIcon(new ImageIcon(girisekrani.class.getResource("/proje/ikonlar/giris.png")));
		btnGirisYap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String kullanici_ad = kullanici_adi_giris.getText();
		        String sifre = new String(sifre_giris.getPassword());

		        VeritabaniIslemleri dbIslem = new VeritabaniIslemleri();
		        boolean dogrulama = dbIslem.kullaniciDogrula(kullanici_ad, sifre);
		        
		        if (dogrulama) {
		            JOptionPane.showMessageDialog(null, "Hoş Geldin " + kullanici_ad + "!");
		            dispose(); // Giriş ekranını kapat
		            menu menu = new menu(); // Menü ekranını aç
		            menu.setVisible(true);
		        } else {
		            JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre yanlış!");
		        }
		    }
		});
		btnGirisYap.setBounds(228, 194, 130, 37);
		btnGirisYap.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPane.add(btnGirisYap);
		
		sifre_giris = new JPasswordField();
		sifre_giris.setBounds(198, 145, 178, 29);
		contentPane.add(sifre_giris);
		
		kullanici_adi_giris = new JTextField();
		kullanici_adi_giris.setBounds(198, 104, 178, 30);
		contentPane.add(kullanici_adi_giris);
		kullanici_adi_giris.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sahisinden, Aradığınız Araç Burada!");
		lblNewLabel_2.setBounds(69, 46, 289, 23);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*Lütfen kaydınız yoksa kayıt olunuz.");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_2_1.setBounds(120, 233, 207, 23);
		contentPane.add(lblNewLabel_2_1);
	}
}
