import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Board gameBoard = new Board();
        Scanner userInput = new Scanner(System.in);

//      Display initial state
        gameBoard.printBoard();
        System.out.println();

        for (int outerArray = 0; outerArray < gameBoard.getBoard().length; outerArray++) {
            for (int innerArray = 0; innerArray < gameBoard.getBoard()[0].length; innerArray++) {
                System.out.print(gameBoard.getBoard()[outerArray][innerArray]);
            }
            gameBoard.whatWillTheNextStateBe(2, 5);
            gameBoard.printBoard();
            System.out.println();
        }

    }

}


//make sure i pass through a future board (all of the coordinates) rather than just one
// coordinate which is currently.

//Main needs to print the board as a timeline. Each time should evolve on the click (user input)
// of a button. Q should exit conways.