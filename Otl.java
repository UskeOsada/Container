package com.example.othl;
import static com.example.othl.constant.Constant.*;

/**
 *
 */

/**
 *  Otr.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class Otr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner( System.in );

        OtheloLogic othelo = new OtheloLogic();
        String cmd;
        boolean end_flg = false;

        while( end_flg == false ) {
            othelo.printInfo();
            othelo.Draw();
            System.out.println( "wasd, p, q > ");
            cmd = sc.nextLine();

            if( cmd != null) {
                switch( cmd.charAt( 0 ) ) {
                    case UP:
                        othelo.move( UP );
                        break;
                    case DOWN:
                        othelo.move( DOWN );
                        break;
                    case RIGHT:
                        othelo.move( RIGHT );
                        break;
                    case LEFT:
                        othelo.move( LEFT );
                        break;
                    case PUT:
                        if( othelo.canFlip() ) {
                            othelo.putPiece();
                            othelo.turnFlip();
                        } else {
                            System.out.println("can't put.");
                        }
                        break;
                    case PASS:
                        othelo.turnFlip();
                        break;
                    case EXIT:
                        end_flg = true;
                        break;
                    default:
                        break;
                }
            }

            if( othelo.isFinished() == true ) end_flg = true;
        }

        System.out.println("******** GAME SET ********");
        System.out.println( othelo.checkWinner() );
    }
}
