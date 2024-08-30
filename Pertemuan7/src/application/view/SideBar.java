package application.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SideBar extends VBox{ // langsung jadiin class VBox (tanpa perlu bikin variabel & inisialisasi)

	public Label sideMenu1; public Label sideMenu2;

	public SideBar(String sideMenu1Name, String sideMenu2Name) {
		setPadding(new Insets(10));
		setPrefSize(80, 600);
		setBackground(Background.fill(Color.SPRINGGREEN));
		sideMenu1 = new Label(sideMenu1Name);
		sideMenu2 = new Label(sideMenu2Name);
		getChildren().addAll(sideMenu1, sideMenu2); // tambahin label ke class yg udah jadi VBox
	}

}
