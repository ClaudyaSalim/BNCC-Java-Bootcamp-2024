package Multithreading;

public class ThreadOne extends Thread{ // bikin thread pakai extends

	public ThreadOne() {
		// TODO Auto-generated constructor stub
	}

	public void run() { // isi thread
		int count = 1;
		try {
			while(count<=10) {
				System.out.println("This is thread one: " + count);
				sleep(1000); // buat kasih delay / pause selama 1000 milli detik = 1 detik
				count++;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
