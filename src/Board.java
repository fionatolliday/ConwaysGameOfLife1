public class Board {

    //    create a new instance of each token to make it usable on the board
    Token deadCell = new Token();
    Token liveCell = new Token();


    private String[][] board;


    public String[][] getBoard() {
        return board;
    }


    public Board() {
        //  Initialize array of arrays
        this.board = new String[10][10];

//  Use a for loop to first fill the board with dead cells as there are more dead cells than live
//  cells

        for (int outerArray = 0; outerArray < board.length; outerArray++) {
            for (int innerArray = 0; innerArray < board[0].length; innerArray++) {
                this.board[outerArray][innerArray] = deadCell.getDeadCellToken();
            }
            this.board[2][5] = liveCell.getLiveCellToken();

        }

    }


    public void printBoard() {
        for (int outerArray = 0; outerArray < board.length; outerArray++) {
            for (int innerArray = 0; innerArray < board[0].length; innerArray++) {
                System.out.print(board[outerArray][innerArray]);
            }
            System.out.println();
        }
    }

    public String liveCellCoordinate() {
        String outerCoord = "";
        String innerCoord = "";
        for (int outerArray = 0; outerArray < board.length; outerArray++) {
            for (int innerArray = 0; innerArray < board[0].length; innerArray++) {
                if (board[outerArray][innerArray] == liveCell.getLiveCellToken()){
                    outerCoord = Integer.toString(outerArray);
                    innerCoord = Integer.toString(innerArray);
                }
            }

        } return outerCoord + "," + innerCoord;

    }

    public String neighbourCoordinates() {
        
        return null;
    }




}
