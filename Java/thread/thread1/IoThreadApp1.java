package Java.thread.thread1;

import javax.swing.JOptionPane;


public class IoThreadApp1 {

    public static void main(String[] args) throws Exception {

/**
 * 하나의 쓰레드로 사용자의 입력받는 작업
 * 화면에 숫자를 출력하는 작업
 *
 * 사용자가 입력을 마치기 전까지 화면에 숫자가 출력을 하지 않다가
 * 입력을 미친후에 화면에 숫자가 출력이 된다.
 */

        String input = JOptionPane.showInputDialog("값을 입력하세요");
        System.out.println("입력한 값은 " + input + "입니다");

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500); // 0.5초 지연
            } catch (Exception e) {
            }


        }
    }
}