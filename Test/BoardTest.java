import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board newBoard = new Board();

    @Test
    public void getBoard() {

    }

    @Test
    public void printBoard() {
    }

    @Test
    public void liveCellCoordinate() {
        String expectedCoordinateResults = "2,5";
        String result = newBoard.liveCellCoordinate();
        Assert.assertEquals(expectedCoordinateResults, result);
    }

    @Test
    public void returnEightNeighbouringCoordinates() {
        String expectedCoordinateResults ="1,4 1,5 1,6 2,4 2,6 3,4 3,5 3,6";
        String result = newBoard.neighbourCoordinates();
        Assert.assertEquals(expectedCoordinateResults, result);
    }


}