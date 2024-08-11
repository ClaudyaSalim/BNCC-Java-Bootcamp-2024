package pertemuan3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<String>listKaryawan = new ArrayList<>();
	File fileK = new File("file-karyawan.txt"); // buat akses filenya & bikin variabel
	File folderData = new File("Data-Karyawan"); // utk akses folder juga harus initialisasi seperti akses file

	public Main() { // constructor
//		simpleException();
		
		int choice = 0;
		
		do {
			
			System.out.println("Sistem Karyawan");
			System.out.println();
			System.out.println("1. Tambah Karyawan");
			System.out.println("2. Lihat Karyawan");
			System.out.println("3. Update Karyawan");
			System.out.println("4. Hapus Karyawan");
			System.out.println("5. Hapus File Karyawan");
			System.out.println("6. Keluar");
			
			// try and catch
			try {
				System.out.print("Masukkan menu pilihan: ");
				choice = scan.nextInt(); // input 1, pencet enter
				scan.nextLine(); // tampung karakter enternya
			}
			catch (InputMismatchException errorInput) {
				errorInput.printStackTrace(); // template error
				System.out.println("Masukkan menu angka!");
			}
			
			try {
				cekFileKaryawan(choice); // masukkan pilihan menu ke dalam method
				System.out.println();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			switch(choice) {
				case 1:
					// tambah karyawan
					addKaryawan();
					break;
				case 2:
					// lihat karyawan
					viewKaryawan();
					break;
				case 3:
					// update karyawan
					editKaryawan();
					break;
				case 4:
					// hapus karyawan
					deleteKaryawan();
					break;
				case 5:
					// hapus file
					fileK.delete(); // kalau file ga kehapus coba restart eclipsenya & run lagi
					
					// kalian juga bisa delete folder seperti file
					folderData.delete();
//					System.out.println(fileK.delete());
					
					// hapus juga semua data di arraylist
					listKaryawan.clear();
					break;
				case 6:
					// exit
					System.out.println("Sampai jumpa!");
					break;
				default:
					System.out.println("Tidak ada pilihan menu tersebut");
					break;
			}
			System.out.println();
			System.out.println("Tekan enter untuk lanjut ...");
			scan.nextLine();
			System.out.println(); // print enter
			System.out.println();
			System.out.println();
			
		}while(choice!=6);

	}
	
	
	// cek apakah file sudah ada sebelumnya, kalau tidak buat file baru
	void cekFileKaryawan(int choiceMenu) throws IOException {
		
		if(choiceMenu==5 || choiceMenu==6) { // kalau menu pilihan adalah 5 (hapus) atau 6 (keluar)
			return; // tidak perlu membuat atau cek file tsb ada
		}
		
		else if(fileK.exists()) {
			System.out.println("File karyawan sudah dibuat sebelumnya!");
			System.out.println(fileK.getPath());
			// lebih baik kita baca data dari file terlebih dahulu dan simpan di arraylist sebelum lanjut
			// kalau sebelumnya kita sudah baca data file & isi ke array list, kita tidak perlu baca lagi
			if(listKaryawan.size()==0) {
				initDataFromFile(); // isi dari method ini ada dibawah cekFileKaryawan()
			}
		}
		
		else { 
			fileK.createNewFile(); // perlu bikin file biar ga error
			folderData.mkdir(); // membuat folder baru
			throw new IOException("Membuat file karyawan baru"); // message custom
		}
		
	}
		
		
	// buat baca file dan simpan ke array list
	void initDataFromFile() {
		try {
			FileReader bacaFile = new FileReader(fileK);
			int buffer = bacaFile.read();
			while(buffer!=-1) { // -1 -> akhir dari file
				
				// kita ingin bikin setelah baca sampai newline / enter, karakter tersebut dibuat string dan disimpan di arraylist
				String nama = ""; // buat string utk menampung hasil baca file sementara
				
				// tambahkan loop utk cek sampai karakter enter
				// 1. ubah hasil baca file (integer) ke karakter (char)
				// 2. bandingkan dengan karakter enter "\n", jika bukan maka lanjut read file, jika iya maka stop
				while ((char)buffer!='\n') {
					nama = nama + (char)buffer; // sambungkan string dengan karakter yang dibaca dan simpan
					buffer = bacaFile.read(); // baca karakter file berikutnya
				}
				
				// tambahkan string hasil baca karakter ke arraylist
				listKaryawan.add(nama);
				
				buffer = bacaFile.read(); // baca karakter file berikutnya
			}
			bacaFile.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// buat tulis ke file, semisal kita ada update di karyawan (add, edit, delete) bisa tinggal panggil
	void writeToFile() {
		try {
			FileWriter tulisFile = new FileWriter(fileK);
			for(String karyawan:listKaryawan) {
				tulisFile.write(karyawan + "\n"); // \n -> karakter buat enter
			}
			tulisFile.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File gagal ditulis");
		}
	}
	
	
	// tambah karyawan
	void addKaryawan() {
		String nama;
		System.out.print("Masukkan nama karyawan: ");
		nama = scan.nextLine();
		listKaryawan.add(nama);
		System.out.println("Karyawan berhasil ditambahkan ke sistem!");
		
		// code buat write atau tulis ke file yg dibahas di pertemuan pindah ke method writeToFile diatas ya
		writeToFile();
	}
	
	
	// lihat karyawan
	void viewKaryawan() {
		System.out.println("List Karyawan: ");
		
		if(listKaryawan.size()==0) {
			System.out.println("Tidak ada karyawan saat ini");
			return; // stop dan balik ke constructor
		}
		
		// print karyawan dari file
		try {
			FileReader bacaFile = new FileReader(fileK);
			int buffer = bacaFile.read();
			while(buffer!=-1) { // -1 -> akhir dari file
				System.out.print((char)buffer); // print karakternya
				buffer = bacaFile.read(); // baca karakter berikutnya
			}
			bacaFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print karyawan dari array list
//		for(int i=0; i<listKaryawan.size(); i++) {
//			System.out.print(i+1 + ". ");
//			System.out.println(listKaryawan.get(i));
//		}
	}
	
	
	// update karyawan
	void editKaryawan() {
		
		if(listKaryawan.size()==0) {
			return; // stop dan balik ke constructor
		}
		
		viewKaryawan(); // print listnya agar bisa dilihat
		System.out.println();
		
		// cari tahu urutan karyawan yg ingin diganti (sesuai penomoran biasa yg dimulai dari 1)
		int urutan;
		do {
			System.out.print("Masukkan urutan karyawan yang ingin diperbarui: ");
			urutan = scan.nextInt();
			scan.nextLine();
		} while(urutan<1 || urutan>listKaryawan.size()); // scan akan berjalan ulang kalau urutan yg diinput kurang dari 1 atau lebih dari ukuran arraylist
		
		// minta user input nama yang baru
		String namaBaru;
		System.out.print("Masukkan nama baru karyawan: ");
		namaBaru = scan.nextLine();
		// update di array list, urutannya dikurangi 1 agar bisa mengikuti penomoran index (yg mulai dari 0)
		listKaryawan.set(urutan-1, namaBaru);
		System.out.println("Nama karyawan berhasil diperbarui!");
		
		// tulis file ulang dengan data yang baru
		writeToFile();
	}
	
	
	// hapus karyawan
	void deleteKaryawan() {
		if(listKaryawan.size()==0) {
			return; // stop dan balik ke constructor
		}
		
		viewKaryawan(); // print listnya agar bisa dilihat
		System.out.println();
		
		// cari tahu urutan karyawan yg ingin diganti (sesuai penomoran biasa yg dimulai dari 1)
		int urutan;
		do {
			System.out.print("Masukkan urutan karyawan yang ingin dihapus: ");
			urutan = scan.nextInt();
			scan.nextLine();
		} while(urutan<=0 || urutan>listKaryawan.size()); // scan akan berjalan ulang kalau urutan yg diinput kurang dari 1 atau lebih dari ukuran arraylist
		
		// hapus dari array list, urutannya dikurangi 1 agar bisa mengikuti penomoran index (yg mulai dari 0)
		listKaryawan.remove(urutan-1);
		System.out.println("Karyawan berhasil dihapus dari sistem!");
		
		// tulis file ulang dengan data yang baru
		writeToFile();
	}
	
	
	// contoh exception
	void simpleException() {
		int pembagian = 5/0; // arithmetic exception
		// null pointer exception
		ArrayList<String>array = null;
		array.add("Hello!");
	}

	
	public static void main(String[] args) {
		new Main();

	}

}
