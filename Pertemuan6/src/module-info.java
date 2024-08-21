module Pertemuan6 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	requires jfxtras.labs.samples;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
