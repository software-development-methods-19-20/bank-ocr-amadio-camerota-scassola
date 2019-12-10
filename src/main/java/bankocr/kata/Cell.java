package bankocr.kata;

import java.util.HashMap;
import java.util.Map;

public class Cell {

    private static final String ZERO_CELL =
                    " _ " +
                    "| |" +
                    "|_|";

    private static final String ONE_CELL =
                    "   " +
                    "  |" +
                    "  |";

    private static final String TWO_CELL =
                    " _ "+
                    " _|"+
                    "|_ ";

    private static final String THREE_CELL =
                    " _ " +
                    " _|" +
                    " _|";

    private static final String FOUR_CELL =
                    "   " +
                    "|_|" +
                    "  |";
    private static final String FIVE_CELL =
                    " _ " +
                    "|_ " +
                    " _|";
    private static final String SIX_CELL =
                    " _ "+
                    "|_ "+
                    "|_|";

    private static final String SEVEN_CELL =
                    " _ " +
                    "  |" +
                    "  |";

    private static final String EIGHT_CELL =
		            " _ " +
                    "|_|" +
                    "|_|";

    private static final String NINE_CELL =
                    " _ " +
                    "|_|" +
                    " _|";

    private static  Map<String, String> numbers = new HashMap<>();
    static {
        numbers.put(ZERO_CELL, "0");
        numbers.put(ONE_CELL,  "1");
        numbers.put(TWO_CELL,  "2");
        numbers.put(THREE_CELL,"3");
        numbers.put(FOUR_CELL, "4");
        numbers.put(FIVE_CELL, "5");
        numbers.put(SIX_CELL,  "6");
        numbers.put(SEVEN_CELL,"7");
        numbers.put(EIGHT_CELL,"8");
        numbers.put(NINE_CELL, "9");
    };



    private String cellAsText;


    public Cell(String cellAsText) {
        this.cellAsText = cellAsText;
    }

    @Override
    public String toString() {
        String output = numbers.get(cellAsText);
        if( output == null) {
            return "?";
        }
        return output;
    }

    public int distance() {
        return 1;
    }
}
