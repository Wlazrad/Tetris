package Tetrisv2;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JPanel implements Runnable {

    static Tetris tetris = new Tetris();

    static JFrame okno = new JFrame("Tetris");

    static Plansza plansza = new Plansza();
    static Thread watek = new Thread(tetris);

    boolean start = false;
    short op = 50;



    Tetris()
    {
super();
setBackground(Color.DARK_GRAY);
setLayout(null);
start = true;



    }

    public static void main(String[] args) {
	okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	okno.add(tetris);
	okno.setSize(600,600);
	okno.setLocationRelativeTo(null);
	okno.setResizable(false);
	plansza.setLocation(10,10); tetris.add(plansza);
	okno.setVisible(true);
	watek.start();


    }
    @SuppressWarnings("static-access")
    @Override
    public void run() {
        long wait, startCzas, cyklCzas;
        while (start){
            startCzas = System.nanoTime();

            plansza.run();


            cyklCzas =System.nanoTime();

            wait = op - cyklCzas / 1000000;
            if (wait<=0) wait =3;
            try {
                watek.sleep(op);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(op+">"+wait);



        }
    }
}
