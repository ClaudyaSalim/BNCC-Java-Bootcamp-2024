package teoriAwal;

public class Main {

	public Main() { // ini method constructor
		
		// konsep prosedural
		String personName1 = "Andi";
		int personAge1 = 30;
		
		String personName2 = "Dodi";
		int personAge2 = 20;
		
		
		
		// konsep OOP
		Person person1 = new Person("Andi", 30, "4 April 1984"); // kumpulan data utk membuat object Person
		System.out.println(person1.name); // Andi
		System.out.println(person1.age);
//		System.out.println(person1.dob); // error karena dob tipe aksesnya private
		
	}

	public static void main(String[] args) {
		new Main(); // panggil constructor

	}

}
