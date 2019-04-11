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
    String[] liveCoordinates = liveCellCoordinate().split(",");
    Integer outerLiveCoord = Integer.parseInt(liveCoordinates[0]);
    Integer innerLiveCoord = Integer.parseInt(liveCoordinates[1]);

    Integer previousOuterCoord = (outerLiveCoord-1);
    Integer nextOuterCoord = (outerLiveCoord+1);

    Integer previousInnerCoord = (innerLiveCoord-1);
    Integer nextInnerCoord = (innerLiveCoord+1);



    String neighbouringCoordinates =
            (previousOuterCoord + "," + previousInnerCoord + " ")+
                    (previousOuterCoord + "," + innerLiveCoord + " ")+
                    (previousOuterCoord + "," + nextInnerCoord + " ")+
                    (outerLiveCoord + "," + previousInnerCoord + " ")+
                    (outerLiveCoord + "," + nextInnerCoord + " ")+
                    (nextOuterCoord  + "," + previousInnerCoord  + " ")+
                    (nextOuterCoord  + "," + innerLiveCoord   + " ")+
                    (nextOuterCoord  + "," + nextInnerCoord);

        return neighbouringCoordinates;
    }

    // at 2,5 how many live neighbours are there
    // numberOfLiveNeighboursAround(2,5)
    public int numberOfLiveNeighboursAround(int row, int col) {

        int numberOfLiveNeighbours = 0;

        for(int outer = row - 1; outer <= row + 1; outer++) {
            // make sure outer value is not out of bounds
            for(int inner = col - 1; inner <= col + 1; inner++) {
                // make sure inner value is not out of bounds
                // if(!board[2][5].equals(board[2][5]) we don't want to do anything to this square
                // so move on
                if(!board[row][col].equals(board[outer][inner])) {
                    if(board[outer][inner] == liveCell.getLiveCellToken()) {
                        numberOfLiveNeighbours++;
                    }
                }
            }
        }
        return numberOfLiveNeighbours;
    }

    




}
