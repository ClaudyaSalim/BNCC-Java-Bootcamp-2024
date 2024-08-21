package application;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuiPert5 extends GridPane{
	
	TableView table; TextField nameInput; Spinner ageSpinner; RadioButton maleBtn; RadioButton femaleBtn;
	ArrayList<CheckBox>checkboxes = new ArrayList<>();

	public GuiPert5() {
		Label bottom = new Label("Bottom");
				
		table = new TableView();
		setTable();
				
		this.add(initForm(), 0, 0);
		this.add(rightSide(), 1, 0);
		this.add(table, 0, 1, 2, 1);
				
		ColumnConstraints kolom1 = new ColumnConstraints();
		kolom1.setPercentWidth(50);
		ColumnConstraints kolom2 = new ColumnConstraints();
		kolom2.setPercentWidth(50);
				
		this.getColumnConstraints().addAll(kolom1, kolom2);
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(20);
	}
	
	
	// mengatur tampilan form
	public VBox initForm() {
		VBox form = new VBox(20); // spacing antara elemen = 20
		
		Label leftSide = new Label("Registration Form");
		
		HBox name = nameField();
		FlowPane gender = genderField();
		FlowPane age = new FlowPane();
		Label ageLabel = new Label("Age:");
		ageSpinner = new Spinner(15, 40, 0);
			
		// contoh pakai change listener
		ageSpinner.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				System.out.println("User's age: " + ageSpinner.getValue());
			}
				
		});
			
		// contoh pakai mouse listener utk aksi mouse click
		ageSpinner.setOnMouseClicked(event -> {
			System.out.println(ageSpinner.getValue());
		});
		age.getChildren().addAll(ageLabel, ageSpinner);
		
		
		FlowPane course = courseField();
		Button submitBtn = new Button("Submit");
		submitBtn.setPrefSize(200, 16); 
			
		// mouse listener dlm bentuk lambda expression
		submitBtn.setOnMouseClicked(event -> {
			// code disini
					
			String nameText = nameInput.getText();
//			System.out.println(nameText);
					
			String genderText="";
			if(maleBtn.isSelected()) {
				genderText = "Male";
			}
			else if(femaleBtn.isSelected()) {
				genderText = "Female";
			}
				
			int ageNum = (int) ageSpinner.getValue();
			
			String courses="";
			for(CheckBox courseCheckBox : checkboxes) {
				if(courseCheckBox.isSelected()) {
					courses += courseCheckBox.getText() + "; ";
				}
			}
				
			User newUser = new User(nameText, genderText, ageNum, courses);
//			table.getItems().add(newUser);
				
			alertConfirm(newUser);
		} );
			
		form.getChildren().addAll(leftSide, name, gender, age, course, submitBtn);
			
		return form;
	}
		
		
	// mengatur input utk name
	public HBox nameField () {
		HBox field = new HBox(10); // spacing antara elemen = 10
		
		Label nameLabel = new Label("Name:");
		nameInput = new TextField();
		
		// key listener
		nameInput.setOnKeyPressed(event -> {
			if(event.getCode()==KeyCode.ENTER) {
				String nameText = nameInput.getText();
				if(nameText.length()<3) {
					System.out.println("Name must be at least 3 characters!");
				}
			}
		});
			
		field.getChildren().addAll(nameLabel, nameInput);
		
		return field;
	}
		
		
	// mengatur input utk gender
	public FlowPane genderField() {
		FlowPane field = new FlowPane(20, 10); // spacing horizontal = 20, vertikal = 10
		Label genderLabel = new Label("Gender:");
		
		ToggleGroup genderBtn = new ToggleGroup(); // bikin toggle group biar pilih radio button hanya bisa salah 1
		maleBtn = new RadioButton("Male");
		femaleBtn = new RadioButton("Female");
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
		checkboxes.add(checkbox1);
		checkboxes.add(checkbox2);
		checkboxes.add(checkbox3);
		checkboxes.add(checkbox4);
		checkboxes.add(checkbox5);
			
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
		table = new TableView<User>();
		TableColumn nameColumn = new TableColumn("Name");
		TableColumn genderColumn = new TableColumn("Gender");
		TableColumn ageColumn = new TableColumn("Age");
		TableColumn courseColumn = new TableColumn("Course");
			
		table.setPrefHeight(150); // set tinggi dari tabel
		table.getColumns().addAll(nameColumn, genderColumn, ageColumn, courseColumn); // tambah kolom ke tabel
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS); // buat set semua column jadi sama ukuran
			
		// setting tipe data utk setiap kolom
		// kolom.setCellValueFactory(new PropertyValueFactory<Class, TipeData)("nama atributnya"));
		// jika muncul error "Can not retrieve property 'name' in PropertyValueFactory" -> ke module-info
		// lalu pastikan ada "requires javafx.base" dan "javafx.base di opens application to..".
		nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
		courseColumn.setCellValueFactory(new PropertyValueFactory<User, String>("courses"));
			
		table.getItems().add(new User("Test User", "Female", 20, "Java, UI/UX"));
			
	}
		
	public void alertConfirm(User newUser) {
		Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
		confirmAlert.setTitle("Confirm");
		confirmAlert.setHeaderText("Submit user data");
		confirmAlert.setContentText("Are you sure you want to submit?");
		Optional<ButtonType> button = confirmAlert.showAndWait();
		if(button.get() == ButtonType.OK) {
			alertInfo();
			table.getItems().add(newUser);
		}
	}
		
	public void alertInfo() {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("Sucess");
		infoAlert.setHeaderText("Submit user data");
		infoAlert.setContentText("User data sucessfully submitted");
		infoAlert.show();
	}

}
