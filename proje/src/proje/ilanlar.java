package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


public class ilanlar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_marka;
	private JTextField txt_model;
	private JTextField txt_tip;
	private JTextField txt_motor;
	private JTextField txt_yakit;
	private JTextField txt_km;
	private JTextField txt_yil;
	private JTextField txt_renk;
	private JTextField txt_fiyat;
	private JTable table;
	private JTextField txt_ara;
	private JTextField txt_iletisim;
	private JTextField txt_adres;
	
		
	public Connection getConnection() {
	    Connection con = null;
	    
	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost/galeri", "kullanici_adi", "sifre");		//VERİTABANINA BAĞLANTI İŞLEMİ
	    } catch (SQLException e) {

	        e.printStackTrace();
	    }
	    
	    return con;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ilanlar frame = new ilanlar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
		//İlan Listele fonksiyonu gerektiği yerde çağırmak için 
	private void ilanlistele() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String query = "SELECT baslik FROM ilanlar"; // İlan başlıklarını veritabanından getiren sorgu

                PreparedStatement pst = connection.prepareStatement(query);
                ResultSet rs = pst.executeQuery();

                // JTable için model oluştur
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Başlık");

                // ResultSet'tan verileri alıp JTable'a ekle
                while (rs.next()) {
                    String baslik = rs.getString("baslik");
                    model.addRow(new Object[]{baslik});
                }

                // JTable'a modeli ekle
                table.setModel(model);


                rs.close();
                pst.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
		
	
		//İlan Görüntüle fonksiyonu gerektiği yerde çağırmak için
	private void IlanGoruntule(String baslik) {
	    try {
	        Connection connection = getConnection();
	        if (connection != null) {
	        	String query = "SELECT Marka, Model, Tip, MotorHacmi, YakitTuru, Vites, Km, Yil, Renk, Fiyat, Iletisim, Adres FROM ilanlar WHERE baslik = ?";
	        	//İlan Görüntüle butonuna tıklandığında ilanlar tablosundaki kolonlardan veri çekecek
	            PreparedStatement pst = connection.prepareStatement(query);
	            pst.setString(1, baslik);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                String Marka = rs.getString("Marka"); 		//Verilerin çekileceği kolon isimleri tanımlanıyor.
	                String Model = rs.getString("Model");
	                String Tip = rs.getString("Tip");
	                String MotorHacmi = rs.getString("MotorHacmi");
	                String YakitTuru = rs.getString("YakitTuru");
	                String Km = rs.getString("Km");
	                String Yil = rs.getString("Yil");
	                String Renk = rs.getString("Renk");
	                String Fiyat = rs.getString("Fiyat");
	                String Iletisim = rs.getString("Iletisim");
	                String Adres = rs.getString("Adres");
	                

	                
	                txt_marka.setText(Marka);			//Veritabanından eşleşen kolonlar txt ile belirlenen yerlere çekiliyor.
	                txt_model.setText(Model);
	                txt_tip.setText(Tip);
	                txt_motor.setText(MotorHacmi);
	                txt_yakit.setText(YakitTuru);
	                txt_km.setText(Km);
	                txt_yil.setText(Yil);
	                txt_renk.setText(Renk);
	                txt_fiyat.setText(Fiyat);
	                txt_iletisim.setText(Iletisim);
	                txt_adres.setText(Adres);
	            }

	            rs.close();
	            pst.close();
	            connection.close();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public ilanlar() {
		setTitle("Sahisinden | İlanlar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 613);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAHİSİNDEN");
		lblNewLabel.setBounds(257, 10, 218, 38);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sahisinden, Aradığınız Araç Burada!");
		lblNewLabel_2.setBounds(222, 46, 289, 20);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Marka");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 91, 126, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Model");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(27, 134, 126, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kasa Tipi");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(27, 177, 126, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Motor Hacmi");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(27, 220, 126, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Yakıt Türü");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(27, 263, 126, 32);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Km");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(27, 306, 126, 32);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Yıl");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(27, 349, 126, 32);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Renk");
		lblNewLabel_1_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(27, 392, 126, 32);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Fiyat");
		lblNewLabel_1_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(27, 435, 126, 32);
		contentPane.add(lblNewLabel_1_8);
		
		txt_marka = new JTextField();
		txt_marka.setEditable(false);
		txt_marka.setBounds(154, 97, 194, 24);
		contentPane.add(txt_marka);
		txt_marka.setColumns(10);
		
		txt_model = new JTextField();
		txt_model.setEditable(false);
		txt_model.setColumns(10);
		txt_model.setBounds(154, 134, 194, 24);
		contentPane.add(txt_model);
		
		txt_tip = new JTextField();
		txt_tip.setEditable(false);
		txt_tip.setColumns(10);
		txt_tip.setBounds(154, 177, 194, 24);
		contentPane.add(txt_tip);
		
		txt_motor = new JTextField();
		txt_motor.setEditable(false);
		txt_motor.setColumns(10);
		txt_motor.setBounds(154, 220, 194, 24);
		contentPane.add(txt_motor);
		
		txt_yakit = new JTextField();
		txt_yakit.setEditable(false);
		txt_yakit.setColumns(10);
		txt_yakit.setBounds(154, 263, 194, 24);
		contentPane.add(txt_yakit);
		
		txt_km = new JTextField();
		txt_km.setEditable(false);
		txt_km.setColumns(10);
		txt_km.setBounds(154, 306, 194, 24);
		contentPane.add(txt_km);
		
		txt_yil = new JTextField();
		txt_yil.setEditable(false);
		txt_yil.setColumns(10);
		txt_yil.setBounds(154, 349, 194, 24);
		contentPane.add(txt_yil);
		
		txt_renk = new JTextField();
		txt_renk.setEditable(false);
		txt_renk.setColumns(10);
		txt_renk.setBounds(154, 392, 194, 24);
		contentPane.add(txt_renk);
		
		txt_fiyat = new JTextField();
		txt_fiyat.setEditable(false);
		txt_fiyat.setColumns(10);
		txt_fiyat.setBounds(154, 435, 194, 24);
		contentPane.add(txt_fiyat);
		
		table = new JTable();
		table.setBackground(SystemColor.menu);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(378, 125, 355, 236);
		contentPane.add(table);
		
		ilanlistele();
		
		JLabel lblNewLabel_1_9 = new JLabel("Tüm İlanlar");
		lblNewLabel_1_9.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_9.setBounds(378, 91, 126, 32);
		contentPane.add(lblNewLabel_1_9);
		
		JButton btnGoruntule = new JButton("İlanı Görüntüle");
		btnGoruntule.setIcon(new ImageIcon(ilanlar.class.getResource("/proje/ikonlar/goruntule.png")));
		btnGoruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow(); // Seçili satırın indeksini al

		        if (selectedRow != -1) { // Eğer bir satır seçilmişse
		            String selectedBaslik = table.getValueAt(selectedRow, 0).toString(); // Seçili satırın başlık bilgisini al
		            IlanGoruntule(selectedBaslik); // Başlığa göre ilan detaylarını getir
		        } else {
		            JOptionPane.showMessageDialog(null, "Lütfen bir ilan seçin.");
		        }
		    }
		});
		btnGoruntule.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnGoruntule.setBounds(379, 424, 175, 37);
		contentPane.add(btnGoruntule);
		
		JButton btnMenuDon = new JButton("Menüye Dön");
		btnMenuDon.setIcon(new ImageIcon(ilanlar.class.getResource("/proje/ikonlar/menu.png")));
		btnMenuDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki jFrame'i kapatır.
		        menu menu = new menu(); //
		        menu.setVisible(true);
			}
		});
		btnMenuDon.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnMenuDon.setBounds(468, 470, 166, 37);
		contentPane.add(btnMenuDon);
		
		txt_ara = new JTextField();
		txt_ara.setBounds(468, 372, 158, 32);
		contentPane.add(txt_ara);
		txt_ara.setColumns(10);
		
		JButton btn_ara = new JButton("Ara");
		btn_ara.setIcon(new ImageIcon(ilanlar.class.getResource("/proje/ikonlar/ara.png")));
		btn_ara.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_ara.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String aramaKelimesi = txt_ara.getText().trim(); // txt_ara'dan girilen metni alır

		        try {
		            Connection baglanti = getConnection();
		            if (baglanti != null) {
		                String sorgu = "SELECT baslik FROM ilanlar WHERE Marka LIKE ?"; // txt_ara'ya girilen metne göre ilanlardan Başlıkları Marka sütununa göre arar

		                PreparedStatement pst = baglanti.prepareStatement(sorgu);
		                pst.setString(1, "%" + aramaKelimesi + "%"); // Arama kelimesine göre filtreler

		                ResultSet rs = pst.executeQuery();

		                // JTable için modeli oluştur
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Başlık");

		                // ResultSet'tan verileri alıp JTable'a ekle
		                while (rs.next()) {
		                    String baslik = rs.getString("baslik");
		                    model.addRow(new Object[]{baslik});
		                }

		                // JTable'a modeli ekle
		                table.setModel(model);

		                rs.close();
		                pst.close();
		                baglanti.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		btn_ara.setBounds(636, 370, 98, 36);
		contentPane.add(btn_ara);
		
		JButton btn_tumilanlar = new JButton("Tüm İlanlar");
		btn_tumilanlar.setIcon(new ImageIcon(ilanlar.class.getResource("/proje/ikonlar/tumu.png")));
		btn_tumilanlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ilanlistele(); // Yukarıda tanımladığımız fonksiyonu çağırdık ve Tüm ilanları JTable'a çekti.
			}
		});
		btn_tumilanlar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_tumilanlar.setBounds(563, 426, 172, 37);
		contentPane.add(btn_tumilanlar);
		
		JLabel lblNewLabel_1_9_1 = new JLabel("Marka Ara");
		lblNewLabel_1_9_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_9_1.setBounds(378, 372, 89, 32);
		contentPane.add(lblNewLabel_1_9_1);
		
		JLabel lblNewLabel_1_8_1 = new JLabel("İletişim");
		lblNewLabel_1_8_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_8_1.setBounds(27, 474, 126, 32);
		contentPane.add(lblNewLabel_1_8_1);
		
		txt_iletisim = new JTextField();
		txt_iletisim.setEditable(false);
		txt_iletisim.setColumns(10);
		txt_iletisim.setBounds(154, 478, 194, 24);
		contentPane.add(txt_iletisim);
		
		JLabel Adres = new JLabel("Adres");
		Adres.setFont(new Font("Verdana", Font.BOLD, 15));
		Adres.setBounds(27, 515, 126, 32);
		contentPane.add(Adres);
		
		txt_adres = new JTextField();
		txt_adres.setEditable(false);
		txt_adres.setColumns(10);
		txt_adres.setBounds(154, 521, 194, 24);
		contentPane.add(txt_adres);
	}
}
