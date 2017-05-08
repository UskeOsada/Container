package _EXTRA_Othelo;

public abstract class CPU extends Player{

    public CPU() {
        super();
    }

    public CPU(int color) {
        super(color);
    }

    public CPU(int x, int y, int color) {
        super( x, y, color );
    }

    public final void putPiece() {

        String next = nextPut();
        board.putPiece( next );
    }

    protected abstract String nextPut();

    protected abstract void study();

}