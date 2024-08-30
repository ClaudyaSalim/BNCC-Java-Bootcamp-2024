package generic;

import java.util.ArrayList;

public class Main {
	
	// contoh penerapan di array list
	ArrayList<String> listStrings = new ArrayList();
	ArrayList<Integer> listInteger = new ArrayList();

	public Main() {
		GenericClass <String> classString = new GenericClass<String>("Java", "Java"); // bikin object dari generic class
		classString.compareAttributes(); // panggil method
		
		// bikin object baru dengan tipe data yg berbeda
		GenericClass classInt = new GenericClass(1, 2);
		classInt.compareAttributes();
	}

	public static void main(String[] args) {
		new Main();
	}

}
