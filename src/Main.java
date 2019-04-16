import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board gameBoard = new Board();
        Scanner userInput = new Scanner(System.in);

//      Display initial state
        gameBoard.printBoard();
        System.out.println();

//      Display next generation
        gameBoard.printNextState();

        }

}


//make sure i pass through a future board (all of the coordinates) rather than just one
// coordinate which is currently.

//Main needs to print the board as a timeline. Each time should evolve on the click (user input)
// of a button. Q should exit conways.