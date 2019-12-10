package bankocr.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Entry {

    List<Cell> cells = new ArrayList<>();

    public Entry(String firstLine, String secondLine, String thirdLine) {
        while (!firstLine.isEmpty()) {
            Cell cell = new Cell(firstLine.substring(0, 3) + secondLine.substring(0, 3) + thirdLine.substring(0, 3));
            cells.add(cell);
            firstLine = firstLine.substring(3);
            secondLine = secondLine.substring(3);
            thirdLine = thirdLine.substring(3);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        cells.forEach(cell -> stringBuilder.append(cell.toString()));

        Integer malformedCharacters = stringBuilder.toString().chars()
                .mapToObj(c -> (char) c)
                .mapToInt(x -> (x== '?') ? 1 : 0)
                .sum();


        if (malformedCharacters > 0) {stringBuilder.append(" ILL");};

        return stringBuilder.toString();
    }


    public int distance() {
        int distSum = 0;
        for (Cell c : this.cells) {
            distSum += c.distance();
        }
        return distSum;
    }
}
