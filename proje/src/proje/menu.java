package proje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setTitle("Sahisinden | Menü");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 280);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAHİSİNDEN");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setBounds(118, 11, 218, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Sahisinden, Aradığınız Araç Burada!");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(87, 46, 289, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("İlanları Görüntüle");
		btnNewButton.setIcon(new ImageIcon(menu.class.getResource("/proje/ikonlar/goruntule.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki jFrame'i kapatır.
		        ilanlar ilanlar = new ilanlar(); //İlanlar butonuna tıklandığında İlanlar sayfası açılacak.
		        ilanlar.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton.setBounds(35, 120, 197, 37);
		contentPane.add(btnNewButton);
		
		JButton btnIlanVer = new JButton("İlan Ver");
		btnIlanVer.setIcon(new ImageIcon(menu.class.getResource("/proje/ikonlar/ekle.png")));
		btnIlanVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki jFrame'i kapatır.
		        ilanver ilanver = new ilanver(); //İlan Ver butonuna tıklandığında İlan Ver sayfası açılacak.
		        ilanver.setVisible(true);
			}
		});
		btnIlanVer.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnIlanVer.setBounds(240, 119, 195, 37);
		contentPane.add(btnIlanVer);
		
		JButton btn_ilaniGuncelle = new JButton(" İlan Güncelle/Sil");
		btn_ilaniGuncelle.setIcon(new ImageIcon(menu.class.getResource("/proje/ikonlar/guncelle.png")));
		btn_ilaniGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Önceki jFrame'i kapatır.
		        guncelle guncelle = new guncelle(); //İlan Ver butonuna tıklandığında İlan Ver sayfası açılacak.
		        guncelle.setVisible(true);
			}
		});
		btn_ilaniGuncelle.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_ilaniGuncelle.setBounds(144, 166, 196, 37);
		contentPane.add(btn_ilaniGuncelle);
	}
}
