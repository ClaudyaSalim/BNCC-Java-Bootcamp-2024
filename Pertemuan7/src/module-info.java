module Pertemuan7 {
	requires javafx.controls;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;

	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens application.model to javafx.base; // biar ga error saat set cell value property di tabel buat object Menu
}
