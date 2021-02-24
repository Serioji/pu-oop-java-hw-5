package Pixel;

import java.awt.*;

public class GameTile {
    public static final int TILE_SIZE = 10;
    private int row;
    private int col;
    private int tileSize;
    private Color color;
    /**
     *
     * @author Vasil
     * @param "това е конструктора за големината на ходните полета и инициализирането им на бойното поле"
     */
    public GameTile(int row, int col, Color color) {

        this.row = row;
        this.col = col;
        this.tileSize = 6;
        this.color=color;
    }
    public void render(Graphics g) {
        /**
         *
         * @author Vasil
         * @param "това е визуализирането на бойното поле със съответния му цвят и параметри за изчисляването на големината му"
         */
        g.setColor(Color.BLACK);
        g.fillRect(8,31,641,641);

        }


    }

