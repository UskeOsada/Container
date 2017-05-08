package _EXTRA_Othelo;

import static _EXTRA_Othelo.Constants.*;

public abstract class Player {

    protected int x;
    protected int y;
    protected int color;
    protected static Board board = Board.getInstance();

    public Player() {
        x = 1;
        y = 1;
        color = BLACK;
    }

    public Player(int color) {
        x = 1;
        y = 1;
        this.color = color;
    }

    public Player(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;

        if( x <= 0 ) {
            x = 1;
        } else if( SIZE < x) {
            x = SIZE;
        }

        if( y <= 0 ) {
            y = 1;
        } else if( SIZE < y) {
            y = SIZE;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public abstract void putPiece();
}
