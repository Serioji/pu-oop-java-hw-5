package Pixel;

import java.awt.*;

public class DamagedPixel extends Pixel {
    public DamagedPixel(int row, int col, Color color){
        this.color = color;
        this.row  = row;
        this.col = col;

    }
    public void render(Graphics g) {

        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x+25, y+31, 20, 20);

    }
}
