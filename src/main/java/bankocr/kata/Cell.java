package bankocr.kata;

public class Cell {

    private static final String ZERO_CELL =
                    " _ " +
                    "| |" +
                    "|_|";

    private static final String THREE_CELL =
                    " _ " +
                    " _|" +
                    " _|";

    private static final String SEVEN_CELL =
                    " _ " +
                    "  |" +
                    "  |";


    private String cellAsText;

    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

    @Override
    public String toString() {
        return ZERO_CELL.equals(cellAsText) ? "0": "1";
    }
}
