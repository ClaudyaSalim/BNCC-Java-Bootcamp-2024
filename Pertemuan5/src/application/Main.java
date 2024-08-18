package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	BorderPane root; Scene scene; GridPane gridLayout; TableView table;
	
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
		
		Label title = new Label("My Application");
		title.setPrefSize(600, 50);
		title.setBackground(Background.fill(Color.ALICEBLUE));
		title.setAlignment(Pos.CENTER);
		
		Label leftLabel = new Label("Kiri");
		leftLabel.setPrefSize(50, 500);
		leftLabel.setBackground(Background.fill(Color.WHITE));
		
		Label bottomLabel = new Label("Made with Java");
		bottomLabel.setPrefSize(600, 50);
		bottomLabel.setBackground(Background.fill(Color.WHEAT));
		
		Label rightLabel = new Label("Kanan");
		rightLabel.setPrefSize(50, 500);
		rightLabel.setBackground(Background.fill(Color.ANTIQUEWHITE));
		
		
		// buat konten di tengah
		gridLayout = new GridPane();
		Label bottom = new Label("Bottom");
		
		table = new TableView();
		setTable();
		
		gridLayout.add(initForm(), 0, 0);
		gridLayout.add(rightSide(), 1, 0);
		gridLayout.add(table, 0, 1, 2, 1);
		
		ColumnConstraints kolom1 = new ColumnConstraints();
		kolom1.setPercentWidth(50);
		ColumnConstraints kolom2 = new ColumnConstraints();
		kolom2.setPercentWidth(50);
		
		gridLayout.getColumnConstraints().addAll(kolom1, kolom2);
		gridLayout.setPadding(new Insets(20));
		gridLayout.setHgap(20);
		gridLayout.setVgap(20);
		
		
		// tambah ke border pane
		root.setTop(title);
		root.setLeft(leftLabel);
		root.setBottom(bottomLabel);
		root.setRight(rightLabel);
		root.setCenter(gridLayout);
	}
	
	
	// mengatur tampilan form
	public VBox initForm() {
		VBox form = new VBox(20); // spacing antara elemen = 20
		
		Label leftSide = new Label("Registration Form");
		
		HBox name = nameField();
		FlowPane gender = genderField();
		FlowPane course = courseField();
		Button submitBtn = new Button("Submit");
		submitBtn.setPrefSize(200, 16); 
		
		form.getChildren().addAll(leftSide, name, gender, course, submitBtn);
		
		return form;
	}
	
	
	// mengatur input utk name
	public HBox nameField () {
		HBox field = new HBox(10); // spacing antara elemen = 10
		
		Label nameLabel = new Label("Name:");
		TextField nameInput = new TextField();
		
		field.getChildren().addAll(nameLabel, nameInput);
		
		return field;
	}
	
	
	// mengatur input utk gender
	public FlowPane genderField() {
		FlowPane field = new FlowPane(20, 10); // spacing horizontal = 20, vertikal = 10
		Label genderLabel = new Label("Gender:");
		
		ToggleGroup genderBtn = new ToggleGroup(); // bikin toggle group biar pilih radio button hanya bisa salah 1
		RadioButton maleBtn = new RadioButton("Male");
		RadioButton femaleBtn = new RadioButton("Female");
		// set toggle group yg sama
		maleBtn.setToggleGroup(genderBtn);
		femaleBtn.setToggleGroup(genderBtn);
		
		field.getChildren().addAll(genderLabel, maleBtn, femaleBtn);
		
		return field;
	}
	
	
	// mengatur input utk course
	public FlowPane courseField() {
		FlowPane field = new FlowPane(20, 10);
		Label courseLabel = new Label("Course:");
		CheckBox checkbox1 = new CheckBox("Java");
		CheckBox checkbox2 = new CheckBox("Front-End");
		CheckBox checkbox3 = new CheckBox("Back-End");
		CheckBox checkbox4 = new CheckBox("UI/UX");
		CheckBox checkbox5 = new CheckBox("Mobile");
		
		field.getChildren().addAll(courseLabel, checkbox1, checkbox2, checkbox3, checkbox4, checkbox5);
		
		return field;
	}
	
	
	// mengatur bagian kanan
	public FlowPane rightSide() {
		FlowPane rightFlowPane = new FlowPane();
		
		Label rightLabel = new Label("Right Side");
		ImageView image = new ImageView("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREoRGyXmHy_6aIgXYqWHdOT3KjfmnuSyxypw&s");
		image.setFitWidth(220);
		image.setPreserveRatio(true); // agar ratio nya tetap konsisten
		
		rightFlowPane.getChildren().addAll(rightLabel, image);
		
		return rightFlowPane;
	}

	
	// mengatur tabel
	public void setTable() {
		TableColumn nameColumn = new TableColumn("Name");
		TableColumn genderColumn = new TableColumn("Gender");
		TableColumn courseColumn = new TableColumn("Course");
		
		table.setPrefHeight(150); // set tinggi dari tabel
		table.getColumns().addAll(nameColumn, genderColumn, courseColumn); // tambah kolom ke tabel
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS); // buat set semua column jadi sama ukuran
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
