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

//    int[][] neighbourArray = new int[8][2];

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

    public String liveNeighbourCoordinates() {
        String[] liveNeighCoordinates = neighbourCoordinates().split(" ");
        String neighbour1 = liveNeighCoordinates[0];
        String[] n1 = neighbour1.split(",");
        String n1Outer = n1[0];
        String n1Inner = n1[1];

        if (board[n1Outer][n1Inner] == liveCell.getLiveCellToken()){
            n1Outer = Integer.toString(n1Outer);
            n1Inner = Integer.toString(n1Inner);
        }



//        String neighbour2 = liveNeighCoordinates[1];
//        String neighbour3 = liveNeighCoordinates[2];
//        String neighbour4 = liveNeighCoordinates[3];
//        String neighbour5 = liveNeighCoordinates[4];
//        String neighbour6 = liveNeighCoordinates[5];
//        String neighbour7 = liveNeighCoordinates[6];
//        String neighbour8 = liveNeighCoordinates[7];

//        for (int index = 0; index < liveNeighCoordinates.length; index++){
//            if (liveNeighCoordinates == liveCell.getLiveCellToken()){
//
//            }
//        }
//
        return null;
    }



}
