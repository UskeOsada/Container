package _EXTRA_Othelo;
import static _EXTRA_Othelo.Constants.*;

public class Othelo {

    static Player human = new Human( BLACK );
    static Player cpu = new CPU_v01( WHITE );
    static Player turn = human;

    static Board board = Board.getInstance();

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner( System.in );

        String cmd = "";
        boolean end_flg = false;

        while( end_flg == false ) {

            if( turn.equals( human ) ) {
                System.out.println("******** HUMAN'S TURN ********");
                System.out.println("pos[" + turn.getX() + "," + turn.getY() + "]");
            } else {
                System.out.println("******** CPU'S TURN ********");
                System.out.println("pos[" + turn.getX() + "," + turn.getY() + "]");
            }

            board.draw( turn.getX(), turn.getY() );
            System.out.println( "wasd, p, q > ");
            cmd = sc.nextLine();

            if( cmd != null) {
                switch( cmd.charAt(0) ) {
                    case UP:
                        turn.move(0, -1);
                        break;
                    case DOWN:
                        turn.move(0, 1);
                        break;
                    case RIGHT:
                        turn.move(1, 0);
                        break;
                    case LEFT:
                        turn.move(-1, 0);
                        break;
                    case PUT:
                        if( board.canFlip(turn.getX(), turn.getY(), turn.getColor() ) ) {
                            turn.putPiece();
                            turnFlip();
                        } else {
                            System.out.println("can't put.");
                        }
                        break;
                    case PASS:
                        turnFlip();
                        break;
                    case QUIT:
                        end_flg = true;
                        break;
                    default:
                        break;
                }
            }

            if( board.isFinished() == true ) end_flg = true;
        }

        System.out.println("******** GAME SET ********");
        System.out.println( board.checkWinner() );
    }

    private static void turnFlip() {
        if( turn.equals( human ) ) {
            turn = cpu;
        } else {
            turn = human;
        }
    }

}
