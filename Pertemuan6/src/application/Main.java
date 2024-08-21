package application;
	
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	BorderPane root; Scene scene; 
	
	@Override
	public void start(Stage primaryStage) {
		try {
			initView();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// atur stage
			primaryStage.setScene(scene);
			primaryStage.setTitle("My Application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void initView() {
		root = new BorderPane();
		scene = new Scene(root,600,500);
		
		// initialisasi class (yg jadi konten ditengah)
		GuiPert5 pert5 = new GuiPert5(); // ui pertemuan 5
		GuiPert6 pert6 = new GuiPert6(); // ui pertemuan 6
		
		// Menu
		MenuBar menuBar = new MenuBar(); // menu bar
		
		Menu menu1 = new Menu("Pertemuan 5"); // menu
		MenuItem item1 = new MenuItem("GUI"); // sub menu
		menu1.getItems().add(item1); // tambahkan sub menu ke menu
		
		Menu menu2 = new Menu("Pertemuan 6");
		MenuItem item2 = new MenuItem("GUI");
		menu2.getItems().add(item2);
		
		// aksi menu, harus menggunakan menu item
		item1.setOnAction(event -> {
			System.out.println("Menu 1");
			root.setCenter(pert5);
		});
		
		item2.setOnAction(event -> {
			System.out.println("Menu 2");
			root.setCenter(pert6);
		});
		
		menuBar.getMenus().addAll(menu1, menu2); // tambahkan menu ke menu bar
		
		
		// bikin elemen lain
		Label leftLabel = new Label("Kiri");
		leftLabel.setPrefSize(50, 500);
		leftLabel.setBackground(Background.fill(Color.WHITE));
		
		Label bottomLabel = new Label("Made with Java");
		bottomLabel.setPrefSize(600, 50);
		bottomLabel.setBackground(Background.fill(Color.WHEAT));
		
		Label rightLabel = new Label("Kanan");
		rightLabel.setPrefSize(50, 500);
		rightLabel.setBackground(Background.fill(Color.ANTIQUEWHITE));
		
		
		// tambah ke border pane
		root.setTop(menuBar);
		root.setLeft(leftLabel);
		root.setBottom(bottomLabel);
		root.setRight(rightLabel);
		root.setCenter(pert5);
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
