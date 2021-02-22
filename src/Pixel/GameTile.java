package Pixel;

import java.awt.*;

public class GameTile {
    public static final int TILE_SIZE = 100;
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
        this.tileSize = 100;
        this.color = color;
    }

    public void render(Graphics g) {
        /**
         *
         * @author Vasil
         * @param "това е визуализирането на бойното поле със съответния му цвят и параметри за изчисляването на големината му"
         */

        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);

    }
}
