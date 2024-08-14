package teoriAwal;

public class Person { // suatu class -> template object
	
	// atribut / karakteristik object nya

	String name; // aksesnya default -> diakses oleh file di package yg sama
	protected int age; // akses protected -> akses default + diakses oleh subclass
	private String dob; // akses private -> diakses di class ini saja

	
	// constructor -> initialisasi atributnya
	public Person(String nameParam, int ageParam, String dobParam) { // bisa diakses dimana saja (selama 1 project)
		this.name = nameParam;
		this.age = ageParam;
		this.dob = dobParam;
	}
	
	
	// method terdiri dari:
	// keyword access modifier (public)		tipe data method (void)		nama methodnya 
	
	public void display() { // method utk menjalankan code saja
		
	}
	
	public int add() { // method utk simpan nilai seperti variabel
		return 2+3;
	}

}
