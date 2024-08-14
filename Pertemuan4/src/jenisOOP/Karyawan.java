package jenisOOP;

public class Karyawan extends Person implements Rules{ 
	// contoh inheritance dengan extends suatu class & abstraction dengan abstract class & interface
	// kalian bisa menambah interface utk implement dengan kasih koma
	
	// atribut tambahan
	private String divisi;

	public Karyawan(String name, int age, String dob, String divisi) {
		super(name, age, dob); // initialisasi constructor class Parent
		this.divisi = divisi; // initialisasi atribut tambahan
	}

	
	// getter & setter
	public String getDivisi() {
		return divisi;
	}

	public void setDivisi(String divisi) {
		this.divisi = divisi;
	}
	
	
	// polymorphism overriding
	@Override
	public void gajian() {
		System.out.println("Karyawan " + this.getName() + " telah menerima gaji bulan ini");
	}
	
	
	// polymorphism overloading
	
	// print detail karyawan
	public void printData() {
		System.out.println("Data karyawan: ");
		System.out.println("Nama: " + this.getName());
		System.out.println("Umur: " + this.getAge());
		System.out.println("Divisi: " + this.getDivisi());
	}
	
	// print laporan
	public void printData(String bulan, int laporan) {
		System.out.println("Dalam bulan " + bulan
				+ ", " + this.getName() + 
				" telah mengerjakan sebanyak " + laporan + " laporan.");
	}

	
	// hasil implement interface (diwajibkan menerapkan overriding methodnya)
	@Override
	public void printPelanggaran() {
		System.out.println(this.getName() + " melanggar peraturan: " + rule1);
	}

}
