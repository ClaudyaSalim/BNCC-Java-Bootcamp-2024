package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	Connection con; // buat connect ke database
	Statement s; // query langsung di 1 baris
	PreparedStatement ps; // query yg disiapkan dulu sebelum dijalankan
	ResultSet rs; // menampung hasil data yg didapatkan dari query

	
	public Database() {
		connect(); // panggil method pas class Database dipanggil
	}
	
	
	public void connect() {
		// cek apakah drivernya ada
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// connect ke database kita
		String url = "jdbc:mysql://localhost:3306/bncc_bootcamp_pert7"; // disesuaikan lagi dengan database yang kalian buat
		String username = "root"; // kalau default
		String password = ""; // kalau default
		try {
			con = DriverManager.getConnection(url, username, password);
			s = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// pastikan query yg kalian tulis disini sama dengan struktur database kalian & wajib exception handling
	
	public void insert(Menu menu) { // masukkan data ke database
		try {
			ps = con.prepareStatement("insert into menu (id, name, category, price) values (?, ?, ?, ?)"); // tulis querynya dulu, '?' buat menandakan nilainya
			// set '?' nya sesuai dengan urutan dan tipe data kolom nya
			ps.setString(1, menu.getId());
			ps.setString(2, menu.getName());
			ps.setString(3, menu.getCategory());
			ps.setInt(4, menu.getPrice());
			ps.execute(); // jalanin
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ResultSet select() { // lihat dgn terima data dari database
		try {
			rs = s.executeQuery("select * from menu"); // langsung tulis & jalanin query, simpan ke result set
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public void update(Menu menu) { // update data di database
		try {
			ps = con.prepareStatement("update menu set name = ?, category = ?, price = ? where id = ?"); // tulis querynya dulu, '?' buat menandakan nilainya
			// set '?' nya sesuai dengan urutan dan tipe data kolom nya
			ps.setString(1, menu.getName());
			ps.setString(2, menu.getCategory());
			ps.setInt(3, menu.getPrice());
			ps.setString(4, menu.getId());
			ps.execute(); // jalanin
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(String id) { // delete data dari database
		try {
			ps = con.prepareStatement("delete from menu where id=?"); // tulis querynya dulu, '?' buat menandakan nilainya
			// set '?' nya sesuai dengan urutan dan tipe data kolom nya
			ps.setString(1, id);
			ps.execute(); // jalanin
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
