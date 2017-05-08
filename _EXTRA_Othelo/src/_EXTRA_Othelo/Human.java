package _EXTRA_Othelo;

public class Human extends Player {

    public Human() {
        super();
    }

    public Human(int color) {
        super(color);
    }

    public Human(int x, int y, int color) {
        super( x, y, color );
    }

    public void putPiece() {
        board.putPiece(x, y, color);
    }

}