package com.example.othl;
import static com.example.othl.constant.Constant.*;

public class Board {

    private int[][] board;

    public Board() {

       board  = new int[ SIZE ][ SIZE ];

       for(int i=0; i < SIZE; i++) {
           for(int j=0; j < SIZE; j++) {
               board[i][j] = EMPTY;
           }
       }

       setPiece( 4, 4, BLACK );
       setPiece( 5, 5, BLACK );
       setPiece( 4, 5, WHITE );
       setPiece( 5, 4, WHITE );

    }

    public int getPiece(int x, int y) {
        if( x < 1 || SIZE < x) return ERROR;
        if( y < 1 || SIZE < y) return ERROR;

        return board[ y - 1 ][ x - 1 ];
    }

    public boolean setPiece(int x, int y, int piece) {
        board[ y - 1 ][ x - 1 ] = piece;
        return true;
    }

    public void Draw(Position current_pos) {
        String str = "";

        for(int i = 1; i <= SIZE; i++) {
            for(int j = 1; j <= SIZE; j++) {

                int piece = getPiece(j, i);
                if( piece == BLACK) { str = "x"; }
                else if( piece == WHITE) { str = "o"; }
                else { str = "."; }

                if( i == current_pos.getY() && j == current_pos.getX() ) {
                    str = "[" + str + "]";
                } else {
                    str = " " + str + " ";
                }

                System.out.print( str );
            }
            System.out.println( "" );
        }
    }
}
