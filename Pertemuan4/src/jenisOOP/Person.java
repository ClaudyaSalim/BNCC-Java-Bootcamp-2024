package jenisOOP;

public abstract class Person { // class parent untuk class Karyawan
	
	// abstraction -> membuat abstract class
	// kalau misalnya classnya tidak akan digunakan sebagai object, hanya sebagai template
	
	// encapsulation -> membiarkan atribut diakses secara tidak langsung melalui getter dan setter
	private String name;
	private int age;
	private String dob;

	public Person(String name, int age, String dob) {
		this.name = name;
		this.age = age;
		this.dob = dob;
	}
	
	// getter & setter -> method utk mendapatkan / mengubah nilai atribut yg akses nya private
	
	// getter -> get[NamaAtribut]
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	
	public String getDob() {
		return dob;
	}

	// setter -> set[NamaAtribut]
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	// abstract method -> kalau misalnya abstract class kalian method ini ga kepake (kecuali utk di override oleh subclass)
	public abstract void gajian(); 

}
