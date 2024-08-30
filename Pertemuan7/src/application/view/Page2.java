package application.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Page2 {

	// bikin public biar ga perlu getter, tapi kalo kalian lebih nyaman pakai getter gapapa juga
	public BorderPane borderLayout;
	public Scene scene;

	public Page2() {
		borderLayout = new BorderPane();
		scene = new Scene(borderLayout,800,600);
		borderLayout.setCenter(new Label("Page 2")); // kasih label ke layout
	}

}
