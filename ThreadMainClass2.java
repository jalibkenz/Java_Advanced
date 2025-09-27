class Demand implements Runnable{
	public void run() {
		for(int i=110;i>100;i++) {
		System.out.println(i);
		try {
			Thread.sleep(500);
			}catch (InterruptedException e) {
				e.printStackTrace();
				
			}
		}
	}
}
public class ThreadMainClass2 {
	public static void main(String[] args) {
		Demand d=new Demand();
		Thread t1=new Thread(d);
		t1.start();
	}

}