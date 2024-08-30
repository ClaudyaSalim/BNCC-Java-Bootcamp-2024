package application.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MenuController {

	Database db = new Database(); // panggil class Database dengan initialisasi
	public ObservableList<Menu> listMenu = FXCollections.observableArrayList(); // bikin observable list buat masukin data ke tabel

	public MenuController() {
		fillListMenu(); // isi list tabel
	}

	// sambungin fungsi insert dari database dgn view Page 1
	public void addMenu(String name, String category, int price) {
	
		fillListMenu(); // isi dulu list
		String id; // bikin variabel id buat generate menu baru secara incremental-> M001, M002, M003

		if(listMenu.size()==0) {
			id = "M001"; // id kalau belum ada menu apapun
		}
		else {
			// penjleasan code dapetin id lama:
			// 1. cek jumlah menu
			// 2. dapat index terakhir = jumlah - 1
			// 3. dapat menu index terakhir
			// 4. dapat id dari menu terakhir
			// 5. dapat angka dari idnya -> M001 jadi 001
			// 6. ganti angka dari id (string) ke integer -> 001 jadi 1
			
			int jumlahMenu = listMenu.size(); 
			int lastIndex = jumlahMenu-1; 
			Menu lastMenu = listMenu.get(lastIndex);
			String lastId = lastMenu.getId();
			String substring = lastId.substring(1);
			int lastNum = Integer.parseInt(substring);

			// penjelasan code bikin id baru:
			// 1. id baru -> id sebelumnya + 1 -> 2
			// 2. set id baru jadi string (sekalian dibuat format 3 digit) -> 2 jadi 002
			// 3. sambungin dengan huruf depan "M" -> M002
			int newNum = lastNum+1; // 
			String idNum = String.format("%03d", newNum);
			id = "M" + idNum;
		}

		Menu newMenu = new Menu(name, category, price); // bikin object menu dgn data yg didapat
		newMenu.setId(id); // jangan lupa set id dengan id yg baru dibuat

		db.insert(newMenu); // panggil method insert dari database & passing object menu
	}

	
	public void fillListMenu() { // isi list tabel
		listMenu.clear(); // kalau ada data sebelumnya di clear dulu krn mau diisi ulang data terbaru ke list
		ResultSet rs = db.select(); // panggil method select dari database & masukin hasil ke result set
		try {
			while(rs.next()) { // selama data tidak kosong
				String id = rs.getString("id");
				String name = rs.getString("name");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Menu menu = new Menu(name, category, price); // bikin object menu
				menu.setId(id); // jangan lupa set id nya
				listMenu.add(menu); // tambahkan ke list

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// print nama menu
		System.out.println("List Menu:");
		for(Menu menu: listMenu) {
			System.out.println(menu.getName());
		}

	}
	

	// sambungin fungsi update dari database dgn view Page 1
	public void updateMenu(String id, String name, String category, int price) {
		Menu menu = new Menu(name, category, price);
		menu.setId(id);
		db.update(menu);
	}

	
	// sambungin fungsi delete dari database dgn view Page 1
	public void deleteMenu(String id) {
		db.delete(id);
	}

}
