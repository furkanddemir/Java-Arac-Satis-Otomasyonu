package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class KayitOlEkrani extends JFrame {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";						//VERİTABANINA BAĞLANTI İŞLEMİ
	static final String DB_URL = "jdbc:mysql://localhost:3306/galeri";
	static final String USER = "kullanici_adi";
	static final String PASS = "sifre";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_kullanici_adi;
	private JPasswordField psw_sifre;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitOlEkrani frame = new KayitOlEkrani();
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
	public KayitOlEkrani() {
		setTitle("Sahisinden | Kayıt Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 292);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAHİSİNDEN");
		lblNewLabel.setBounds(104, 11, 218, 37);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sahisinden, Aradığınız Araç Burada!");
		lblNewLabel_2.setBounds(64, 46, 289, 23);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanıcı Adı");
		lblNewLabel_1.setBounds(43, 104, 140, 29);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Şifre");
		lblNewLabel_1_1.setBounds(43, 144, 111, 29);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1_1);
		
		txt_kullanici_adi = new JTextField();
		txt_kullanici_adi.setBounds(193, 104, 178, 30);
		txt_kullanici_adi.setColumns(10);
		contentPane.add(txt_kullanici_adi);
		
		psw_sifre = new JPasswordField();
		psw_sifre.setBounds(193, 144, 178, 30);
		contentPane.add(psw_sifre);
		
		JButton btn_KayitOl = new JButton("Kayıt Ol");
		btn_KayitOl.setIcon(new ImageIcon(KayitOlEkrani.class.getResource("/proje/ikonlar/ekle.png")));
		btn_KayitOl.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String kullaniciAdi = txt_kullanici_adi.getText().trim();
		        String sifre = new String(psw_sifre.getPassword()).trim();

		        if (!kullaniciAdi.isEmpty() && !sifre.isEmpty()) {
		            Connection baglanti = null;
		            PreparedStatement preparedStatement = null;

		            try {
		                // Veritabanına bağlantı oluştur
		                baglanti = DriverManager.getConnection(DB_URL, USER, PASS);

		                // SQL sorgusu     //Bağlı veritabanındaki kullanicilar tablosundaki kullanici_adi ve sifre'ye girilen veri eklenir.
		                String sqlSorgu = "INSERT INTO kullanicilar (kullanici_adi, sifre) VALUES (?, ?)";   

		                // Veritabanında çalıştırmak için PreparedStatement 
		                preparedStatement = baglanti.prepareStatement(sqlSorgu);
		                preparedStatement.setString(1, kullaniciAdi);
		                preparedStatement.setString(2, sifre);

		                // Kullanıcı bilgilerini veritabanına ekle
		                int etkilenenSatir = preparedStatement.executeUpdate();

		                if (etkilenenSatir > 0) {
		                	JOptionPane.showMessageDialog(null, "Kayıt işlemi başarıyla gerçekleştirildi."); 
		                    
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Kayıt işlemi gerçekleştirilemedi.");
		            } finally {
		                try {
		                    // Kaynakları kapat
		                    if (preparedStatement != null) {
		                        preparedStatement.close();
		                    }
		                    if (baglanti != null) {
		                        baglanti.close();
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        } else {
		            
		        	JOptionPane.showMessageDialog(null, "Lütfen kullanıcı adı ve şifre giriniz.");
		        }
		    }
		});
		btn_KayitOl.setBounds(230, 194, 128, 37);
		btn_KayitOl.setForeground(Color.BLACK);
		btn_KayitOl.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_KayitOl.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(btn_KayitOl);
		
		JButton btn_GeriDon = new JButton("Geri Dön");
		btn_GeriDon.setIcon(new ImageIcon(KayitOlEkrani.class.getResource("/proje/ikonlar/geri.png")));
		btn_GeriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki pencereyi kapatır.
		        girisekrani girisekrani = new girisekrani(); //
		        girisekrani.setVisible(true);
			}
		});
		btn_GeriDon.setForeground(Color.BLACK);
		btn_GeriDon.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_GeriDon.setBackground(UIManager.getColor("Button.background"));
		btn_GeriDon.setBounds(88, 194, 132, 37);
		contentPane.add(btn_GeriDon);
	}

}
