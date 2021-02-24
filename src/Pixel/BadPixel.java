package Pixel;

import java.awt.*;

public class BadPixel extends Pixel{
    public BadPixel(int row, int col, Color color){
        this.color = color;
        this.row  = row;
        this.col = col;

    }
    public void render(Graphics g) {

        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x+9, y+32, 8, 8);

    }
}
