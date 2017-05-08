package _EXTRA_Othelo;

import static _EXTRA_Othelo.Constants.*;

public class Board {

    private static Board singleton = new Board();
    private Piece[][] piece;

    /**
     * コンストラクタ
     * 外部から呼び出されず、はじめてgetInstanceされたときに実行される
     */
    private Board() {
        piece =new Piece[ SIZE ][ SIZE ];

        for(int i=0; i < SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                piece[i][j] = new Piece();
            }
        }
    }

    /**
     * シングルトン実装
     * 各クラスはboardをgetInstanceから得る
     * @return Boardインスタンス
     */
    public static Board getInstance() {
        return singleton;
    }

    /**
     * 盤を描画
     * 縦横を逆にしている
     *
     */
    // TODO: カーソルつくる
    public void draw(int pos_x, int pos_y) {
        String str = "";

        for(int j = 1; j <= SIZE; j++) {
            for(int i = 1; i <= SIZE; i++) {

                Piece piece = getPiece(i, j);
                if( piece.getColor() == BLACK) { str = "x"; }
                else if( piece.getColor() == WHITE) { str = "o"; }
                else { str = "."; }

                if( i == pos_x && j == pos_y ) {
                    str = "[" + str + "]";
                } else {
                    str = " " + str + " ";
                }
                str = " " + str + " ";

                System.out.print( str );
            }
            System.out.println( "" );
        }
    }

    public void flip(int x,int y) {
        if ( isValidPosition(x,y) == false ) return;
        getPiece(x, y).flip();
    }

    public boolean putPiece(int x,int y,int color) {

        Piece piece = getPiece(x, y);

        if( piece.getColor() != EMPTY ) return false;

        piece.setColor( color );

        flipPiece(x, y, color);
        return true;

    }

    public boolean putPiece( String position ) {
        String pos[] = position.split(",");

        int x = Integer.parseInt( pos[0] );
        int y = Integer.parseInt( pos[1] );
        int color =Integer.parseInt( pos[2] );

        return putPiece( x, y, color);
    }

    public Piece getPiece(int x, int y) {

        if( isValidPosition(x, y) == false ) {
            return null;
        }
        return piece[y-1][x-1];
    }

    public boolean isFinished() {
        for( int i=1; i <= SIZE; i++ ) {
            for(int j=1; j <= SIZE; j++) {
                if( getPiece(i,j).getColor() == EMPTY ) return false;
            }
        }

        return true;
    }

    public String checkWinner() {
        int white = 0;
        int black = 0;

        for( int i=1; i <= SIZE; i++ ) {
            for(int j=0; j <= SIZE; j++) {
                if( getPiece(i,j).getColor() == WHITE ) white++;
                else if ( getPiece(i,j).getColor() == BLACK ) black++;
            }
        }

        if( white < black ) {
            return "black win!";
        } else if( black < white ) {
            return "white win!";
        } else {
            return "draw.";
        }
    }

    public boolean canFlip(int x, int y, int color, int angle_x, int angle_y) {
        int current_x = x + angle_x;
        int current_y = y + angle_y;

        boolean canFlip =false;
        int piece = getPiece( current_x, current_y ).getColor();

        while( piece == color * FLIP ) { //enemy
            current_x = x + angle_x;
            current_y = y + angle_y;
            piece = getPiece( current_x, current_y ).getColor();

            if( piece == color ) canFlip = true;
        }
        return canFlip;
    }

    private boolean isValidPosition(int x, int y) {

        if( x < 0 || SIZE < x ) return false;
        if( y < 0 || SIZE < y ) return false;
        return true;
    }

    public boolean canFlip(int x, int y, int color) {

        if(    canFlip(x, y, color, -1, -1) //UL
            || canFlip(x, y, color, 0,-1)   //U
            || canFlip(x, y, color, 1,-1)   //UR
            || canFlip(x, y, color, 1,0)    //R
            || canFlip(x, y, color, 1,1)    //DR
            || canFlip(x, y, color, 0,1)    //D
            || canFlip(x, y, color, -1,1)   //DL
            || canFlip(x, y, color, -1,0)   //L
        ) return true;

        return false;
    }

    private void flipPiece(int x, int y, int color) {
        if( canFlip(x, y, color, -1, -1) ) flipPiece(x, y, color, -1, -1);
        if( canFlip(x, y, color, 0,-1) ) flipPiece(x, y, color, 0, -1);
        if( canFlip(x, y, color, 1,-1) ) flipPiece(x, y, color, 1, -1);
        if( canFlip(x, y, color, 1,0) ) flipPiece(x, y, color, 1, 0);
        if( canFlip(x, y, color, 1,1) ) flipPiece(x, y, color, 1, 1);
        if( canFlip(x, y, color, 0,1) ) flipPiece(x, y, color, 0, -1);
        if( canFlip(x, y, color, -1,1) ) flipPiece(x, y, color, -1, 1);
        if( canFlip(x, y, color, -1,0) ) flipPiece(x, y, color, -1, 0);
    }

    private void flipPiece(int x, int y, int color, int angle_x, int angle_y) {
        int current_x = x + angle_x;
        int current_y = y + angle_y;

        boolean canFlip =false;
        Piece piece = getPiece( current_x, current_y );

        while( piece.getColor() == color * FLIP ) { //enemy
            piece.flip();

            current_x = x + angle_x;
            current_y = y + angle_y;
            piece = getPiece( current_x, current_y );

            if( piece.getColor() == color ) canFlip = true;
        }
        return;
    }

}
