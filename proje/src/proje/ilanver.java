package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class ilanver extends JFrame {
	
	// Veritabanı bağlantısı için gerekli bilgiler
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";					//VERİTABANINA BAĞLANTI İŞLEMİ
    static final String DB_URL = "jdbc:mysql://localhost:3306/galeri";
    static final String USER = "kullanici_adi";
    static final String PASS = "sifre";

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_baslik;
	private JTextField txt_marka;
	private JTextField txt_model;
	private JTextField txt_tip;
	private JTextField txt_motor;
	private JTextField txt_yakit;
	private JTextField txt_vites;
	private JTextField txt_km;
	private JTextField txt_yil;
	private JTextField txt_renk;
	private JTextField txt_fiyat;
	private JTextField txt_iletisim;
	private JTextField txt_adres;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ilanver frame = new ilanver();
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
	public ilanver() {
		setTitle("Sahisinden | İlan Ver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setForeground(Color.WHITE);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.YELLOW);
		contentPane_1.setBounds(0, 0, 747, 506);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("SAHİSİNDEN");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel_1.setBounds(257, 10, 218, 38);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sahisinden, Aradığınız Araç Burada!");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(222, 46, 289, 20);
		contentPane_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marka");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(27, 125, 126, 32);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Model");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(27, 168, 126, 32);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kasa Tipi");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(27, 211, 126, 32);
		contentPane_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Motor Hacmi");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(27, 254, 126, 32);
		contentPane_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Yakıt Türü");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(27, 297, 126, 32);
		contentPane_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Km");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(385, 168, 126, 32);
		contentPane_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Yıl");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(385, 211, 126, 32);
		contentPane_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Renk");
		lblNewLabel_1_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(385, 254, 126, 32);
		contentPane_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Fiyat");
		lblNewLabel_1_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(385, 297, 126, 32);
		contentPane_1.add(lblNewLabel_1_8);
		
		txt_marka = new JTextField();
		txt_marka.setColumns(10);
		txt_marka.setBounds(154, 133, 194, 24);
		contentPane_1.add(txt_marka);
		
		txt_model = new JTextField();
		txt_model.setColumns(10);
		txt_model.setBounds(154, 176, 194, 24);
		contentPane_1.add(txt_model);
		
		txt_tip = new JTextField();
		txt_tip.setColumns(10);
		txt_tip.setBounds(154, 217, 194, 24);
		contentPane_1.add(txt_tip);
		
		txt_motor = new JTextField();
		txt_motor.setColumns(10);
		txt_motor.setBounds(154, 262, 194, 24);
		contentPane_1.add(txt_motor);
		
		txt_yakit = new JTextField();
		txt_yakit.setColumns(10);
		txt_yakit.setBounds(154, 303, 194, 24);
		contentPane_1.add(txt_yakit);
		
		txt_km = new JTextField();
		txt_km.setColumns(10);
		txt_km.setBounds(474, 174, 194, 24);
		contentPane_1.add(txt_km);
		
		txt_yil = new JTextField();
		txt_yil.setColumns(10);
		txt_yil.setBounds(474, 217, 194, 24);
		contentPane_1.add(txt_yil);
		
		txt_renk = new JTextField();
		txt_renk.setColumns(10);
		txt_renk.setBounds(474, 260, 194, 24);
		contentPane_1.add(txt_renk);
		
		txt_fiyat = new JTextField();
		txt_fiyat.setColumns(10);
		txt_fiyat.setBounds(474, 303, 194, 24);
		contentPane_1.add(txt_fiyat);
		
		JButton btnIlanVer = new JButton("İlan Ver");
		btnIlanVer.setIcon(new ImageIcon(ilanver.class.getResource("/proje/ikonlar/ekle.png")));
		btnIlanVer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Connection conn = null;
		        PreparedStatement stmt = null;

		        try {
		            // JDBC sınıfını yükler
		            Class.forName(JDBC_DRIVER);

		            // Veritabanına bağlan
		            conn = DriverManager.getConnection(DB_URL, USER, PASS);

		            // SQL sorgusu
		            String sql = "INSERT INTO ilanlar (Baslik, Marka, Model, Tip, MotorHacmi, YakitTuru, Vites, Km, Yil, Renk, Fiyat, Iletisim, Adres) " +
		                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            //İlan ver butonuna bastıktan sonra ilanlar tablosundaki belirtlen kolonlara her veri kaydedilir.
		            // Prepared statement oluştur
		            stmt = conn.prepareStatement(sql);
		            stmt.setString(1, txt_baslik.getText());  //Belirtilen sütuna göre o kolona kayıt yapar.
		            stmt.setString(2, txt_marka.getText());
		            stmt.setString(3, txt_model.getText());
		            stmt.setString(4, txt_tip.getText());
		            stmt.setString(5, txt_motor.getText());
		            stmt.setString(6, txt_yakit.getText());
		            stmt.setString(7, txt_vites.getText());
		            stmt.setString(8, txt_km.getText());
		            stmt.setString(9, txt_yil.getText());
		            stmt.setString(10, txt_renk.getText());
		            stmt.setString(11, txt_fiyat.getText());
		            stmt.setString(12, txt_iletisim.getText());
		            stmt.setString(13, txt_adres.getText());

		            // SQL sorgusunu çalıştırma
		            stmt.executeUpdate();

		            JOptionPane.showMessageDialog(null, "İlan verme işlemi başarıyla gerçekleştirildi.");

		        } catch (SQLException se) {
		            se.printStackTrace();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        } finally {
		            // Bağlantıyı kapatma
		            try {
		                if (stmt != null) stmt.close();
		            } catch (SQLException se2) {
		                se2.printStackTrace();
		            }
		            try {
		                if (conn != null) conn.close();
		            } catch (SQLException se) {
		                se.printStackTrace();
		            }
		        }
		    }
		});
		btnIlanVer.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnIlanVer.setBounds(286, 380, 166, 37);
		contentPane_1.add(btnIlanVer);
		
		JButton btnMenuDon = new JButton("Menüye Dön");
		btnMenuDon.setIcon(new ImageIcon(ilanver.class.getResource("/proje/ikonlar/menu.png")));
		btnMenuDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki jFrame'i kapatır.
		        menu menu = new menu(); //
		        menu.setVisible(true);
			}
		});
		btnMenuDon.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnMenuDon.setBounds(74, 380, 166, 37);
		contentPane_1.add(btnMenuDon);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.setIcon(new ImageIcon(ilanver.class.getResource("/proje/ikonlar/temizle.png")));
		btnTemizle.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        txt_baslik.setText("");			// Temizle butonuna tıklandığında belirtilen txt'ler silinsin diye "" ekledik.
		        txt_marka.setText("");
		        txt_model.setText("");
		        txt_tip.setText("");
		        txt_motor.setText("");
		        txt_yakit.setText("");
		        txt_vites.setText("");
		        txt_km.setText("");
		        txt_yil.setText("");
		        txt_renk.setText("");
		        txt_fiyat.setText("");
		        txt_iletisim.setText("");
		        txt_adres.setText("");
		    }
		});

		btnTemizle.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnTemizle.setBounds(499, 380, 166, 37);
		contentPane_1.add(btnTemizle);
		
		txt_vites = new JTextField();
		txt_vites.setColumns(10);
		txt_vites.setBounds(474, 133, 194, 24);
		contentPane_1.add(txt_vites);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Vites");
		lblNewLabel_1_5_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5_1.setBounds(385, 125, 126, 32);
		contentPane_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Başlık");
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(27, 82, 126, 32);
		contentPane_1.add(lblNewLabel_1_1_2);
		
		txt_baslik = new JTextField();
		txt_baslik.setColumns(10);
		txt_baslik.setBounds(154, 90, 514, 24);
		contentPane_1.add(txt_baslik);
		
		txt_iletisim = new JTextField();
		txt_iletisim.setColumns(10);
		txt_iletisim.setBounds(154, 340, 194, 24);
		contentPane_1.add(txt_iletisim);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("İletişim");
		lblNewLabel_1_4_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4_1.setBounds(27, 337, 126, 32);
		contentPane_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Adres");
		lblNewLabel_1_4_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4_2.setBounds(385, 338, 60, 32);
		contentPane_1.add(lblNewLabel_1_4_2);
		
		txt_adres = new JTextField();
		txt_adres.setColumns(10);
		txt_adres.setBounds(474, 340, 194, 24);
		contentPane_1.add(txt_adres);
	}
}
