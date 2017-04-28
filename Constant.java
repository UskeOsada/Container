
package com.example.othl.constant;
import com.example.othl.Position;

public class Constant {

    public static final int FLIP = -1;
    public static final int ERROR = 9;

    // board status
    public static final int BLACK = 1;
    public static final int WHITE = -1;
    public static final int EMPTY = 0;

    // board size
    public static final int SIZE = 8;

    // command
    public static final char UP = 'w';
    public static final char LEFT = 'a';
    public static final char DOWN = 's';
    public static final char RIGHT = 'd';
    public static final int PUT = 'p';
    public static final int PASS = 'x';
    public static final int EXIT= 'q';

    // U UR R DR D DL L UL
    public static final Position[] ANGLES = {
            new Position( 0, -1),
            new Position( 1, -1),
            new Position( 1,  0),
            new Position( 1,  1),
            new Position( 0,  1),
            new Position(-1,  1),
            new Position(-1,  0),
            new Position(-1, -1)
    };

}
