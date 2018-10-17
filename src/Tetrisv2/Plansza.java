package Tetrisv2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Plansza extends ACanvas implements MouseListener {

    final static  short SIZE=25;
    final static short SZE = SIZE * 10;
    final static short WYS = SIZE * 20;

    final Color[] KOLOR = {Color.GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN,
    Color.magenta, Color.orange, Color.yellow, Color.white};
    byte[][] tab = new byte[10][20];
    Random los = new Random();

    Plansza(){
        super(SZE, WYS); addMouseListener(this);
        tab[1][1]=1;    }

    @Override
    public void drawImage() {
        cmpPlansza();
        drukPlansza();

    }
    private void drukPlansza(){
        for(byte x=0; x<10; x++)
            for(byte y=0; y<20; y++){

            grafika.setColor(KOLOR[tab[x][y]]);
            grafika.fillRect(x*SIZE, y*SIZE, SIZE, SIZE);
            grafika.setColor(Color.BLACK);
            if (tab[x][y]>0) grafika.drawRect(x*SIZE, y*SIZE, SIZE-1, SIZE-1);
            }
    }

    private boolean isLinia(byte y)

    {
        for (byte x = 0; x < 10; x++) {
            if (tab[x][y] == 0) return false;
        }
        return true;
    }
    private void setLInia(byte y){
        for (byte x=0; x<10; x++) tab[x][y]=8;
    }
    private void downPlansza(byte y){
        for(byte ty=y; ty>0; ty--)
            for(byte x=0; x<10; x++) tab[x][ty]=tab[x][ty-1];
        for(byte x=0; x<10; x++) tab[x][0]=0;

    }
    private void cmpPlansza(){
        for (byte y=0; y<20; y++){
            if (tab[0][y]==8) downPlansza(y);
            if (isLinia(y)) setLInia(y);

        }
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tab[e.getX()/SIZE][e.getY()/SIZE]=1;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
