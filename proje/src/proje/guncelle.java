package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class guncelle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txt_ara;
	private JTextField txt_marka;
	private JTextField txt_model;
	private JTextField txt_tip;
	private JTextField txt_motor;
	private JTextField txt_yakit;
	private JTextField txt_km;
	private JTextField txt_yil;
	private JTextField txt_renk;
	private JTextField txt_fiyat;
	private JTextField txt_iletisim;
	private JTextField txt_adres;
	private JTextField txt_baslik;

	public Connection getConnection() {
	    Connection con = null;
	    
	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost/galeri", "kullanici_adi", "sifre");			//VERİTABANINA BAĞLANTI İŞLEMİ
	       // JOptionPane.showMessageDialog(null, "Tablo güncellendi.");
	    } catch (SQLException e) {
	       // JOptionPane.showMessageDialog(null, "Tablo güncellenemedi.");
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
					guncelle frame = new guncelle();
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
                String query = "SELECT baslik FROM ilanlar"; // Veritabanında ilanlar tablosundaki Baslik kolonundaki verileri getiren sorgu

                PreparedStatement pst = connection.prepareStatement(query);
                ResultSet rs = pst.executeQuery();

                // JTable için model oluşturur
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Başlık");

                // ResultSet'tan verileri alıp JTable'a ekler
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
	        	String query = "SELECT Baslik, Marka, Model, Tip, MotorHacmi, YakitTuru, Vites, Km, Yil, Renk, Fiyat, Iletisim, Adres FROM ilanlar WHERE baslik = ?";
	        	//İlanlar tablosundaki baslik kolonunda ilan başlıklarını içerir ve bu sorgu bu başlığa göre belirli bir ilanın özelliklerini sıralar.
	            PreparedStatement pst = connection.prepareStatement(query);
	            pst.setString(1, baslik);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	            	String Baslik = rs.getString("Baslik");  //Belirtilen kolonları belirtlen txt'lere yazar.
	                String Marka = rs.getString("Marka");
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
	                

	                txt_baslik.setText(Baslik); 	//Veritabanında eşleşen kolonların içeriğini txt'lere yazar.
	                txt_marka.setText(Marka);
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
	
		//İlan Sil
	private void ilanSil() {
	    try {
	        Connection connection = getConnection();
	        if (connection != null) {
	            int selectedRowIndex = table.getSelectedRow(); 
	            if (selectedRowIndex != -1) { 
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                String selectedBaslik = model.getValueAt(selectedRowIndex, 0).toString(); 

	                String deleteQuery = "DELETE FROM ilanlar WHERE baslik = ?";   //ilanlar tablosundaki başlığa göre ilanı siler.
	                PreparedStatement pst = connection.prepareStatement(deleteQuery);
	                pst.setString(1, selectedBaslik); // Başlığa göre ilanı siler

	                int deleteCount = pst.executeUpdate();

	                if (deleteCount > 0) {
	                    JOptionPane.showMessageDialog(null, "İlan başarıyla silindi.");
	                    model.removeRow(selectedRowIndex); // JTable'dan da ilanı kaldırır
	                } else {
	                    JOptionPane.showMessageDialog(null, "İlan silinirken bir hata oluştu.");
	                }

	                pst.close();
	            } else {
	                JOptionPane.showMessageDialog(null, "Lütfen silinecek bir ilan seçin.");
	            }

	            connection.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public guncelle() {
		setTitle("Sahisinden | İlan Güncelle / Sil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setForeground(Color.WHITE);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.YELLOW);
		contentPane_1.setBounds(0, 0, 766, 599);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("SAHİSİNDEN");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setBounds(257, 10, 218, 38);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sahisinden, Aradığınız Araç Burada!");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(222, 46, 289, 20);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Marka");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 91, 126, 32);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Model");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(27, 134, 126, 32);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kasa Tipi");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(27, 177, 126, 32);
		contentPane_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Motor Hacmi");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(27, 220, 126, 32);
		contentPane_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Yakıt Türü");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(27, 263, 126, 32);
		contentPane_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Km");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(27, 306, 37, 32);
		contentPane_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Yıl");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(27, 349, 126, 32);
		contentPane_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Renk");
		lblNewLabel_1_7.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(27, 392, 126, 32);
		contentPane_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Fiyat");
		lblNewLabel_1_8.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_8.setBounds(27, 435, 126, 32);
		contentPane_1.add(lblNewLabel_1_8);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBackground(SystemColor.menu);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
		table.setBounds(378, 172, 355, 236);
		contentPane_1.add(table);
		ilanlistele();
		
		JLabel lblNewLabel_1_9 = new JLabel("Tüm İlanlar");
		lblNewLabel_1_9.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_9.setBounds(378, 134, 126, 32);
		contentPane_1.add(lblNewLabel_1_9);
		
		JButton btnGoruntule = new JButton("İlanı Görüntüle");
		btnGoruntule.setIcon(new ImageIcon(guncelle.class.getResource("/proje/ikonlar/goruntule.png")));
		btnGoruntule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow(); // Seçili satırın indeksini alır

		        if (selectedRow != -1) { // Eğer bir satır seçilmişse
		            String selectedBaslik = table.getValueAt(selectedRow, 0).toString(); // Seçili satırın başlık bilgisini alır
		            IlanGoruntule(selectedBaslik); // Başlığa göre ilan detaylarını getirir
		        } else {
		            JOptionPane.showMessageDialog(null, "Lütfen bir ilan seçin.");
		        }
		    }
		});
		btnGoruntule.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnGoruntule.setBounds(378, 462, 173, 37);
		contentPane_1.add(btnGoruntule);
		
		JButton btnMenuDon = new JButton("Menüye Dön");
		btnMenuDon.setIcon(new ImageIcon(guncelle.class.getResource("/proje/ikonlar/menu.png")));
		btnMenuDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki jFrame'i kapatır.
		        menu menu = new menu(); //İlan Ver butonuna tıklandığında İlan Ver sayfası açılacak.
		        menu.setVisible(true);
			}
		});
		btnMenuDon.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnMenuDon.setBounds(474, 558, 166, 37);
		contentPane_1.add(btnMenuDon);
		
		JButton btnSil = new JButton("İlanı Sil");
		btnSil.setIcon(new ImageIcon(guncelle.class.getResource("/proje/ikonlar/sil.png")));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ilanSil();
			}
		});
		btnSil.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSil.setBounds(567, 510, 166, 37);
		contentPane_1.add(btnSil);
		
		txt_ara = new JTextField();
		txt_ara.setColumns(10);
		txt_ara.setBounds(474, 419, 159, 32);
		contentPane_1.add(txt_ara);
		
		JButton btn_ara = new JButton("Ara");
		btn_ara.setIcon(new ImageIcon(guncelle.class.getResource("/proje/ikonlar/ara.png")));
		btn_ara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String aramaKelimesi = txt_ara.getText().trim(); // txt_ara'dan metni al

		        try {
		            Connection baglanti = getConnection();
		            if (baglanti != null) {
		                String sorgu = "SELECT baslik FROM ilanlar WHERE Marka LIKE ?"; // Başlıkları Marka sütununa göre arar

		                PreparedStatement pst = baglanti.prepareStatement(sorgu);
		                pst.setString(1, "%" + aramaKelimesi + "%"); // Arama kelimesine göre filtrele

		                ResultSet rs = pst.executeQuery();

		                // JTable için modeli oluşturur
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("Başlık");

		                // ResultSet'tan verileri alıp JTable'a eklee
		                while (rs.next()) {
		                    String baslik = rs.getString("baslik");
		                    model.addRow(new Object[]{baslik});
		                }

		                // JTable'a modeli eklee
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
		btn_ara.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_ara.setBounds(643, 419, 90, 32);
		contentPane_1.add(btn_ara);
		
		JButton btn_tumilanlar = new JButton("Tüm İlanlar");
		btn_tumilanlar.setIcon(new ImageIcon(guncelle.class.getResource("/proje/ikonlar/tumu.png")));
		btn_tumilanlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ilanlistele();
			}
		});
		btn_tumilanlar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_tumilanlar.setBounds(567, 462, 166, 37);
		contentPane_1.add(btn_tumilanlar);
		
		JLabel lblNewLabel_1_9_1 = new JLabel("Marka Ara");
		lblNewLabel_1_9_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_9_1.setBounds(386, 419, 89, 32);
		contentPane_1.add(lblNewLabel_1_9_1);
		
		JLabel lblNewLabel_1_8_1 = new JLabel("İletişim");
		lblNewLabel_1_8_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_8_1.setBounds(27, 474, 126, 32);
		contentPane_1.add(lblNewLabel_1_8_1);
		
		JLabel Adres = new JLabel("Adres");
		Adres.setFont(new Font("Verdana", Font.BOLD, 15));
		Adres.setBounds(27, 515, 126, 32);
		contentPane_1.add(Adres);
		
		txt_marka = new JTextField();
		txt_marka.setBounds(154, 97, 194, 24);
		contentPane_1.add(txt_marka);
		txt_marka.setColumns(10);
		
		txt_model = new JTextField();
		txt_model.setColumns(10);
		txt_model.setBounds(154, 142, 194, 24);
		contentPane_1.add(txt_model);
		
		txt_tip = new JTextField();
		txt_tip.setColumns(10);
		txt_tip.setBounds(154, 185, 194, 24);
		contentPane_1.add(txt_tip);
		
		txt_motor = new JTextField();
		txt_motor.setColumns(10);
		txt_motor.setBounds(154, 228, 194, 24);
		contentPane_1.add(txt_motor);
		
		txt_yakit = new JTextField();
		txt_yakit.setColumns(10);
		txt_yakit.setBounds(154, 269, 194, 24);
		contentPane_1.add(txt_yakit);
		
		txt_km = new JTextField();
		txt_km.setColumns(10);
		txt_km.setBounds(154, 314, 194, 24);
		contentPane_1.add(txt_km);
		
		txt_yil = new JTextField();
		txt_yil.setColumns(10);
		txt_yil.setBounds(154, 357, 194, 24);
		contentPane_1.add(txt_yil);
		
		txt_renk = new JTextField();
		txt_renk.setColumns(10);
		txt_renk.setBounds(154, 400, 194, 24);
		contentPane_1.add(txt_renk);
		
		txt_fiyat = new JTextField();
		txt_fiyat.setColumns(10);
		txt_fiyat.setBounds(154, 443, 194, 24);
		contentPane_1.add(txt_fiyat);
		
		txt_iletisim = new JTextField();
		txt_iletisim.setColumns(10);
		txt_iletisim.setBounds(154, 480, 194, 24);
		contentPane_1.add(txt_iletisim);
		
		txt_adres = new JTextField();
		txt_adres.setColumns(10);
		txt_adres.setBounds(154, 523, 194, 24);
		contentPane_1.add(txt_adres);
		
		JLabel lblNewLabel_1_10 = new JLabel("Başlık");
		lblNewLabel_1_10.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1_10.setBounds(378, 91, 59, 32);
		contentPane_1.add(lblNewLabel_1_10);
		
		txt_baslik = new JTextField();
		txt_baslik.setColumns(10);
		txt_baslik.setBounds(447, 99, 286, 24);
		contentPane_1.add(txt_baslik);
		
		JButton btn_guncelle = new JButton(" İlanı Güncelle");
		btn_guncelle.setIcon(new ImageIcon(guncelle.class.getResource("/proje/ikonlar/guncelle.png")));
		btn_guncelle.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String baslik = txt_baslik.getText();		//Seçili olan ilanın bilgileri txt'lerde yazıyor.
		        String marka = txt_marka.getText();
		        String model = txt_model.getText();
		        String tip = txt_tip.getText();
		        String motorHacmi = txt_motor.getText();
		        String yakitTuru = txt_yakit.getText();
		        String km = txt_km.getText();
		        String yil = txt_yil.getText();
		        String renk = txt_renk.getText();
		        String fiyat = txt_fiyat.getText();
		        String iletisim = txt_iletisim.getText();
		        String adres = txt_adres.getText();

		        try {
		            Connection baglanti = getConnection();
		            if (baglanti != null) {		//Güncelleme sorgusu
		                String guncelleSorgusu = "UPDATE ilanlar SET Marka=?, Model=?, Tip=?, MotorHacmi=?, YakitTuru=?, Km=?, Yil=?, Renk=?, Fiyat=?, Iletisim=?, Adres=? WHERE Baslik=?";
		                PreparedStatement pst = baglanti.prepareStatement(guncelleSorgusu);
		                
		                pst.setString(1, marka);
		                pst.setString(2, model);
		                pst.setString(3, tip);
		                pst.setString(4, motorHacmi);
		                pst.setString(5, yakitTuru);
		                pst.setString(6, km);
		                pst.setString(7, yil);
		                pst.setString(8, renk);
		                pst.setString(9, fiyat);
		                pst.setString(10, iletisim);
		                pst.setString(11, adres);
		                pst.setString(12, baslik);

		                int guncelleSonuc = pst.executeUpdate();

		                if (guncelleSonuc > 0) {
		                    JOptionPane.showMessageDialog(null, "İlan başarıyla güncellendi.");
		                } else {
		                    JOptionPane.showMessageDialog(null, "İlan güncellenirken bir hata oluştu.");
		                }

		                pst.close();
		                baglanti.close();
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		btn_guncelle.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_guncelle.setBounds(378, 510, 173, 37);
		contentPane_1.add(btn_guncelle);
	}
}
