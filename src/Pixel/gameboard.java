package Pixel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameboard extends JFrame implements MouseListener {
        /**
         *
         * @author Vasil
         * @param "това е игралната дъска със координатите на съответните пешки и визуализирането на дъската "
         */
        public static final int TILE_SIDE_COUNT =64;


    public gameboard() {

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

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
    /**
         *
         * @author Vasil
         * @param "това е импламентирането на вида фигури във игралното поле както беше показано във видеото на Господин Петров"
         */
}
