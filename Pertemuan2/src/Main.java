import java.util.ArrayList;
import java.util.Vector;

public class Main {

	public Main() {
		
		stringAndMath(); // function / method buat codingan String & Math
		
		// array
		
		int[]nilai = new int[5]; // array kosong dengan panjang 5
//		int[]nilai = {20, 100, 50, 36}; // array sama dengan nilainya
		nilai[0] = 20; // urutan awal -> index 0
		nilai[4] = 75; // urutan akhir -> index panjang array - 1
//		for(int angka:nilai) {
//			System.out.println(angka);
//		}
		
		String[]listNama = new String[4];
//		for(String nama:listNama) {
//			System.out.println(nama);
//		}
		
		// 2d array
		String[][] listKelas = new String[2][4];
		listKelas[0][0] = "Andi";
		listKelas[0][1] = "Budi";
		listKelas[0][2] = "Caca";
		
		listKelas[1][0] = "Dodi";
		listKelas[1][1] = "Lisa";
		listKelas[1][2] = "Nana";
		listKelas[1][3] = "Salsa";
		
		// Andi, Budi, Caca
		// Dodi, Lisa, Nana, Salsa
		
		for(int i=0; i<2; i++) {
			System.out.println("Baris ke-" + i + ":");
			for(int j= 0; j<4; j++) {
				System.out.print(listKelas[i][j]);
				System.out.print(" ");
				// setelah ini j nya nambah tapi i nya tetap sama
			}
			System.out.println();
			// setelah ini i nya nambah, loop j nya dijalanin lagi
		}
		System.out.println();
		
		// dynamic array
		
//		ArrayList<String>listQuotes = new ArrayList<>();
		Vector<String>listQuote = new Vector<>();
		listQuote.add("Never give up"); // index 0
		listQuote.add("Believe in yourself"); // index 1
		listQuote.add("Always do your best"); // index 2
//		System.out.println("Panjang dari list quote sebelum add: " + listQuote.size()); // panjang dari vector
		listQuote.add("Love yourself"); // index 3
//		System.out.println("Panjang dari list quote setelah add: " + listQuote.size()); // panjang dari vector
//		listQuote.remove(2); // di comment biar ga bikin bingung
		for(String quote:listQuote) {
			System.out.println(quote);
		}
//		System.out.println(listQuote.size()); // ukuran setelah diremove
		listQuote.set(0, "Don't give up"); // buat ganti isi dari array (index, nilai baru)
		System.out.println("Quote setelah diganti: " + listQuote.get(0)); // mendapatkan quote di array index 0
		System.out.println();
		
		double random = Math.random(); // 0.0 - 0.9999999
		System.out.println(random);
		
		double randomNum = Math.random()*3; // 0.0 - 2.99999
		System.out.println(randomNum);
		
		int randomIndex = (int) Math.round(randomNum); // return long, biar ga error kita melakukan casting (convert tipe data)
		System.out.println(randomIndex);
		
		System.out.println("Hasil randomize quote: " + listQuote.get(randomIndex)); // print quote yg didapet dari list dgn index yg kita random
	}
	
	
	// function / method isi code tentang String & Math
	void stringAndMath () {
		
		// String
		String str = "Hello World!";
		System.out.println(str.compareTo("Hello")); // membandingkan jumlah karakter dari kedua string, kalau 0 berarti stringnya sama, kalau <0 karakternya lebih sedikit, kalau >0 karakternya lebih banyak
		System.out.println(str.concat(" in Java")); // menggabungkan string dgn string lain
		
		System.out.println(str.equals("hello world")); // cek apakah isi string sama dengan string lain
		System.out.println(str.equalsIgnoreCase("hello world!")); // sama dengan equals (huruf kapital diabaikan)
		
		System.out.println(str.indexOf(" ")); // cek indeks dari karakter yang dicari di string
		
		System.out.println(str.endsWith("World!")); // cek apakah string diakhiri dengan karakter tersebut
		System.out.println(str.startsWith("Hello")); // cek apakah string dimulai dengan karakter tersebut
		
		System.out.println("Length of String str: " + str.length()); // panjang string
		
		String bagianAkhir = str.substring(6); // start index -> ambil bagian string dari index tertentu sampai akhir string
		System.out.println(bagianAkhir);
		String substring = str.substring(3, 8); // start index, end Index = index karakter yg kita gamau ambil dari situ
		System.out.println(substring);
		
		System.out.println(str.toLowerCase()); // bikin jadi huruf kecil semua
		System.out.println(str.toUpperCase()); // bikin jadi huruf besar semua
		
		System.out.println(str.contains(" ")); // cek apakah string punya karakter tersebut
		System.out.println();
				
		
		// Math
		System.out.println(Math.min(3, 10)); // cari angka yg lebih kecil -> 3
		System.out.println(Math.max(3, 10)); // cari angka yg lebih besar -> 10
		System.out.println(Math.round(3.5)); // buletin seperti biasa dan return tipe angka bulat
		System.out.println(Math.ceil(3.5)); // buletin ke atas
		System.out.println(Math.floor(3.83)); // buletin ke bawah
		double pi = 22/7;
		System.out.println(Math.sin(pi/2)); // buat sin cos tan kita masukin dalam satuan radian
		System.out.println(Math.cos(0));
		System.out.println(Math.tan(pi/3));
		System.out.println(Math.sqrt(4)); // akar 2
		System.out.println(Math.abs(-5)); // absolut -> mengubah semua nilai menjadi positif
		System.out.println();
	}
	

	public static void main(String[] args) {
		new Main();

	}

}
