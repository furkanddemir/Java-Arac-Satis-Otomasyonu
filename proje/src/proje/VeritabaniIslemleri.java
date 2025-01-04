package proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeritabaniIslemleri {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/galeri";
    static final String USER = "kullanici_adi";
    static final String PASS = "sifre";

    public boolean kullaniciDogrula(String kullaniciAdi, String sifre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean dogrulama = false;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "SELECT * FROM kullanicilar WHERE kullanici_adi = ? AND sifre = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, kullaniciAdi);
            stmt.setString(2, sifre);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Kullanıcı adı ve şifre doğru
                dogrulama = true;
            }
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return dogrulama;
    }
    
    
}



