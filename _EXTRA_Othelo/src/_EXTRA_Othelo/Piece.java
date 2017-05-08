package _EXTRA_Othelo;

import static _EXTRA_Othelo.Constants.*;

public class Piece {
    private int color;

    public Piece(int color) {
        this.color = color;
    }

    public Piece() {
        this.color = EMPTY;
    }

    public void flip() {
        color *= FLIP;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color ) {
        if( this.color == EMPTY) {
            this.color = color;
        }
    }
}
