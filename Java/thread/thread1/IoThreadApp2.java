package Java.thread.thread1;

import javax.swing.JOptionPane;

public class IoThreadApp2 {

    public static void main(String[] args) {

        SampleThread st = new SampleThread();
        st.start();

        String input = JOptionPane.showInputDialog("값을 입력하세요");
        System.out.println("입력한 값은 " + input + "입니다");
    }
}

class SampleThread extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {
            }

        }
    }
}