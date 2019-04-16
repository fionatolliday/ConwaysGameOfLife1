import java.io.OptionalDataException;

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
//            this.board[2][6] = liveCell.getLiveCellToken();
//            this.board[3][5] = liveCell.getLiveCellToken();
//            this.board[3][6] = liveCell.getLiveCellToken();
//            this.board[4][5] = liveCell.getLiveCellToken();
//            this.board[4][4] = liveCell.getLiveCellToken();
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


    // at 2,5 how many live neighbours are there
    // numberOfLiveNeighboursAround(2,5)
    public int numberOfLiveNeighboursAround(int row, int col) {

        int numberOfLiveNeighbours = 0;

        for(int outer = row - 1; outer <= col + 1; outer++) {
            // make sure outer value is not out of bounds
            for(int inner = - 1; inner <= + 1; inner++) {
                // make sure inner value is not out of bounds
                // if(!board[2][5].equals(board[2][5]) we don't want to do anything to this square
                // so move on
                if (row == outer && col == inner){
                    continue;
                } else if(board[outer][inner] == liveCell.getLiveCellToken()) {
                        numberOfLiveNeighbours++;
                    }

            }
        }
        return numberOfLiveNeighbours;
    }

    String[][] futureState = new String[10][10];
    public void nextState() {
//        Create a new array to house the next state

//        Go through every cell
        for (int outer = 0; outer < futureState.length; outer++){
            for (int inner = 0; inner < futureState.length; inner++){

//         Now, i have the number of live neighbours above, so now need to apply that here, but
//         need to use those neighbours to implement the life and death rules
                if(board[outer][inner] == liveCell.getLiveCellToken()){
                    if (numberOfLiveNeighboursAround(outer, inner) < 2 || numberOfLiveNeighboursAround(outer,
                            inner) > 3) {
                        futureState[outer][inner] = deadCell.getDeadCellToken();
                    }
                } else if(board[outer][inner] == deadCell.getDeadCellToken()) {
                    if (numberOfLiveNeighboursAround(outer, inner) == 3){
                        futureState[outer][inner] = liveCell.getLiveCellToken();
                    }

                }

            }
        }




    }

    public void printNextState() {
        for (int outerArray = 0; outerArray < futureState.length; outerArray++) {
            for (int innerArray = 0; innerArray < futureState.length; innerArray++) {
                System.out.print(futureState[outerArray][innerArray]);
            }
            System.out.println(futureState);
        }

    }



//    public void whatWillTheNextStateBe(int row, int col) {
////        less than 2 live neighbours = dies
////        more than 3 live neighbours = dies
////        if 2 or 3 live neighbours = no change
////        if there is a dead cell with 3 live neighbours, it becomes live
//
//        if(board[row][col] == liveCell.getLiveCellToken()){
//            if (numberOfLiveNeighboursAround(row, col) < 2 || numberOfLiveNeighboursAround(row,
//                    col) > 3) {
//                board[row][col] = deadCell.getDeadCellToken();
//            }
//        } else if(board[row][col] == deadCell.getDeadCellToken()) {
//            if (numberOfLiveNeighboursAround(row, col) == 3){
//                board[row][col] = liveCell.getLiveCellToken();
//            }
//
//        }
//
//
//
//    }






    //    public String liveCellCoordinate() {
//        String outerCoord = "";
//        String innerCoord = "";
//        for (int outerArray = 0; outerArray < board.length; outerArray++) {
//            for (int innerArray = 0; innerArray < board[0].length; innerArray++) {
//                if (board[outerArray][innerArray] == liveCell.getLiveCellToken()){
//                    outerCoord = Integer.toString(outerArray);
//                    innerCoord = Integer.toString(innerArray);
//                }
//            }
//
//        } return outerCoord + "," + innerCoord;
//
//    }



//    public String neighbourCoordinates() {
//    String[] liveCoordinates = liveCellCoordinate().split(",");
//    Integer outerLiveCoord = Integer.parseInt(liveCoordinates[0]);
//    Integer innerLiveCoord = Integer.parseInt(liveCoordinates[1]);
//
//    Integer previousOuterCoord = (outerLiveCoord-1);
//    Integer nextOuterCoord = (outerLiveCoord+1);
//
//    Integer previousInnerCoord = (innerLiveCoord-1);
//    Integer nextInnerCoord = (innerLiveCoord+1);
//
//
//
//    String neighbouringCoordinates =
//            (previousOuterCoord + "," + previousInnerCoord + " ")+
//                    (previousOuterCoord + "," + innerLiveCoord + " ")+
//                    (previousOuterCoord + "," + nextInnerCoord + " ")+
//                    (outerLiveCoord + "," + previousInnerCoord + " ")+
//                    (outerLiveCoord + "," + nextInnerCoord + " ")+
//                    (nextOuterCoord  + "," + previousInnerCoord  + " ")+
//                    (nextOuterCoord  + "," + innerLiveCoord   + " ")+
//                    (nextOuterCoord  + "," + nextInnerCoord);
//
//        return neighbouringCoordinates;
//    }






}
