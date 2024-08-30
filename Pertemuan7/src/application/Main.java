package application;

import application.view.Page1View;
import application.view.Page2;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// cek application.view buat class pages
			Page1View pageOne = new Page1View(); // GUI Page1 dipisah di class lain
			Page2 pageTwo = new Page2(); // GUI Page2 dipisah di class lain
			primaryStage.setScene(pageOne.scene); // set halaman pertama jadi Page 1
			primaryStage.show();

			pageOne.sideBar.sideMenu1.setOnMouseClicked(event -> { // kalau sideMenu di Page 1 diklik
				primaryStage.setScene(pageTwo.scene); // ganti halaman dari Page 1 jadi Page 2
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		new Main();
	}
}
