package application.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TextInput extends VBox{ // langsung jadiin class VBox (tanpa perlu bikin variabel & inisialisasi)

	Label label; TextField inputField;

	public TextInput(String labelName) {
		label = new Label(labelName); // set isi label menjadi string yg diterima di parameter constructor
		inputField = new TextField();
		getChildren().addAll(label, inputField); // tambahin label ke VBox
		setSpacing(10); // buat set jarak antara elemen di VBox
	}

}
