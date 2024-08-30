package Multithreading;

public class ThreadTwo implements Runnable{ // bikin thread pakai implements runnable

	public ThreadTwo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() { // isi thread
		int count = 10;
		try {
			while(count>=1) {
				System.out.println("This is thread two " + count);
				Thread.sleep(2000); // buat kasih delay / pause selama 1000 milli detik = 1 detik
				count--;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
