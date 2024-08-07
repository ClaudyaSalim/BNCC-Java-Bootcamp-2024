package Pertemuan1;

import java.util.Scanner; // import dari package buat Scanner

public class Main {
	
	// variabel global
	Scanner scan = new Scanner(System.in);
	int angka2 = 2;

	// constructor
	public Main() {
		double pembagian = 2.0/3.0; // angka desimal
		System.out.println(pembagian);
		
//		int angkaDesimal = 2.5 // 2.0
		
		float angkaDesimal = (float) 0.666666666666666667; // casting -> buat ganti ke tipe data lain
		System.out.println(angkaDesimal);
		
//		Scanner scan = new Scanner(System.in); // variabel lokal
		System.out.println("Hasil scan: ");
//		String hasilScan = scan.next(); // scan sampai ' '
		String hasilScan1 = scan.nextLine(); // scan sampai enter atau '\n'
		System.out.println(hasilScan1);
		
		System.out.println(angka2);
		
		display();
		
		selection(); // -> buat selection
		
		repetition(); // buat repetition
	}
	
	
	public void display() {
		// String and char
		char huruf = '$'; // 1 karakter
		String kata = "Java " + "Programming"; // beberapa karakter 
		String kataConcat = kata.concat("Session"); // alternatif utk concat
		System.out.println(huruf);
		System.out.println(kata);
		System.out.println(kata.charAt(0));
		System.out.println("Panjang dari kata: " + kata.length()); // concat
		
//		String hasilScan2 = scan.nextLine(); // contoh akses variabel global buat scanner
	}
	
	
	// function buat selection
	public void selection() {
		// 1. Ternary
		String kata = (6%3==1)? "Ya" : "Tidak";
		System.out.println(kata);
		
		// 2. If else
		int num = 5;
		if(num<5) {
			System.out.println("Num kurang dari 5");
		}
		else if (num==5) {
			System.out.println("Num adalah 5");
		}
		else {
			System.out.println("Num lebih dari 5");
		}
		
		// 3. Switch Case
		String huruf = "a";
		switch(huruf) {
		case "a":
			System.out.println("Huruf adalah a");
			break;
		case "b":
			System.out.println("Huruf adalah b");
			break;
		case "c":
			System.out.println("Huruf adalah c");
			break;
		default:
			System.out.println("Huruf bukan a, b, atau c");
			break;
		}
	}
	
	
	// function buat repetition
	public void repetition() {
		
		// 1. For
		System.out.println("Loop For");
		for(int i=0; i<10; i++) {
			System.out.println(i);
		}
		int [] arrAngka = {1, 2, 10, 35, 8};
		// for each
		for(int angka:arrAngka) {
			System.out.println(angka);
		}
		for(int i=0; i<5; i++) {
			System.out.println(arrAngka[i]);
		}
		
		// 2. While
		System.out.println("Loop While");
		int index = 0;
		while(index!=0) { // cek kondisi dulu baru jalanin kalau benar
			System.out.println(index);
//			index--;
			index = 0;
		}
		
		// 3. Do While
		System.out.println("Loop Do While");
		int idx = 0;
		do {
			System.out.println(idx);
//			idx--;
			idx = 0;
		} while (idx!=0); // jalanin dulu sekali baru cek kondisi kalau benar lanjutin lagi
	}
	

	public static void main(String[] args) {
		
		int angka = 1; // angka bulat
		System.out.println(angka);
		
		boolean cek= 2==3; // nilai kondisi: true / false
		System.out.println(cek);
		
		new Main();

	}

}
