package application.view;

import application.controller.MenuController;
import application.model.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Page1View implements EventHandler<ActionEvent>{

	public BorderPane borderLayout; public GridPane gridLayout;
	public Scene scene;
	public SideBar sideBar;
	public MenuController controller = new MenuController(); // panggil class MenuController dengan initialisasi

	Label id;
	TextInput nameInput;
	TextInput categoryInput;
	TextInput priceInput;
	TextInput idInput;
	Button addBtn; Button updateBtn; Button deleteBtn; Button clearBtn;
	TableView <Menu>table;

	public Page1View() {
		borderLayout = new BorderPane();
		scene = new Scene(borderLayout,800,600);
		initView();
	}


	public void initView() {
		Label titleLabel = new Label("Page 1");
		titleLabel.setPrefSize(800, 50);
		titleLabel.setAlignment(Pos.CENTER);
		titleLabel.setBackground(Background.fill(Color.ALICEBLUE));
		borderLayout.setTop(titleLabel);

		sideBar = new SideBar("Page 2", "Page 3");
		borderLayout.setLeft(sideBar);

		gridLayout = new GridPane();
		gridLayout.add(formView(), 0, 0);
		gridLayout.add(setTable(), 1, 0);

		ColumnConstraints kolom1 = new ColumnConstraints();
		kolom1.setPercentWidth(50);
		ColumnConstraints kolom2 = new ColumnConstraints();
		kolom2.setPercentWidth(50);

		gridLayout.getColumnConstraints().addAll(kolom1, kolom2);
		gridLayout.setPadding(new Insets(20));
		gridLayout.setHgap(20);
		gridLayout.setVgap(20);
		borderLayout.setCenter(gridLayout);
	}


	public VBox formView() {
		VBox form = new VBox(20);
		idInput = new TextInput("ID");
		idInput.inputField.setDisable(true); // di set disable biar ga sembarangan di edit
		nameInput = new TextInput("Name");
		categoryInput = new TextInput("Category");
		priceInput = new TextInput("Price");
		addBtn = new Button("Add");
		addBtn.addEventHandler(ActionEvent.ACTION, this);
		updateBtn = new Button("Update");
		updateBtn.addEventHandler(ActionEvent.ACTION, this);
		deleteBtn = new Button("Delete");
		deleteBtn.addEventHandler(ActionEvent.ACTION, this);
		// tambahan
		clearBtn = new Button("Clear");
		clearBtn.addEventHandler(ActionEvent.ACTION, this);
		form.getChildren().addAll(idInput, nameInput, categoryInput, priceInput,
				addBtn, updateBtn, deleteBtn, clearBtn);
		return form;
	}


	public TableView setTable() {
		table = new TableView();

		TableColumn idCol = new TableColumn("ID");
		TableColumn nameCol = new TableColumn("Name");
		TableColumn categoryCol = new TableColumn("Category");
		TableColumn priceCol = new TableColumn("Price");

		idCol.setCellValueFactory(new PropertyValueFactory<Menu, String>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Menu, String>("name"));
		categoryCol.setCellValueFactory(new PropertyValueFactory<Menu, String>("category"));
		priceCol.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("price"));

		table.getColumns().addAll(idCol, nameCol, categoryCol, priceCol);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		table.setItems(controller.listMenu); // masukin isi (observable list) ke table view

		// kalau mau set isi form menjadi item yg diklik di tabel
		table.setOnMouseClicked(event -> {
			Menu menu = table.getSelectionModel().getSelectedItem();
			idInput.inputField.setText(menu.getId());
			nameInput.inputField.setText(menu.getName());
			categoryInput.inputField.setText(menu.getCategory());
			String price = String.valueOf(menu.getPrice()); // ubah integer dari price menu jadi string dengan valueOf()
			priceInput.inputField.setText(price);
		});

		return table;
	}


	public void clearForm() { // buat reset isi textfield
		idInput.inputField.clear();
		nameInput.inputField.clear();
		categoryInput.inputField.clear();
		priceInput.inputField.clear();
	}


	@Override
	public void handle(ActionEvent event) {

		// dapetin isi dari textfield
		String id = idInput.inputField.getText();
		String name = nameInput.inputField.getText();
		String category = categoryInput.inputField.getText();

		// cek sumber aksi nya
		if(event.getSource()==addBtn) {
			int price = Integer.parseInt(priceInput.inputField.getText()); // convert string ke integer pakai parsing
			controller.addMenu(name, category, price); // panggil method add dari MenuController

		}
		else if(event.getSource()==updateBtn) {
			int price = Integer.parseInt(priceInput.inputField.getText());
			controller.updateMenu(id, name, category, price); // panggil method update dari MenuController
		}
		else if(event.getSource()==deleteBtn) {
			controller.deleteMenu(id); // panggil method delete dari MenuController
		}

		// tambahan dari materi sebelumnya
		clearForm(); // kalau mau hapus isi textfield -> methodnya ada diatas
		controller.fillListMenu(); // buat isi ulang list -> liat MenuController

		// tdk perlu set tabel ulang krn tabel bisa update sesuai isi observable list yg sudah diupdate

	}
}
