/**
 *
 */
package com.example.othl;
import static com.example.othl.constant.Constant.*;

/**
 *  Board.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class OtheloLogic {

    private int turn;
    private int enemy;
    private Position currentPos;

    private Board board;


    public OtheloLogic() {
        board = new Board();

        turn = BLACK;
        enemy = WHITE;
        currentPos= new Position( 1, 1 );
    }

    public boolean putPiece() {
        if ( board.getPiece( currentPos.getX(), currentPos.getY() ) != EMPTY ) return false;

        board.setPiece( currentPos.getX(), currentPos.getY(), turn);

        for( Position pos : ANGLES ) {
            if( canFlip( pos ) ) flip( pos );
        }

        return true;
    }

    public void move(char angle) {

        switch( angle ) {
            case UP:
                currentPos.setY( currentPos.getY() - 1);
                if( currentPos.getY() < 1) {
                    currentPos.setY( 1 );
                }
                break;
            case DOWN:
                currentPos.setY( currentPos.getY() + 1);
                if( currentPos.getY() > SIZE) {
                    currentPos.setY( SIZE );
                }
                break;
            case LEFT:
                currentPos.setX( currentPos.getX() - 1);
                if( currentPos.getX() < 1) {
                    currentPos.setX( 1 );
                }
                break;
            case RIGHT:
                currentPos.setX( currentPos.getX() + 1);
                if( currentPos.getX() > SIZE ) {
                    currentPos.setX( SIZE );
                }
                break;
            default:
        }
    }

    public void Draw() {
        board.Draw( currentPos );
    }

    public void turnFlip() {
        turn *= FLIP;
        enemy *= FLIP;
    }

    public int getTurn() {
        return turn;
    }

    public void printInfo() {
        System.out.println("--------");
        System.out.println("currentPos [" + currentPos.getX() + ", " + currentPos.getY() + "]");
        System.out.println("turn:" + (turn == BLACK ? "x":"o") );
    }

    private boolean canFlip( Position angle ) {

        Position pos = currentPos.include( angle );
        boolean canFlip =false;
        int piece = board.getPiece( pos.getX(), pos.getY() );

        while( piece == enemy ) {
            pos = pos.include( angle );
            piece = board.getPiece( pos.getX(), pos.getY() );

            if( piece == turn ) canFlip = true;
        }

        return canFlip;
    }

    private void flip( Position angle ) {

        Position pos = currentPos.include( angle );
        int piece = board.getPiece( pos.getX(), pos.getY() );

        while( piece == enemy ) {
            board.setPiece( pos.getX(), pos.getY() ,turn);
            pos = pos.include( angle );
            piece = board.getPiece( pos.getX(), pos.getY() );
        }

        return;
    }

    public boolean isFinished() {

        for( int i = 1; i<= SIZE; i++) {
            for(int j = 1; j <= SIZE; j++) {
                if ( board.getPiece(i, j) == EMPTY ) return false;
            }
        }

        return true;
    }

    public String checkWinner() {
        int cntBlack = 0;
        int cntWhite = 0;

        for( int i = 1; i<= SIZE; i++) {
            for(int j = 1; j <= SIZE; j++) {
                if ( board.getPiece(i, j) == BLACK ) cntBlack++;
                else if ( board.getPiece(i, j) == WHITE ) cntWhite++;
            }
        }

        if( cntBlack < cntWhite ) return "WHITE WIN!";
        else if( cntWhite < cntBlack) return "BLACK WIN!";
        else return "DRAW";
    }

    public boolean canFlip() {
        for( Position pos : ANGLES ) {
            if( canFlip( pos ) ) return true;
        }

        return false;
    }

    public Board getBoard() {
        return board;
    }

    public Position getCurrentPos() {
        return currentPos;
    }
}
