package Multithreading;

public class Main {

	public Main() {
//		Thread thread1 = new Thread();
		ThreadOne thread1 = new ThreadOne(); // bikin object thread
		ThreadTwo runnable2 = new ThreadTwo(); // bikin object runnable
		Thread thread2 = new Thread(runnable2); // runnable di convert ke thread
		
		System.out.println("Current thread: " + Thread.currentThread().getName()); // dapat nama thread saat ini
		thread1.setPriority(10); // set prioritas paling tinggi
		thread2.setPriority(1); // set prioritas paling rendah
		
		System.out.println("Thread 1 name: " + thread1.getName());
//		thread1.start();
		thread1.run(); // buat jalanin thread
		
		System.out.println("Thread 2 name: " + thread2.getName());
		thread2.run();
		try {
			thread2.join(); // tahan sampai thread lain selesai dulu baru jalan
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread 1 priority: " + thread1.getPriority()); // dapat prioritas
		System.out.println("Thread 2 priority: " + thread2.getPriority());
	}

	public static void main(String[] args) {
		new Main();

	}

}
