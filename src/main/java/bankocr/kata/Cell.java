package bankocr.kata;



public class Cell {

    private static final String ZERO_CELL =
                    " _ " +
                    "| |" +
                    "|_|";

    private static final String FOUR_CELL =
		    "   " +
                    "|_|" +
                    "  |";
    private static final String EIGHT_CELL =
		    " _ " +
                    "|_|" +
                    "|_|";

    private static final String TWO_CELL =
                    " _ "+
                    " _|"+
                    "|_ ";

    private static final String SIX_CELL =
                    " _ "+
                    "|_ "+
                    "|_|";





>>>>>>> 33aa49d27af5605e6768029ddf0ae06533465960
    private String cellAsText;

    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

    @Override
    public String toString() {
        return ZERO_CELL.equals(cellAsText) ? "0": "1";
    }
}
