class Tester extends Thread {
	public void run() {
		for (int i = 100; i < 110; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}
}

public class ThreadMainClass1 {

	public static void main(String[] args) {
		Tester t1 = new Tester();
		t1.start();
	}

}