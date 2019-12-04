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

    private String cellAsText;

    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

    @Override
    public String toString() {
        return ZERO_CELL.equals(cellAsText) ? "0": "1";
    }
}
