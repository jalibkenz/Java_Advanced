class Tesco extends Thread {
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println("Tesco- Inheritted Thread Class->" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();

            }
        }
    }
}

class Foge {
    public void disp() throws InterruptedException {
        for (int i = 101; i < 106; i++) {
            System.out.println("Foge - without thread but manual thread->" + i);
            Thread.sleep(3000);

        }
    }
    public void disp_withoutthread() throws InterruptedException {
        for (int i = 101; i < 106; i++) {
            System.out.println(">Foge - purely without thread->" + i);
            Thread.sleep(3000);

        }
    }
}

public class ThreadMainClass4 {

    public static void main(String[] args) {

        Tesco tsc = new Tesco();
        Foge fog = new Foge();

        // running TESCO Method which has thread implemented
        tsc.start();

        // running FOGE Method in thread even though class has not implemented thread or
        // extended thread
        Thread manual_thread = new Thread(() -> {
            try {
                fog.disp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        manual_thread.start();

        System.out.println("without threads");
        Foge f = new Foge();
        try {
            f.disp_withoutthread();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

}
