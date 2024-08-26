package application;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	Scanner scanner = new Scanner(System.in);
	Database db = new Database(); // akses konten dari class Database dgn bikin object
	
	public Main() {
		
		int choice = 0;
		
		do {
			System.out.println("Our Menu");
			System.out.println("1. Add Menu");
			System.out.println("2. View Menu");
			System.out.println("3. Update Menu");
			System.out.println("4. Delete Menu");
			System.out.println("5. Exit");
			System.out.print("Input number: ");
			choice = scanner.nextInt(); scanner.nextLine();
			
			switch(choice) {
			case 1:
				add();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("Sampai jumpa");
				System.exit(0); // buat paksa exit
				break;
			}
			
			System.out.println();
			System.out.println("Press enter to continue ...");
			scanner.nextLine();
			System.out.println();
			System.out.println();
			System.out.println();
			
		} while(choice!=5);
	}
	
	
	public void add() {
		String name; String category; int price; String id;
		System.out.print("Input menu name: ");
		name = scanner.nextLine();
		System.out.print("Input menu category: ");
		category = scanner.nextLine();
		System.out.print("Input menu price: ");
		price = scanner.nextInt(); scanner.nextLine();
		System.out.print("Input menu id: ");
		id = scanner.nextLine();
		
		Menu newMenu = new Menu(id, name, category, price); // bikin object menu dari hasil input
		
		db.insert(newMenu); // panggil method insert dari object class Database yg dibuat & passing object menu
	}
	
	
	public void view() {
		ResultSet rs = db.select(); // bikin result set sama dengan result set dari method select class Database
		try {
			while(rs.next()) { // selama masih ada barisan berikutnya di tabel
				// get nilai berdasarkan nama & tipe data kolomnya, simpan dalam array tipe Object
				Object[]barisan = {rs.getString("id"), rs.getString("name"), 
						rs.getString("category"), rs.getInt("price")};
				// print nilainya
				System.out.println(barisan[0] +  "-" + barisan[1]);
				System.out.println(barisan[2]);
				System.out.println("Price: " + barisan[3]);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update() {
		
		// input id
		String id;
		System.out.print("Input menu id: ");
		id = scanner.nextLine();
		
		// input detail menu baru
		String name; String category; int price;
		System.out.println("Input update menu: ");
		System.out.print("Menu name: ");
		name = scanner.nextLine();
		System.out.print("Menu category: ");
		category = scanner.nextLine();
		System.out.print("Menu price: ");
		price = scanner.nextInt(); scanner.nextLine();
		
		Menu updatedMenu = new Menu(id, name, category, price); // bikin menu dengan data terbaru
		db.update(updatedMenu); // panggil method update dari class Database & passing object menu
	}
	
	
	public void delete() {
		String id;
		System.out.print("Input menu id: ");
		id = scanner.nextLine();
		
		db.delete(id); // panggil method update dari class Database & passing id menu
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		new Main();
	}
}
