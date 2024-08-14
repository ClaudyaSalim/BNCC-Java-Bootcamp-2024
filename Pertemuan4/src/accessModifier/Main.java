package accessModifier;

import teoriAwal.Person;

public class Main {

	public Main() {
		Person person2 = new Person("Budi", 20, "9 September 1994");
//		System.out.println(person2.name); // error karena name aksesnya adalah tipe default
//		System.out.println(person2.age); // error
		User user2 = new User("Budi", 20, "9 September 1994");
		user2.displayUser(); // buat akses data umur di main
	}

	public static void main(String[] args) {
		new Main();

	}

}
