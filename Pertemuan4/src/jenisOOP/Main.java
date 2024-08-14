package jenisOOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// menerapkan OOP dengan object scanner & arraylist
	Scanner scan = new Scanner(System.in);
	ArrayList<Karyawan>listKaryawan = new ArrayList<>();

	public Main() {
//		Person person1 = new Karyawan("Lala", 20, "2 Februari 2004");
//		person1.name; // tidak disarankan oleh encapsulation
		
		int menu;
		
		do {
			System.out.println("Sistem Karyawan");
			System.out.println("1. Tambah Karyawan");
			System.out.println("2. Lihat Karyawan");
			System.out.println("3. Gajian");
			System.out.println("4. Print Data");
			System.out.println("5. Lapor Pelanggaran");
			System.out.println("6. Keluar");
			System.out.print("Masukkan menu: ");
			menu = scan.nextInt(); scan.nextLine();
			
			switch (menu) {
				case 1: 
					add();
					break;
				case 2:
					view();
					break;
				case 3:
					// code gajian
					for(Karyawan k:listKaryawan) {
						k.gajian();
					}
					break;
				case 4:
					karyawanPrint();
					break;
				case 5:
					System.out.print("Masukkan nama karyawan yang melanggar: ");
					String name = scan.nextLine();
					for(Karyawan k:listKaryawan) {
						if(k.getName().equals(name)) {
							k.printPelanggaran();
						}
					}
					break;
				case 6:
					System.out.println("Sampai jumpa!");
					break;
				default:
					System.out.println("Masukkan menu yang valid!");
			}
			System.out.println();
			System.out.println("Tekan Enter untuk lanjut ...");
			scan.nextLine();
			System.out.println();
			System.out.println();
		} while(menu!=6);
	}
	
	
	public void add() {
		String name; int age; String dob; String divisi;
		
		do {
			System.out.print("Masukkan nama karyawan: ");
			name = scan.nextLine();
		} while(name.equals(""));
		
		do {
			System.out.print("Masukkan umur karyawan: ");
			age = scan.nextInt(); scan.nextLine();
		} while(age<18);
		
		do {
			System.out.print("Masukkan tanggal lahir karyawan: ");
			dob = scan.nextLine();
		} while(dob.equals(""));
		
		do {
			System.out.print("Masukkan divisi karyawan: ");
			divisi = scan.nextLine();
		} while(divisi.equals(""));
		
		Karyawan newPerson = new Karyawan(name, age, dob, divisi); // berhasil membuat object baru
		listKaryawan.add(newPerson);
		
	}
	
	
	public void view() {
		System.out.println("List Karyawan:");
		System.out.println();
		for(int i=0; i<listKaryawan.size(); i++) {
			Karyawan karyawan = listKaryawan.get(i);
			System.out.println("Karyawan " + (i+1));
			System.out.println("Nama: " + karyawan.getName()); // akses atribut karyawan dari memanggil getter
			System.out.println("Divisi: " + karyawan.getDivisi());
			System.out.println();
		}
	}
	
	
	public void karyawanPrint() {
		System.out.println("Pilih opsi dibawah ini: ");
		System.out.println("a. Print Data Karyawan");
		System.out.println("b. Print Laporan Karyawan");
		String opsi = scan.nextLine();
		if(opsi.equals("a")) {
			for(Karyawan k:listKaryawan) {
				k.printData(); // polymorphism overloading -> lihat file karyawan
				System.out.println();
			}
		}
		else if (opsi.equals("b")) {
			String bulan = "Agustus"; int totalLaporan = 100;
			for(Karyawan k:listKaryawan) {
				k.printData(bulan, totalLaporan); // polymorphism overloading -> lihat file karyawan
			}
		}
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
