public class Token {


    private String liveCellToken = "\uD83D\uDE07";
    private String deadCellToken = "\uD83D\uDE08";


    public Token() {
        this.liveCellToken = liveCellToken;
        this.deadCellToken = deadCellToken;
    }


    public String getLiveCellToken() {
        return liveCellToken;
    }

    public String getDeadCellToken() {
        return deadCellToken;
    }






}
