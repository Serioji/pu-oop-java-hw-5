package Pixel;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ThreadLocalRandom;

public class gameboard extends JFrame implements MouseListener {
        public static final int TILE_SIDE_COUNT =65;
        protected BadPixel[][] badPixel;
        protected DamagedPixel[][] damagedPixel;
        protected HealthyPixel[][] healthyPixel;
        int randomNumber3;
        double randomNumber4;
        private Color pink1;
        int checkCounter;
        int count = 3;
        int badPixelCount = 0;

    public gameboard() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                main.onExit(0,randomAlphaNumeric(10));
            }
        });
        this.setSize(700, 700);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(randomAlphaNumeric(10));
        this.setVisible(true);
        this.addMouseListener(this);
        this.badPixel = new BadPixel[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        this.healthyPixel = new HealthyPixel[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        this.damagedPixel = new DamagedPixel[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        pixelRender();
    }
    private void pixelRender(){

        for(int i = 0; i<=64; i++){
            for(int j = 0; j<=64; j++){
                 {
                     randomNumber3 = ThreadLocalRandom.current().nextInt(0, 3);
                     if (randomNumber3 == 0){
                         pink1= Color.blue;
                     }
                     if(randomNumber3 == 1){
                         pink1= Color.red;
                     }
                     if(randomNumber3 == 2){
                         pink1= Color.green;
                     }
                    randomNumber4 = ThreadLocalRandom.current().nextDouble(0, 10);
                    if (randomNumber4 >= 0 && randomNumber4 <2){
                        this.badPixel[i][j] = (new BadPixel(i,j,pink1));
                    }

                     if(randomNumber4 >= 2 && randomNumber4 < 5.2){
                         this.damagedPixel[i][j] = (new DamagedPixel(i,j,pink1));
                     }
                     if(randomNumber4 <= 10 && randomNumber4 >= 5.2){
                         this.healthyPixel[i][j] = (new HealthyPixel(i,j,pink1));
                         checkCounter++;
                     }

                }
            }

        }

    }
    @Override
    public void paint(Graphics g) {
        /**
         *
         * @author Vasil
         * @param "визуализиране на игралните пешки върху бойното поле чрез два for цикъла и повикване на точната им позиция чрез row,col"
         */

        super.paint(g);


                this.renderGameTile(g,0, 0);

        for (int row = 0; row < 64; row++) {
            for (int col = 0; col < 64; col++) {


                this.renderGamePice(g,row,col);

            }
        }
    }
    private Color getTileColor(int row, int col) {

        return Color.white;
    }
    private void renderGameTile(Graphics g, int row, int col) {
        Color tileColor = this.getTileColor(row, col);
        GameTile tile = new GameTile(row, col, tileColor);
        tile.render(g);
    }
    private void renderGamePice(Graphics g, int row, int col) {
        if (this.hasBadPixel(row, col)) {
           BadPixel p = (BadPixel) this.getBadPixel(row, col);
            p.render(g);

        }
        if (this.hasDamagedPixel(row, col)) {
           DamagedPixel p1 = (DamagedPixel) this.getDamagePixel(row, col);
            p1.render(g);

        }
        if (this.hasHealthyPixel(row,col)){
            HealthyPixel p2 = (HealthyPixel) this.getHealthyPixel(row,col);
            p2.render(g);
        }
    }
    private BadPixel getBadPixel(int row, int col) {
        return this.badPixel[row][col];
    }
    private boolean hasBadPixel (int row, int col) {
        return this.getBadPixel(row, col) != null;
    }
    private DamagedPixel getDamagePixel(int row,int col){
        return this.damagedPixel[row][col];
    }
    private boolean hasDamagedPixel (int row,int col){
        return this.getDamagePixel(row,col) !=null;
    }
    private HealthyPixel getHealthyPixel(int row,int col){
        return this.healthyPixel[row][col];
    }
    private boolean hasHealthyPixel(int row,int col){
        return this.getHealthyPixel(row,col) !=null;
    }
    private int getBoardDimensionBasedOnCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());
        row -= 3;
        col -= 1;

        if (hasDamagedPixel(row, col) && damagedPixel[row][col].color != Color.BLACK) {

            if (count == 0) {
                damagedPixel[row][col].color = Color.BLACK;
                count = 3;
                badPixelCount++;
            } else
                count--;
        }
        if (hasBadPixel(row, col) && badPixel[row][col].color != Color.BLACK) {

                badPixel[row][col].color = Color.BLACK;
                badPixelCount++;
        }
        if (badPixelCount == 2048) {
            UI.render(this,"Броенето свърши","Телефона има 50% изгорели пискели");
        }
        this.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    /**
         *
         * @author Vasil
         * @param "това е импламентирането на вида фигури във игралното поле както беше показано във видеото на Господин Петров"
         */
}
